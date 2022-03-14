package com.budailad.http;

import com.budailad.entity.MinioFiles;
import com.budailad.model.MinioRespond;
import com.budailad.service.MinioFilesService;
import io.minio.errors.MinioException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.budailad.utils.MinioUtil;

import java.awt.print.PrinterException;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping(value = "/api/healthcare/files")
public class FilesController {

    @Autowired
    private MinioUtil minioUtil;

    @Autowired
    private MinioFilesService minioFilesService;

    @PostMapping("/upload")
    public boolean Upload(@RequestParam(name = "files") MultipartFile file,
                          @RequestParam(name = "ID") String ID) {
        if(file.isEmpty()){
            return false;
        }

        boolean tag = false;
        MinioRespond minioRespond = null;
        String bucketName = "webtest";
        try {
            minioRespond = minioUtil.uploadFile(file, bucketName);
            if(minioRespond.getObjectWriteResponse() != null){
                MinioFiles minioFiles = new MinioFiles();
                minioFiles.setAccountCode(ID);
                minioFiles.setFileName(minioRespond.getOriginName());
                minioFiles.setInTime(new Date());
                minioFiles.setMinioBucket(bucketName);
                minioFiles.setMinioPath(minioRespond.getFileName());

                MinioFiles res = minioFilesService.insert(minioFiles);
                if(res != null){
                    tag = true;
                }
            }
        } catch (Exception e) {
            log.error("上传失败 : [{}]", Arrays.asList(e.getStackTrace()));
        }
        return tag;
    }

    @PostMapping("/download")
    public ResponseEntity<byte[]> Download(@RequestParam(name = "accountCode") String ID) throws Exception {
        ResponseEntity<byte[]> responseEntity = null;

        MinioFiles files = minioFilesService.queryById(ID);
        try(InputStream in = minioUtil.getObject(files.getMinioBucket(), files.getMinioPath());
            ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            if (in == null) {
                throw new PrinterException("文件不存在");
            }

            byte[] buffer = new byte[4096];
            int n = 0;
            while (-1 != (n = in.read(buffer))) {
                out.write(buffer, 0, n);
            }
            byte[] bytes = out.toByteArray();

            //设置header
            HttpHeaders httpHeaders = new HttpHeaders();
            String orginName = URLEncoder.encode(files.getFileName(), "UTF-8");

            httpHeaders.add("Accept-Ranges", "bytes");
            httpHeaders.add("Content-Length", bytes.length + "");
            httpHeaders.add("Content-disposition", "attachment; filename=" + orginName);
            httpHeaders.add("Content-Type", "text/plain;charset=utf-8");

            responseEntity = new ResponseEntity<byte[]>(bytes, httpHeaders, HttpStatus.CREATED);
        } catch (MinioException e) {
            e.printStackTrace();
        }

        return responseEntity;
    }

    @PostMapping("/delete")
    public void Delete(@RequestParam(name = "accountCode") String ID) throws Exception {
        MinioFiles files = minioFilesService.queryById(ID);
        minioUtil.removeObject(files.getMinioBucket(), files.getFileName());
    }

    @PostMapping("/getUrl")
    public String GetUrl(@RequestParam(name = "accountCode") String ID) throws Exception {
        MinioFiles files = minioFilesService.queryById(ID);
        return minioUtil.getObjectURL(files.getMinioBucket(), files.getFileName(), 7);
    }

}

package com.budailad.controller;

import com.budailad.model.MinioRespond;
import io.minio.errors.MinioException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.budailad.utils.MinioUtil;

import javax.servlet.http.HttpServletResponse;
import java.awt.print.PrinterException;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(value = "/api/healthcare/files")
public class FilesController {

    @Autowired
    private MinioUtil minioUtil;

    @PostMapping("/upload")
    public boolean Upload(@RequestParam(name = "files") MultipartFile file) {
        if(file.isEmpty()){
            return false;
        }

        boolean tag = false;
        MinioRespond minioRespond = null;
        String bucketName = "webtest";
        try {
            minioRespond = minioUtil.uploadFile(file, bucketName);
            if(minioRespond.getObjectWriteResponse() != null){
                tag = true;
            }
        } catch (Exception e) {
            log.error("上传失败 : [{}]", Arrays.asList(e.getStackTrace()));
        }
        return tag;
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> Download(HttpServletResponse response) throws Exception {
        String fileName = "generator.txt";
        String bucketName = "webtest";

        ResponseEntity<byte[]> responseEntity = null;
        InputStream stream = null;
        ByteArrayOutputStream output = null;
        try {
            stream = minioUtil.getObject(bucketName, fileName);
            if (stream == null) {
                System.out.println("文件不存在");
            }
            output = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int n = 0;
            while (-1 != (n = stream.read(buffer))) {
                output.write(buffer, 0, n);
            }
            byte[] bytes = output.toByteArray();

            //设置header
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Accept-Ranges", "bytes");
            httpHeaders.add("Content-Length", bytes.length + "");
            httpHeaders.add("Content-disposition", "attachment; filename=" + fileName);
            httpHeaders.add("Content-Type", "text/plain;charset=utf-8");

            responseEntity = new ResponseEntity<byte[]>(bytes, httpHeaders, HttpStatus.CREATED);
        } catch (MinioException e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                stream.close();
            }
            if (output != null) {
                output.close();
            }
        }
        return responseEntity;
    }

    @PostMapping("/delete")
    public void Delete(@RequestParam(name = "ID") String ID) throws Exception {

    }

}

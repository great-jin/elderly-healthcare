package xyz.ibudai.test;

import xyz.ibudai.model.MinioFiles;
import xyz.ibudai.model.MinioRespond;
import xyz.ibudai.utils.MinioUtil;
import io.minio.errors.MinioException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.PrinterException;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Arrays;

@RestController
@RequestMapping(value = "/api/healthcare/files")
public class FilesController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MinioUtil minioUtil;

    @PostMapping("/upload")
    public boolean Upload(@RequestParam(name = "files") MultipartFile file) {
        if (file.isEmpty()) {
            return false;
        }

        boolean tag = false;
        MinioRespond minioRespond = null;
        String bucketName = "webtest";
        try {
            minioRespond = minioUtil.uploadFile(file, bucketName);
            if (minioRespond.getObjectWriteResponse() != null) {
                tag = true;
            }
        } catch (Exception e) {
            logger.error("上传失败 : [{}]", Arrays.asList(e.getStackTrace()));
        }
        return tag;
    }

    @PostMapping("/download")
    public ResponseEntity<byte[]> Download(@RequestParam(name = "staffId") String ID) throws Exception {
        ResponseEntity<byte[]> responseEntity = null;

        MinioFiles files = null;
        try (InputStream in = minioUtil.getObject(files.getMinioBucket(), files.getMinioPath());
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
    public void Delete(@RequestParam(name = "staffId") String ID) throws Exception {
        MinioFiles files = null;
        minioUtil.removeObject(files.getMinioBucket(), files.getFileName());
    }

    @PostMapping("/getUrl")
    public String GetUrl(@RequestParam(name = "staffId") String ID) throws Exception {
        MinioFiles files = null;
        return minioUtil.getObjectURL(files.getMinioBucket(), files.getMinioPath(), 7);
    }

}

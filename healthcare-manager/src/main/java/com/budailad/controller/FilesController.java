package com.budailad.controller;

import com.budailad.model.MinioRespond;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.budailad.utils.MinioUtil;

import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping(value = "/files")
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

    @PostMapping("/download")
    public MultipartFile Download(@RequestParam(name = "ID") String ID) throws Exception {
        MultipartFile file = null;

        return file;
    }

    @PostMapping("/delete")
    public void Delete(@RequestParam(name = "ID") String ID) throws Exception {

    }

}

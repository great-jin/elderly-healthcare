package com.budailad.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.budailad.utils.MinioUtil;

@Slf4j
@RestController
@RequestMapping(value = "/files")
public class FilesController {

    @Autowired
    private MinioUtil minioUtil;

    @PostMapping("/upload")
    public boolean Upload(@RequestParam(name = "files", required = false) MultipartFile file) {
        return false;
    }

    @PostMapping("/download")
    public ResponseEntity<byte[]> Download(@RequestParam(name = "fileID") String fileID) throws Exception {
        ResponseEntity responseEntity = null;
        return responseEntity;
    }

    @PostMapping("/delete")
    public void Delete(@RequestParam(name = "fileID") String fileID) throws Exception {

    }

}

package com.example.fileuploaddownload.controller;

import com.example.fileuploaddownload.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class FilesController {
    @Autowired
    private FilesService filesService;
    @GetMapping("/uploadFilesIntoDB")
    public ResponseEntity<String> storeFilesIntoDB(@RequestParam("file")MultipartFile file) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(filesService.storeFile(file));
    }
    @GetMapping("/getFileByName/{fileName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String filename){
        byte[] imageData = filesService.getFiles(filename);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
    }
}

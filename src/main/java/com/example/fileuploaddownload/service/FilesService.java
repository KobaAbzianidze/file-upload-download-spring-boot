package com.example.fileuploaddownload.service;

import com.example.fileuploaddownload.entity.Files;
import com.example.fileuploaddownload.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FilesService {
    @Autowired
    private FileRepository fileRepository;
    public String storeFile(MultipartFile file) throws IOException {
       Files files =  Files
                .builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(file.getBytes())
                .build();
        files = fileRepository.save(files);
        return files.getId() != null ? "File uploaded successfully" : null;
    }

    public byte[] getFiles(String filename){
        return fileRepository.findByName(filename).getImageData();
    }
}

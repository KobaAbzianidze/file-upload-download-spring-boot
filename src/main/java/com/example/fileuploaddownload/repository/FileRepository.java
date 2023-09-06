package com.example.fileuploaddownload.repository;

import com.example.fileuploaddownload.entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FileRepository extends JpaRepository<Files, Long> {
    Files findByName(String name);
}

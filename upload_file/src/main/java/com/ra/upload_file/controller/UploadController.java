package com.ra.upload_file.controller;

import com.ra.upload_file.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

@RestController // ResponseBody + Controller
@RequestMapping("/api/v1/upload")
@RequiredArgsConstructor
public class UploadController
{
    private final UploadService uploadService;

    @PostMapping
    public ResponseEntity<?> handleUpload(@RequestParam MultipartFile file) {
        return ResponseEntity
                .created(URI.create("api/v1/upload"))
                .body(uploadService.uploadFile(file));
    }

}

package com.collegehelper.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.*;
import java.util.*;

/**
 * Service for handling image uploads and listings.
 * (Production: Use cloud storage)
 */
@Service
public class ImageService {
    private static final String UPLOAD_DIR = "uploads/";

    /**
     * Save an uploaded file and return its URL.
     */
    public String saveImage(MultipartFile file) throws Exception {
        Files.createDirectories(Paths.get(UPLOAD_DIR));
        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        file.transferTo(new File(UPLOAD_DIR + filename));
        return "/api/student/images/" + filename;
    }

    /**
     * List all image URLs.
     */
    public List<String> listImages() {
        File dir = new File(UPLOAD_DIR);
        if (!dir.exists()) return Collections.emptyList();
        String[] files = dir.list();
        List<String> urls = new ArrayList<>();
        if (files != null) {
            for (String f : files) urls.add("/api/student/images/" + f);
        }
        return urls;
    }

    /**
     * Get raw image bytes by filename.
     */
    public byte[] getImage(String filename) throws Exception {
        return Files.readAllBytes(Paths.get(UPLOAD_DIR, filename));
    }
}

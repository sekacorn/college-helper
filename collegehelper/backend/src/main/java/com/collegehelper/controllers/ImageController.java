package com.collegehelper.controllers;

import com.collegehelper.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Handles file upload and listing image URLs.
 * For production, use cloud storage and limit file types.
 */
@RestController
@RequestMapping("/api/student")
public class ImageController {

    @Autowired
    private ImageService imageService;

    /**
     * Upload an image file. Returns the URL of the saved image.
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        return imageService.saveImage(file);
    }

    /**
     * List all uploaded image URLs.
     */
    @GetMapping("/images")
    public List<String> list() {
        return imageService.listImages();
    }

    /**
     * Retrieve image file bytes by filename.
     */
    @GetMapping("/images/{filename}")
    public byte[] getImage(@PathVariable String filename) throws Exception {
        return imageService.getImage(filename);
    }
}

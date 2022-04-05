package com.magdy.video.controller;

import com.magdy.video.service.VideoService;
import com.magdy.video.service.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("video")
public class VideoController {
    @Autowired
    private VideoServiceImpl videoService;

    @PostMapping("")
    public ResponseEntity<String> saveVideo(@RequestPart("file")MultipartFile file,@RequestPart("name")String name) throws IOException {
        videoService.saveVideo(file,name);
        return ResponseEntity.ok("video saved successfully.");
    }

}

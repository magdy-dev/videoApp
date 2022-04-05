package com.magdy.video.controller;

import com.magdy.video.service.VideoService;
import com.magdy.video.service.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

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

    @GetMapping("{name}")
    public ResponseEntity<Resource> getVideo(@PathVariable("name") String name){
        return ResponseEntity.ok(new ByteArrayResource(videoService.gitVideo(name).getData()));
    }

    @GetMapping("all")
    public ResponseEntity<List<String>>getAllVideoName(){
        return (ResponseEntity<List<String>>) videoService.gitAllVideoNames();
    }


}

package com.magdy.video.service;

import com.magdy.video.entity.Video;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VideoService {

    Video gitVideo(String name);
    Video saveVideo(MultipartFile file,String name)throws IOException;
    List<Video> gitAllVideoNames();
}

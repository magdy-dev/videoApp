package com.magdy.video.service;

import com.magdy.video.Repository.VideoRepository;
import com.magdy.video.entity.Video;
import com.magdy.video.exception.VideoAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoRepository videoRepository;

    @Override
    public Video gitVideo(String name) {
        if (!videoRepository.existsByName(name)){
            throw new VideoAlreadyExistsException();
        }
        return videoRepository.findByName(name);
    }

    @Override
    public Video saveVideo(MultipartFile file, String name) throws IOException {
        if (!videoRepository.existsByName(name)){
            throw new VideoAlreadyExistsException();
        }
        Video newVideo=new Video(name,file.getBytes());
        return videoRepository.save(newVideo);
    }

    @Override
    public List<Video> gitAllVideoNames() {
        return videoRepository.getAllEntryNames();
    }
}

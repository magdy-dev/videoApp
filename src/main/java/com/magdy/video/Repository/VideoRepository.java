package com.magdy.video.Repository;

import com.magdy.video.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VideoRepository extends JpaRepository<Video,Long> {

    Video findByName(String name);

    Boolean existsByName(String name);
    @Query(nativeQuery = true,value ="SELECT name FROM video")
    List<Video> getAllEntryNames();
}

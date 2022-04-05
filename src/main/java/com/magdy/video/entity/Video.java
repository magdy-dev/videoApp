package com.magdy.video.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    @Lob
    private byte[] data;


    public Video(String name, byte[] data) {

        this.name = name;
        this.data = data;
    }
}

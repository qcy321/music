package com.mu.pojo;

import com.mu.entities.Singer;
import com.mu.entities.Song;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * (Album)实体类
 *
 * @author qcy_java
 * @since 2021-04-27 19:36:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Album {
    private static final long serialVersionUID = -29839703019155376L;
    private Integer albumId;

    private Singer singer;

    private String name;

    private Date timeOfIssue;

    private String company;

    private String introduce;

    private String img;

    private List<Song> songs;

    private Integer number;//曲目数

    private AlbumType albumType;
}

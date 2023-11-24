package com.mu.entities;

import java.util.List;

/**
 * (SongType)实体类
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:23
 */
public class SongType {
    private static final long serialVersionUID = -71723598675131078L;
    /**
     * 歌曲种类编号
     */
    private Integer typeId;
    /**
     * 歌曲种类名称
     */
    private String name;

    private List<Song> songs;

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SongType{" +
                "typeId=" + typeId +
                ", name='" + name + '\'' +
                ", songs=" + songs +
                '}';
    }
}

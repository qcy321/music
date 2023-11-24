package com.mu.entities;

import com.mu.pojo.Album;

import java.util.List;

/**
 * (Song)实体类
 *
 * @author qcy_java
 * @since 2021-04-27 20:23:10
 */
public class Song {
    private static final long serialVersionUID = -59736988068074665L;

    private Integer songId;

    private String songTitle;

    /**
     * 歌曲存放地址
     */
    private String songUrl;

    private Album album;

    private String lyric;

    private String spectrum;

    private Mv mv;

    private List<User> users;

    private List<Comment> comments;

    public Mv getMv() {
        return mv;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setMv(Mv mv) {


        this.mv = mv;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getSpectrum() {
        return spectrum;
    }

    public void setSpectrum(String spectrum) {
        this.spectrum = spectrum;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", songTitle='" + songTitle + '\'' +
                ", songUrl='" + songUrl + '\'' +
                ", album=" + album +
                ", lyric='" + lyric + '\'' +
                ", spectrum='" + spectrum + '\'' +
                ", mv=" + mv +
                ", users=" + users +
                ", comments=" + comments +
                '}';
    }
}

package com.mu.entities;


import java.util.Date;
import java.util.List;

/**
 * (Mv)实体类
 *
 * @author qcy_java
 * @since 2021-04-27 20:22:46
 */
public class Mv {
    private static final long serialVersionUID = -63794516511240219L;

    private Integer mvId;
    /**
     * mv标题
     */
    private String mvTitle;

    private Song song;
    /**
     * 播放量
     */
    private Integer playVolume;
    /**
     * mv封面地址
     */
    private String cover;
    /**
     * 视频地址
     */
    private String video;
    /**
     * mv发布时间
     */
    private Date time;

    private MvType mvType;

    private List<MvComment> mvComments;

    public List<MvComment> getMvComments() {
        return mvComments;
    }

    public void setMvComments(List<MvComment> mvComments) {
        this.mvComments = mvComments;
    }

    public Integer getMvId() {
        return mvId;
    }

    public void setMvId(Integer mvId) {
        this.mvId = mvId;
    }

    public String getMvTitle() {
        return mvTitle;
    }

    public void setMvTitle(String mvTitle) {
        this.mvTitle = mvTitle;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Integer getPlayVolume() {
        return playVolume;
    }

    public void setPlayVolume(Integer playVolume) {
        this.playVolume = playVolume;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public MvType getMvType() {
        return mvType;
    }

    public void setMvType(MvType mvType) {
        this.mvType = mvType;
    }

    @Override
    public String toString() {
        return "Mv{" +
                "mvId=" + mvId +
                ", mvTitle='" + mvTitle + '\'' +
                ", song=" + song +
                ", playVolume=" + playVolume +
                ", cover='" + cover + '\'' +
                ", video='" + video + '\'' +
                ", time=" + time +
                ", mvType=" + mvType +
                ", mvComments=" + mvComments +
                '}';
    }
}

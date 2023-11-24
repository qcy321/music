package com.mu.entities;

/**
 * (AttentionSong)实体类
 *
 * @author qcy_java
 * @since 2021-05-27 15:03:14
 */
public class AttentionSong {
    private static final long serialVersionUID = -37356913187835147L;

    private Integer attentionId;

    private Integer userId;

    private Integer songId;


    public Integer getAttentionId() {
        return attentionId;
    }

    public void setAttentionId(Integer attentionId) {
        this.attentionId = attentionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    @Override
    public String toString() {
        return "AttentionSong{" +
                "attentionId=" + attentionId +
                ", userId=" + userId +
                ", songId=" + songId +
                '}';
    }
}

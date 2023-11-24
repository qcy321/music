package com.mu.pojo;

/**
 * (AttentionSong)实体类
 *
 * @author qcy_java
 * @since 2021-05-27 15:02:35
 */
public class AttentionSong {
    private static final long serialVersionUID = -96504416844685819L;

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

}

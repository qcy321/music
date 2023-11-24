package com.mu.pojo;

/**
 * (AttentionMv)实体类
 *
 * @author qcy_java
 * @since 2021-05-27 15:02:34
 */
public class AttentionAlbum {
    private static final long serialVersionUID = 906187779567261520L;

    private Integer attentionId;

    private Integer userId;

    private Integer albumId;


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

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    @Override
    public String toString() {
        return "AttentionAlbum{" +
                "attentionId=" + attentionId +
                ", userId=" + userId +
                ", albumId=" + albumId +
                '}';
    }
}
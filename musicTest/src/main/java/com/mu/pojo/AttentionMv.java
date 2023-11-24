package com.mu.pojo;

/**
 * (AttentionMv)实体类
 *
 * @author qcy_java
 * @since 2021-05-27 15:02:34
 */
public class AttentionMv {
    private static final long serialVersionUID = 906187779567261520L;

    private Integer attentionId;

    private Integer userId;

    private Integer mvId;


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

    public Integer getMvId() {
        return mvId;
    }

    public void setMvId(Integer mvId) {
        this.mvId = mvId;
    }

    @Override
    public String toString() {
        return "AttentionMv{" +
                "attentionId=" + attentionId +
                ", userId=" + userId +
                ", mvId=" + mvId +
                '}';
    }
}

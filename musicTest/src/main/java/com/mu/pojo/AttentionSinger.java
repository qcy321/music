package com.mu.pojo;

/**
 * (AttentionSinger)实体类
 *
 * @author qcy_java
 * @since 2021-05-27 15:02:35
 */
public class AttentionSinger {
    private static final long serialVersionUID = 528934376658415473L;

    private Integer attentionId;

    private Integer userId;

    private Integer singerId;


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

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

}

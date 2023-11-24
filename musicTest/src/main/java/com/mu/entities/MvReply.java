package com.mu.entities;

import java.util.Date;

/**
 * (MvReply)实体类
 *
 * @author qcy_java
 * @since 2021-04-27 20:22:25
 */
public class MvReply {
    private static final long serialVersionUID = 301482525960175104L;

    private Integer replyId;

    private MvComment mvComment;

    private User user;

    private String content;

    private Date contentTime;

    private Integer number;


    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public MvComment getMvComment() {
        return mvComment;
    }

    public void setMvComment(MvComment mvComment) {
        this.mvComment = mvComment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getContentTime() {
        return contentTime;
    }

    public void setContentTime(Date contentTime) {
        this.contentTime = contentTime;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "MvReply{" +
                "replyId=" + replyId +
                ", mvComment=" + mvComment +
                ", user=" + user +
                ", content='" + content + '\'' +
                ", contentTime=" + contentTime +
                ", number=" + number +
                '}';
    }
}

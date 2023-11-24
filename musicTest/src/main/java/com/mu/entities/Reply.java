package com.mu.entities;

import java.util.Date;

/**
 * (Reply)实体类
 *
 * @author qcy_java
 * @since 2021-04-27 20:22:26
 */
public class Reply {
    private static final long serialVersionUID = -30479809817627856L;

    private Integer replyId;

    private Comment comment;

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

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
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
        return "Reply{" +
                "replyId=" + replyId +
                ", comment=" + comment +
                ", user=" + user +
                ", content='" + content + '\'' +
                ", contentTime=" + contentTime +
                ", number=" + number +
                '}';
    }
}

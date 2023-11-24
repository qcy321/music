package com.mu.entities;

import java.util.Date;
import java.util.List;

/**
 * (Comment)实体类
 *
 * @author qcy_java
 * @since 2021-04-27 19:47:36
 */
public class Comment {
    private static final long serialVersionUID = -84241811297719470L;

    private Integer commentId;

    private User user;

    private Song song;

    private String content;

    private Date contentTime;

    private Integer number;

    private List<Reply> replies;

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
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

    public void setContentTime(Date contenttime) {
        this.contentTime = contenttime;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", user=" + user +
                ", song=" + song +
                ", content='" + content + '\'' +
                ", contentTime=" + contentTime +
                ", number=" + number +
                ", replies=" + replies +
                '}';
    }
}

package com.mu.entities;

import java.util.Date;
import java.util.List;

/**
 * (MvComment)实体类
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:21
 */
public class MvComment {
    private static final long serialVersionUID = -47747710735814968L;
    /**
     * mv评论编号
     */
    private Integer commentId;
    /**
     * 用户编号
     */
    private User user;
    /**
     * mv编号
     */
    private Mv mv;
    /**
     * 回复内容
     */
    private String content;
    /**
     * 评论时间
     */
    private Date contentTime;
    /**
     * 点赞数
     */
    private Integer number;

    private List<MvReply> mvReplies;

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

    public Mv getMv() {
        return mv;
    }

    public void setMv(Mv mv) {
        this.mv = mv;
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

    public List<MvReply> getMvReplies() {
        return mvReplies;
    }

    public void setMvReplies(List<MvReply> mvReplies) {
        this.mvReplies = mvReplies;
    }

    @Override
    public String toString() {
        return "MvComment{" +
                "commentId=" + commentId +
                ", user=" + user +
                ", mv=" + mv +
                ", content='" + content + '\'' +
                ", contentTime=" + contentTime +
                ", number=" + number +
                ", mvReplies=" + mvReplies +
                '}';
    }
}

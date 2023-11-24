package com.mu.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Comment歌曲评论实体信息(Comment)实体类
 *
 * @author qcy_java
 * @since 2021-10-10 19:23:33
 */

@ApiModel("Comment歌曲评论实体信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment implements Serializable {
    private static final long serialVersionUID = 816213537754503517L;
    /**
     * 歌词评论id
     */
    @ApiModelProperty("歌词评论id")
    private Integer commentId;
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer id;
    /**
     * 歌曲id
     */
    @ApiModelProperty("歌曲id")
    private Integer songId;
    /**
     * 评论内容
     */
    @ApiModelProperty("评论内容")
    private String content;
    /**
     * 评论时间
     */
    @ApiModelProperty("评论时间")
    private Date contentTime;
    /**
     * 点赞数
     */
    @ApiModelProperty("点赞数")
    private Integer number;

    @ApiModelProperty("用户信息")
    private User user;

    @ApiModelProperty("歌曲信息")
    private Song song;

    @ApiModelProperty("所有回复信息")
    private List<Reply> replies;
}

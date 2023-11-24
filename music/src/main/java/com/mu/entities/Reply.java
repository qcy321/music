package com.mu.entities;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Reply歌曲评论实体信息(Reply)实体类
 *
 * @author qcy_java
 * @since 2021-10-10 19:23:38
 */

@ApiModel("Reply歌曲评论实体信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reply implements Serializable {
    private static final long serialVersionUID = -51254616047328873L;
    /**
     * 歌曲评论回复id
     */
    @ApiModelProperty("歌曲评论回复id")
    private Integer replyId;
    /**
     * 评论id
     */
    @ApiModelProperty("评论id")
    private Integer commentId;
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
     * 回复内容
     */
    @ApiModelProperty("回复内容")
    private String content;
    /**
     * 回复时间
     */
    @ApiModelProperty("回复时间")
    private Date contentTime;
    /**
     * 点赞数
     */
    @ApiModelProperty("点赞数")
    private Integer number;

    @ApiModelProperty("目标评论信息")
    private Comment comment;

    @ApiModelProperty("用户信息")
    private User user;
}

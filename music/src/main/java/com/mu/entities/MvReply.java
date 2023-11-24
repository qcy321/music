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
 * Mv_Reply视频回复实体信息(MvReply)实体类
 *
 * @author qcy_java
 * @since 2021-10-10 19:23:37
 */

@ApiModel("Mv_Reply视频回复实体信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MvReply implements Serializable {
    private static final long serialVersionUID = -15678070070696488L;
    /**
     * 视频评论回复id
     */
    @ApiModelProperty("视频评论回复id")
    private Integer replyId;
    /**
     * 视频评论id
     */
    @ApiModelProperty("视频评论id")
    private Integer commentId;
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;
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

    @ApiModelProperty("评论信息")
    private MvComment mvComment;

    @ApiModelProperty("用户信息")
    private User user;
}

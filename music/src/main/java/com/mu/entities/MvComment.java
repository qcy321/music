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
 * Mv_Comment视频评论实体类(MvComment)实体类
 *
 * @author qcy_java
 * @since 2021-10-10 19:23:36
 */

@ApiModel("Mv_Comment视频评论实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MvComment implements Serializable {
    private static final long serialVersionUID = -90230999539412598L;
    /**
     * mv评论id
     */
    @ApiModelProperty("mv评论id")
    private Integer commentId;
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer id;
    /**
     * 视频id
     */
    @ApiModelProperty("视频id")
    private Integer mvId;
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

    @ApiModelProperty("mv信息")
    private Mv mv;

    @ApiModelProperty("所有回复信息")
    private List<MvReply> mvReplies;
}

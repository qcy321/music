package com.mu.entities;

import java.io.Serializable;
import java.util.List;

import com.mu.annotation.AddUrlPrefix;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * User用户实体信息(User)实体类
 *
 * @author qcy_java
 * @since 2021-10-10 19:23:43
 */

@ApiModel("User用户实体信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = -86146264420741123L;
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer id;
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;
    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private Object sex;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String psw;
    /**
     * 头像路径
     */
    @AddUrlPrefix
    @ApiModelProperty("头像路径")
    private String headPortrait;
    /**
     * vip属性
     */
    @ApiModelProperty("vip属性")
    private Object vip;
    /**
     * vip过期时间
     */
    @ApiModelProperty("vip过期时间")
    private Integer viptime;

    @ApiModelProperty("关注的歌曲")
    private List<Song> songs;

    @ApiModelProperty("关注的mv")
    private List<Mv> mvs;

    @ApiModelProperty("关注的专辑")
    private List<Album> albums;

    @ApiModelProperty("关注的歌手")
    private List<Singer> singers;

    @ApiModelProperty("所有歌曲的评论信息")
    private List<Comment> comments;

    @ApiModelProperty("所有的视频评论信息")
    private List<MvComment> mvComments;

    @ApiModelProperty("所有的歌曲回复信息")
    private List<Reply> replies;

    @ApiModelProperty("所有的mv回复信息")
    private List<MvReply> mvReplies;
}

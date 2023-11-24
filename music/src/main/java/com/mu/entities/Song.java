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
 * Song歌曲种类实体信息(Song)实体类
 *
 * @author qcy_java
 * @since 2021-10-10 19:23:41
 */

@ApiModel("Song歌曲种类实体信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Song implements Serializable {
    private static final long serialVersionUID = 609651448497666662L;
    /**
     * 歌曲id
     */
    @ApiModelProperty("歌曲id")
    private Integer songId;
    /**
     * 歌曲名称
     */
    @ApiModelProperty("歌曲名称")
    private String songTitle;
    /**
     * 歌曲路径
     */
    @AddUrlPrefix
    @ApiModelProperty("歌曲路径")
    private String songUrl;
    /**
     * 专辑id
     */
    @ApiModelProperty("专辑id")
    private Integer albumId;
    /**
     * 歌词路径
     */
    @ApiModelProperty("歌词路径")
    private String lyric;
    /**
     * 歌曲频谱
     */
    @ApiModelProperty("歌曲频谱")
    private String spectrum;
    /**
     * 歌曲种类id
     */
    @ApiModelProperty("歌曲种类id")
    private Integer typeId;

    @ApiModelProperty("专辑信息")
    private Album album;

    @ApiModelProperty("mv信息")
    private Mv mv;

    @ApiModelProperty("所有关注的用户")
    private List<User> users;

    @ApiModelProperty("所有评论")
    private List<Comment> comments;
}

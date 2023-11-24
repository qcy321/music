package com.mu.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.mu.annotation.AddUrlPrefix;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * (Mv)实体类
 *
 * @author qcy_java
 * @since 2021-10-10 19:23:35
 */

@ApiModel("Mv视频实体信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Mv implements Serializable {
    private static final long serialVersionUID = 836259172296417514L;
    /**
     * 视频id
     */
    @ApiModelProperty("视频id")
    private Integer mvId;
    /**
     * mv标题
     */
    @ApiModelProperty("mv标题")
    private String mvTitle;
    /**
     * 歌曲id
     */
    @ApiModelProperty("歌曲id")
    private Integer songId;
    /**
     * 播放量
     */
    @ApiModelProperty("播放量")
    private Integer playVolume;
    /**
     * mv封面地址
     */
    @AddUrlPrefix
    @ApiModelProperty("mv封面地址")
    private String cover;
    /**
     * 视频地址
     */
    @ApiModelProperty("视频地址")
    private String video;
    /**
     * mv发布时间
     */
    @ApiModelProperty("mv发布时间")
    private Date time;
    /**
     * 视频种类id
     */
    @ApiModelProperty("视频种类id")
    private Integer typeId;

    @ApiModelProperty("视频种类实体")
    private MvType mvType;

    @ApiModelProperty("歌曲信息")
    private Song song;

    @ApiModelProperty("所有关注用户")
    private List<User> users;

    @ApiModelProperty("所有评论")
    private List<MvComment> mvComments;
}

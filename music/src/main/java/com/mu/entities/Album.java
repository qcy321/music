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
 * Album专辑实体类(Album)实体类
 *
 * @author qcy_java
 * @since 2021-10-10 19:19:23
 */

@ApiModel("Album专辑实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Album implements Serializable {
    private static final long serialVersionUID = 733720517071602176L;
    /**
     * 专辑编号
     */
    @ApiModelProperty("专辑编号")
    private Integer albumId;
    /**
     * 歌手编号
     */
    @ApiModelProperty("歌手编号")
    private Integer singerId;
    /**
     * 专辑名称
     */
    @ApiModelProperty("专辑名称")
    private String name;
    /**
     * 发行时间
     */
    @ApiModelProperty("发行时间")
    private Date timeOfIssue;
    /**
     * 发行公司
     */
    @ApiModelProperty("发行公司")
    private String company;
    /**
     * 介绍
     */
    @ApiModelProperty("介绍")
    private String introduce;
    /**
     * 专辑封面
     */
    @AddUrlPrefix
    @ApiModelProperty("专辑封面")
    private String img;
    /**
     * 种类id
     */
    @ApiModelProperty("种类id")
    private Integer typeId;

    @ApiModelProperty("歌手信息")
    private Singer singer;

    @ApiModelProperty("歌曲数量")
    private Integer number;//曲目数

    @ApiModelProperty("专辑种类实体")
    private AlbumType albumType;

    @ApiModelProperty("专辑的歌曲")
    private List<Song> songs;

    @ApiModelProperty("关注的用户")
    private List<User> users;
}

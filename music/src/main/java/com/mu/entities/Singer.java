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
 * Singe歌手实体信息(Singer)实体类
 *
 * @author qcy_java
 * @since 2021-10-10 19:23:39
 */

@ApiModel("Singe歌手实体信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Singer implements Serializable {
    private static final long serialVersionUID = 366455517366491439L;
    /**
     * 歌手id
     */
    @ApiModelProperty("歌手id")
    private Integer singerId;
    /**
     * 歌手名字
     */
    @ApiModelProperty("歌手名字")
    private String name;
    /**
     * 外文名
     */
    @ApiModelProperty("外文名")
    private String foreignName;
    /**
     * 别名
     */
    @ApiModelProperty("别名")
    private String alias;
    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private Object sex;
    /**
     * 国籍
     */
    @ApiModelProperty("国籍")
    private String nationality;
    /**
     * 生日
     */
    @ApiModelProperty("出生地")
    private String birthplace;

    @ApiModelProperty("生日")
    private Date dateOfBirth;
    /**
     * 出生地
     */
    @ApiModelProperty("职业")
    private String occupation;
    /**
     * 代表作
     */
    @ApiModelProperty("代表作")
    private String representative;
    /**
     * 成就
     */
    @ApiModelProperty("成就")
    private String achievement;
    /**
     * 简介
     */
    @ApiModelProperty("简介")
    private String synopsis;
    /**
     * 头像路径
     */
    @AddUrlPrefix
    @ApiModelProperty("头像路径")
    private String headPortrait;
    /**
     * 歌手种类id
     */
    @ApiModelProperty("歌手种类id")
    private Integer typeId;
    /**
     * 关注数
     */
    @ApiModelProperty("关注数")
    private Integer attention;

    @ApiModelProperty("所有关注用户")
    private List<User> users;

    @ApiModelProperty("歌曲种类信息")
    private SingerType singerType;

    @ApiModelProperty("所有专辑信息")
    private List<Album> albums;
}

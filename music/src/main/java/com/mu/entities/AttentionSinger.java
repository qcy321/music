package com.mu.entities;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Attention_Song关注歌手实体信息(AttentionSinger)实体类
 *
 * @author qcy_java
 * @since 2021-10-10 19:23:32
 */

@ApiModel("Attention_Song关注歌手实体信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AttentionSinger implements Serializable {
    private static final long serialVersionUID = 318745038653998374L;
    /**
     * 歌手关注id
     */
    @ApiModelProperty("歌手关注id")
    private Integer attentionId;
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
     * 歌手id
     */
    @ApiModelProperty("歌手id")
    private Integer singerId;


}

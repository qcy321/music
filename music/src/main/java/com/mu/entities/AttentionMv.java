package com.mu.entities;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Attention_Singer关注歌手实体类(AttentionMv)实体类
 *
 * @author qcy_java
 * @since 2021-10-10 19:23:31
 */

@ApiModel("Attention_Singer关注歌手实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AttentionMv implements Serializable {
    private static final long serialVersionUID = 644367803633398081L;
    /**
     * mv关注id
     */
    @ApiModelProperty("mv关注id")
    private Integer attentionId;
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
     * 视频id
     */
    @ApiModelProperty("视频id")
    private Integer mvId;


}

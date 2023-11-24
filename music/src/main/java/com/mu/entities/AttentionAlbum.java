package com.mu.entities;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Attention_Album专辑关注实体类(AttentionAlbum)实体类
 *
 * @author qcy_java
 * @since 2021-10-10 19:23:29
 */

@ApiModel("Attention_Album专辑关注实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AttentionAlbum implements Serializable {
    private static final long serialVersionUID = 116987564335175931L;
    /**
     * 专辑关注id
     */
    @ApiModelProperty("专辑关注id")
    private Integer attentionId;
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
     * 专辑id
     */
    @ApiModelProperty("专辑id")
    private Integer albumId;


}

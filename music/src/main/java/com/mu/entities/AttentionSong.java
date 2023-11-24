package com.mu.entities;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * (AttentionSong)实体类
 *
 * @author qcy_java
 * @since 2021-10-10 19:23:33
 */

@ApiModel("Attention_Song歌曲关注实体信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AttentionSong implements Serializable {
    private static final long serialVersionUID = 669858445891086440L;
    @ApiModelProperty("歌曲关注id")
    private Integer attentionId;
    @ApiModelProperty("用户id")
    private Integer userId;
    @ApiModelProperty("歌曲id")
    private Integer songId;


}

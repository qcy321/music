package com.mu.entities;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Favorite歌曲喜爱实体信息(Favorite)实体类
 *
 * @author qcy_java
 * @since 2021-10-10 19:23:34
 */

@ApiModel("Favorite歌曲喜爱实体信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Favorite implements Serializable {
    private static final long serialVersionUID = 741655836439442603L;
    /**
     * 喜欢id
     */
    @ApiModelProperty("喜欢id")
    private Integer collId;
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer id;
    /**
     * 歌曲id
     */
    @ApiModelProperty("歌曲id")
    private Integer songId;


}

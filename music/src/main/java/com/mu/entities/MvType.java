package com.mu.entities;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Mv_Type视频种类实体信息(MvType)实体类
 *
 * @author qcy_java
 * @since 2021-10-10 19:23:38
 */

@ApiModel("Mv_Type视频种类实体信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MvType implements Serializable {
    private static final long serialVersionUID = -54045599926567135L;
    /**
     * mv种类id
     */
    @ApiModelProperty("mv种类id")
    private Integer typeId;
    /**
     * 种类名称
     */
    @ApiModelProperty("种类名称")
    private String name;

    @ApiModelProperty("所有视频信息")
    private List<Mv> mvs;
}

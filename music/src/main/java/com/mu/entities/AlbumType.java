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
 * Album_type专辑种类实体类(AlbumType)实体类
 *
 * @author qcy_java
 * @since 2021-10-10 19:23:16
 */

@ApiModel("Album_type专辑种类实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlbumType implements Serializable {
    private static final long serialVersionUID = -56615391377695916L;
    /**
     * 专辑种类id
     */
    @ApiModelProperty("专辑种类id")
    private Integer typeId;
    /**
     * 专辑种类名称
     */
    @ApiModelProperty("专辑种类名称")
    private String name;

    @ApiModelProperty("所有的专辑信息")
    private List<Album> albums;
}

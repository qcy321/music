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
 * Singer_type歌手种类实体信息(SingerType)实体类
 *
 * @author qcy_java
 * @since 2021-10-10 19:23:40
 */

@ApiModel("Singer_type歌手种类实体信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SingerType implements Serializable {
    private static final long serialVersionUID = 210566537504753087L;
    /**
     * 歌手种类id
     */
    @ApiModelProperty("歌手种类id")
    private Integer typeId;
    /**
     * 种类名称
     */
    @ApiModelProperty("种类名称")
    private String name;

    @ApiModelProperty("所有歌手信息")
    private List<Singer> singers;
}

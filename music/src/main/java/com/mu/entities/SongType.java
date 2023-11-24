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
 * Song_Type歌曲种类实体信息(SongType)实体类
 *
 * @author qcy_java
 * @since 2021-10-10 19:23:42
 */

@ApiModel("Song_Type歌曲种类实体信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SongType implements Serializable {
    private static final long serialVersionUID = 687079012705020253L;
    /**
     * 歌曲种类id
     */
    @ApiModelProperty("歌曲种类id")
    private Integer typeId;
    /**
     * 歌曲种类名称
     */
    @ApiModelProperty("歌曲种类名称")
    private String name;

    @ApiModelProperty("所有歌曲信息")
    private List<Song> songs;
}

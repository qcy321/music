package com.mu.pojo;

/**
 * (Favorite)实体类
 *
 * @author qcy_java
 * @since 2021-04-27 19:55:24
 */
public class Favorite {
    private static final long serialVersionUID = -13807962974562240L;

    private Integer collId;

    private Integer id;

    private Integer songId;


    public Integer getCollId() {
        return collId;
    }

    public void setCollId(Integer collId) {
        this.collId = collId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

}

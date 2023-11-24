package com.mu.entities;

/**
 * (Favorite)实体类
 *
 * @author qcy_java
 * @since 2021-04-27 20:32:28
 */
public class Favorite {
    private static final long serialVersionUID = -86698075657303486L;

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

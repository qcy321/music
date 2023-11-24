package com.mu.pojo;

/**
 * (AlbumType)实体类
 *
 * @author qcy_java
 * @since 2021-05-30 20:32:20
 */
public class AlbumType {
    private static final long serialVersionUID = 578707807622388422L;

    private Integer typeId;

    private String name;


    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

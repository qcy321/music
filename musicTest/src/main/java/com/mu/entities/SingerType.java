package com.mu.entities;

import java.util.List;

/**
 * (Singertype)实体类
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:22
 */
public class SingerType {
    private static final long serialVersionUID = 668170171857894960L;

    private Integer typeId;

    private String name;

    private List<Singer> singers;

    public List<Singer> getSingers() {
        return singers;
    }

    public void setSingers(List<Singer> singers) {
        this.singers = singers;
    }

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

    @Override
    public String toString() {
        return "Singertype{" +
                "typeId=" + typeId +
                ", name='" + name + '\'' +
                ", singers=" + singers +
                '}';
    }
}

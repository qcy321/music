package com.mu.entities;

import java.util.List;

/**
 * (MvType)实体类
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:21
 */
public class MvType {
    private static final long serialVersionUID = -27117342189330571L;
    /**
     * mv种类编号
     */
    private Integer typeId;
    /**
     * 种类名称
     */
    private String name;

    private List<Mv> mvs;

    public List<Mv> getMvs() {
        return mvs;
    }

    public void setMvs(List<Mv> mvs) {
        this.mvs = mvs;
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
        return "MvType{" +
                "typeId=" + typeId +
                ", name='" + name + '\'' +
                ", mvs=" + mvs +
                '}';
    }
}

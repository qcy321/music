package com.mu.pojo;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author qcy_java
 * @since 2021-04-27 19:17:25
 */
public class User implements Serializable {
    private static final long serialVersionUID = 619269892092447618L;

    private Integer id;

    private String username;

    private Object sex;

    private Integer psw;

    private String headPortrait;

    private Object vip;

    private Integer viptime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getSex() {
        return sex;
    }

    public void setSex(Object sex) {
        this.sex = sex;
    }

    public Integer getPsw() {
        return psw;
    }

    public void setPsw(Integer psw) {
        this.psw = psw;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public Object getVip() {
        return vip;
    }

    public void setVip(Object vip) {
        this.vip = vip;
    }

    public Integer getViptime() {
        return viptime;
    }

    public void setViptime(Integer viptime) {
        this.viptime = viptime;
    }

}

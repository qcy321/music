package com.mu.entities;

import com.mu.pojo.Album;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * (Singer)实体类
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:22
 */
public class Singer {
    private static final long serialVersionUID = 936349795622444094L;

    private Integer singerId;

    private String name;

    private String foreignName;

    private String alias;

    private Object sex;

    private String nationality;

    private String birthplace;

    @DateTimeFormat(pattern = "yyyy-MM")
    private Date dateOfBirth;

    private String occupation;

    private String representative;

    private String achievement;

    private String synopsis;

    private String headPortrait;

    private SingerType singerType;

    private Integer attention;

    private Integer attentionCount;

    private List<Album> albums;


    public Integer getAttentionCount() {
        return attentionCount;
    }

    public void setAttentionCount(Integer attentionCount) {
        this.attentionCount = attentionCount;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Object getSex() {
        return sex;
    }

    public void setSex(Object sex) {
        this.sex = sex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public SingerType getSingerType() {
        return singerType;
    }

    public void setSingerType(SingerType singertype) {
        this.singerType = singertype;
    }

    public Integer getAttention() {
        return attention;
    }

    public void setAttention(Integer attention) {
        this.attention = attention;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "singerId=" + singerId +
                ", name='" + name + '\'' +
                ", foreignName='" + foreignName + '\'' +
                ", alias='" + alias + '\'' +
                ", sex=" + sex +
                ", nationality='" + nationality + '\'' +
                ", birthplace='" + birthplace + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", occupation='" + occupation + '\'' +
                ", representative='" + representative + '\'' +
                ", achievement='" + achievement + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", singerType=" + singerType +
                ", attention=" + attention +
                ", attentionCount=" + attentionCount +
                ", albums=" + albums +
                '}';
    }
}

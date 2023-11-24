package com.mu.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * (User)实体类
 *
 * @author qcy_java
 * @since 2021-04-27 19:36:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private static final long serialVersionUID = -41137098875783176L;

    private Integer id;

    private String username;

    private Object sex;

    private String psw;

    private String headPortrait;

    private Object vip;

    private Integer viptime;

    private List<Song> songs;

    private List<Comment> comments;

    private List<MvComment> mvComments;
}

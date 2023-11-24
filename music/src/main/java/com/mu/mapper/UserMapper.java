package com.mu.mapper;

import com.mu.entities.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author qcy_java
 * @since 2021-04-27 19:36:19
 */
@Repository("userMapper")
public interface UserMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select * from user where id = #{id}")
    User queryById(Integer id);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select id,username,head_portrait from user where id = #{id}")
    User queryByPart(Integer id);

    /**
     * 查询用户密码
     *
     * @param user 主键
     * @return 实例对象
     */
    @Select("select psw from user where id = #{id}")
    String queryByPsw(User user);


    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param user 实例对象
     * @return 对象列表
     */
    List<User> queryAll(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    @Insert({"insert into user(username,sex,psw,head_portrait,vip,viptime)",
            "values(#{username},#{sex},#{psw},#{headPortrait},#{vip},#{viptime})"})
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insert(User user);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param user List<User> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("user") List<User> user);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param user List<User> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("user") List<User> user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}


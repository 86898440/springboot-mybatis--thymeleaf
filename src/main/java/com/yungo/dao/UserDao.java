package com.yungo.dao;

import com.yungo.entity.User;
import com.yungo.hideMapper.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by cx on 17-8-3.
 */

public interface UserDao extends MyMapper{

/*    public User findByUsername(@Param("username") String Username);*/

     /*   @Select("SELECT * FROM user WHERE username = #{username}")
        @Results({
                @Result(property = "id", column = "id"),
                @Result(property = "username", column = "username"),
                @Result(property = "phone" ,column = "phone"),
                @Result(property = "username" ,column = "username")
        })*/


        int create(@Param("nickname") String nickname,@Param("password")String password,@Param("phone")long phone);

    User findByPhone(@Param("phone") Long phone);

       /* @Select("SELECT * FROM users WHERE id = #{id}")
        @Results({
                @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
                @Result(property = "nickName", column = "nick_name")
        })
        User getOne(Long id);
        @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
        void insert(User user);
        @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
        void update(User user);
        @Delete("DELETE FROM users WHERE id =#{id}")
        void delete(Long id);*/


}

package com.study.dao;


import com.study.bean.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UserDao {

    @Select("select * from user where id =${userId}")
    User getById(@Param("userId") Long userId);

    @Select("select * from user where mobile =#{mobile}")
    User getByMobile(@Param("mobile") String mobile);

    @Insert("insert into user (id,name) values(#{id},#{name})")
    Integer insert(User user);
}

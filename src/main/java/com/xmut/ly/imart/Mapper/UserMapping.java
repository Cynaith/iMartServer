package com.xmut.ly.imart.Mapper;

import com.xmut.ly.imart.Domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapping {

    @Select("select user_id from user where user_phone = #{userPhone}")
    int haveUserByUserphone(String userPhone);


    @Select("select * from user where user_phone = #{userPhone}")
    User findUserByUserphone(String userPhone);
}

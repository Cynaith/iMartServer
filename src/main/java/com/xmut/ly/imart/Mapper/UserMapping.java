package com.xmut.ly.imart.Mapper;

import com.xmut.ly.imart.Domain.User;
import com.xmut.ly.imart.ResultVo.FriendListVo;
import com.xmut.ly.imart.ResultVo.UserInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapping {

    @Select("select user_id from user where user_phone = #{userPhone}")
    int haveUserByUserphone(String userPhone);


    @Select("select * from user where user_phone = #{userPhone}")
    User findUserByUserphone(String userPhone);

    @Select("select id from user where name = #{name}")
    int getIdByUsername(@Param("name") String name);


    @Select("select usershow from user where name = #{name}")
    String getShow(@Param("name") String name);

    @Select("select count(id) from follow where userid = #{userId}")
    int getFollowNum(@Param("userId") int userId);

    @Select("select count(id) from follow where followId = #{userId}")
    int getFollowedNum(@Param("userId") int userId);

    @Select("select imgUrl from user where id = #{id}")
    String getImg(@Param("id") int id);

    @Select("select count(id) from article where userId = #{userId}")
    int getArticleNum(@Param("userId") int userId);

    @Select("select followId from follow where userId = #{userId}")
    List<Integer> getFollowId(@Param("userId") int userid);

    @Select("select userId from follow where followId = #{userId}")
    List<Integer> getFollowedId(@Param("userId") int userid);

    @Select("select name,imgUrl as imageUrl,usershow from user where id = #{id}")
    FriendListVo getFriendList(@Param("id") int id);
}

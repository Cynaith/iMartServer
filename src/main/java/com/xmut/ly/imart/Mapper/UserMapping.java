package com.xmut.ly.imart.Mapper;

import com.xmut.ly.imart.Domain.User;
import com.xmut.ly.imart.ResultVo.ArticleListVo;
import com.xmut.ly.imart.ResultVo.FriendListVo;
import com.xmut.ly.imart.ResultVo.Myshow1Vo;
import com.xmut.ly.imart.ResultVo.UserInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapping {

    @Select("select user_id from user where user_phone = #{userPhone}")
    int haveUserByUserphone(String userPhone);


    @Select("select * from user where user_phone = #{userPhone}")
    User findUserByUserphone(String userPhone);

    @Select("select id from user where name = #{name}")
    int getIdByUsername(@Param("name") String name);

    @Select("select name from user where id = #{id}")
    String getUsernameById(@Param("id") int id);

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

    @Select("select count(id) from follow where userId = #{loginId} and followId = #{userId}")
    int isFollow(@Param("userId") int userid,@Param("loginId") int loginId);

    @Select("select id as articleId,img1 as imageUrl,title as name,time as content from article where userId = #{id}")
    List<ArticleListVo> getArticle(@Param("id") int id);

    @Select("select img1 from article where userId = #{userId}")
    String getArticleImg(@Param("userId") int userId);

    @Select("select id from article where userId = #{userId}")
    int getArticleidByUserid(@Param("userId") int userId);

    @Select("select id ,img1 as imageUrl from article where userId = #{userId}")
    List<Myshow1Vo> getMyshowVo1(@Param("userId") int userId);
}

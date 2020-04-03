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

    @Select("select count(id) from follow where userid = #{userid}")
    int getFollowNum(@Param("userid") int userid);

    @Select("select count(id) from follow where followId = #{userid}")
    int getFollowedNum(@Param("userid") int userid);

    @Select("select imgurl from user where id = #{id}")
    String getImg(@Param("id") int id);

    @Select("select count(id) from article where userid = #{userid}")
    int getArticleNum(@Param("userid") int userid);

    @Select("select followId from follow where userid = #{userid}")
    List<Integer> getFollowId(@Param("userid") int userid);

    @Select("select userid from follow where followId = #{userid}")
    List<Integer> getFollowedId(@Param("userid") int userid);

    @Select("select name,imgurl as imageUrl,usershow from user where id = #{id}")
    FriendListVo getFriendList(@Param("id") int id);

    @Select("select count(id) from follow where userid = #{loginId} and followId = #{userid}")
    int isFollow(@Param("userid") int userid,@Param("loginId") int loginId);

    @Select("select id as articleId,img1 as imageUrl,title as name,time as content from article where userid = #{id}")
    List<ArticleListVo> getArticle(@Param("id") int id);

    @Select("select img1 from article where userid = #{userid}")
    String getArticleImg(@Param("userid") int userid);

    @Select("select id from article where userid = #{userid}")
    int getArticleidByUserid(@Param("userid") int userid);

    @Select("select id ,img1 as imageUrl from article where userid = #{userid}")
    List<Myshow1Vo> getMyshowVo1(@Param("userid") int userid);

    @Select("select am.articleId, a.img1 from articlemiddle as am left join article as a " +
            "on (am.articleId = a.id) where am.userid = #{userid} and am.support = '1'")
    List<Myshow1Vo> getMySupport(@Param("userid") int userid);

    @Select("select am.articleId, a.img1 from articlemiddle as am left join article as a " +
            "on (am.articleId = a.id) where am.userid = #{userid} and collection = '1'")
    List<Myshow1Vo> getMyCollection(@Param("userid") int userid);


}

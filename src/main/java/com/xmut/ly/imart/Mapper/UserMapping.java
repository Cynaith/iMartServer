package com.xmut.ly.imart.Mapper;

import com.xmut.ly.imart.Domain.User;
import com.xmut.ly.imart.ResultVo.ArticleListVo;
import com.xmut.ly.imart.ResultVo.FriendListVo;
import com.xmut.ly.imart.ResultVo.Myshow1Vo;
import com.xmut.ly.imart.ResultVo.UserInfoVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Past;
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

    @Select("select count(id) from follow where userid = #{userid} and status = 1")
    int getFollowNum(@Param("userid") int userid);

    @Select("select count(id) from follow where followId = #{userid} and status = 1")
    int getFollowedNum(@Param("userid") int userid);

    @Select("select imgurl from user where id = #{id}")
    String getImg(@Param("id") int id);

    @Select("select count(id) from article where userid = #{userid}")
    int getArticleNum(@Param("userid") int userid);

    @Select("select followId from follow where userid = #{userid} and status = 1")
    List<Integer> getFollowId(@Param("userid") int userid);

    @Select("select userid from follow where followId = #{userid} and status = 1")
    List<Integer> getFollowedId(@Param("userid") int userid);

    @Select("select name,imgurl as imageUrl,usershow from user where id = #{id}")
    FriendListVo getFriendList(@Param("id") int id);

    @Select("select count(id) from follow where userid = #{loginId} and followId = #{userid} and status = 1")
    int isFollow(@Param("userid") int userid,@Param("loginId") int loginId);

    @Select("select id as articleId,img1 as imageUrl,title as name,time as content from article where userid = #{id}")
    List<ArticleListVo> getArticle(@Param("id") int id);

    @Select("select a.id as articleId,a.img1 as imageUrl,a.title as name,a.time as content from article as a " +
            "left join articlemiddle as am on(a.id = am.articleId and am.userId = #{id}) where collection = 1")
    List<ArticleListVo> getCollection(@Param("id") int id);

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

    @Select("select count(am.id) from articlemiddle as am left join article as a on(am.articleId = a.id) where a.userid = #{userid} and am.support = 1")
    int totalArticleSupport(@Param("userid") int userid);

    @Select("select count(vm.id) from videomiddle as vm left join video as v on (vm.videoId = v.id) where v.userid = #{userid} and vm.support = 1")
    int totalVideoSupport(@Param("userid") int userid);


    @Select("select count(id) from follow where userid = #{userid} and followid = #{followid}")
    int checkFollow(@Param("userid") int userid,@Param("followid") int followid);

    @Insert("insert into follow(userId,followId) values(#{userid},#{followid})")
    void insertFollow(@Param("userid") int userid,@Param("followid") int followid);

    @Select("replace into follow(id,userid,followid,status) values ((select i.id from (select id from follow where userId = #{userid} and followId = #{followid}) as i),#{userid},#{followid},case when (select f.status from (select status from follow where userId = #{userid} and followId = #{followid}) as f)='1' then 0 else 1 end )")
    void replaceFollow(@Param("userid") int userid,@Param("followid") int followid);
}

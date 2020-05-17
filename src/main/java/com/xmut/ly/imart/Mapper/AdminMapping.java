package com.xmut.ly.imart.Mapper;

import com.xmut.ly.imart.Domain.User;
import com.xmut.ly.imart.ResultVo.AdminArticleVo;
import com.xmut.ly.imart.ResultVo.AdminCommentVo;
import com.xmut.ly.imart.ResultVo.AdminQuestionVo;
import com.xmut.ly.imart.ResultVo.AdminUserVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @USER: lynn
 * @DATE: 2020/3/28
 **/
@Mapper
@Repository
public interface AdminMapping {

    @Select("select id,usershow,name,phone,mail,status from user where name like CONCAT(\"%\",#{name},\"%\") ")
    public List<AdminUserVo> getUserInfo(@Param("name") String name);


    @Select("select a.id,u.name as username,a.title,a.text,a.support,a.time,a.status " +
            "from article as a left join user " +
            "as u on (a.userid = u.id) " +
            "where title like CONCAT(\"%\",#{title},\"%\") " +
            "and u.name like CONCAT(\"%\",#{name},\"%\")")
    public List<AdminArticleVo> getArticleInfo(@Param("title") String title,
                                               @Param("name") String name);

    @Select("select a.id,u.name as username,a.title,a.text,a.support,a.time,a.status from article as a left join user as u on (a.userid = u.id) where u.name like CONCAT(\"%\",#{name},\"%\") ")
    public List<AdminArticleVo> getArticleByName(@Param("name") String name);

    @Select("select c.id,a.title as articletitle,u.name as commentusername,c.content as text,c.createDate as time,c.status " +
            " from commentdetail as c " +
            "left join user " +
            "as u on (c.userid = u.id) " +
            "left join article " +
            "as a on (c.articleId = a.id)" +
            " where u.name like CONCAT(\"%\",#{name},\"%\") " +
            "and a.title like CONCAT(\"%\",#{title},\"%\") " +
            "and c.content like CONCAT(\"%\",#{text},\"%\")")
    public List<AdminCommentVo> getCommentInfo(@Param("name") String name,
                                               @Param("title") String title,
                                               @Param("text") String text);

    @Insert("insert into question(userid,message,title) values(#{id},#{msg},#{title}) ")
    public void question(@Param("id") int id,@Param("msg") String msg,@Param("title")String title);

    @Select("select q.id ,q.title,q.message ,u.name ,q.status from " +
            "question as q left join user as u on q.userid = u.id" +
            " where q.title like CONCAT(\"%\",#{title},\"%\") " +
            "and u.name like CONCAT(\"%\",#{name},\"%\")")
    public List<AdminQuestionVo> getQuestion(@Param("title") String title,@Param("name") String name);


    @Update("update article set status =(case when (select status from(select status from article where id = #{id}) as a)='1' then 0 else 1 end ) where id = #{id}")
    public void changeArticleContent(@Param("id") int id);

    @Update("update commentdetail set status =(case when (select status from(select status from commentdetail where id = #{id}) as a)='1' then 0 else 1 end ) where id = #{id}")
    public void changeCommentDetail(@Param("id") int id);

    @Update("update question set status =(case when (select status from(select status from question where id = #{id}) as a)='1' then 0 else 1 end ) where id = #{id}")
    public void changeQuestion(@Param("id") int id);
}

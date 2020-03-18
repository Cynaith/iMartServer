package com.xmut.ly.imart.Mapper;

import com.xmut.ly.imart.Domain.Article;
import com.xmut.ly.imart.ResultVo.ArticleMainVo;
import com.xmut.ly.imart.ResultVo.SecondMainVo;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @USER: lynn
 * @DATE: 2020/3/10
 **/

@Repository
@Mapper
public interface ArticleMapping {

    @Select("select id ,img1 as imageUrl,title as name,price,support as fire from article where kind = #{kind}")
    List<SecondMainVo> getSecondMain(@Param("kind") int kind);

    @Insert("insert into article(userId,title,text,kind,img1,price,time) values(#{userId},#{title},#{text},#{kind},#{img1},#{price},#{time})")
    boolean addArticle(Article article);

    @Select("select * from article where id = #{id}")
    ArticleMainVo getById(@Param("id") int id);

    @Select("replace into articlemiddle(id,userId,articleId,support,collection) values (#{id},#{userId},#{articleId},case when (select a.support from(select support from articlemiddle where id = #{id}) as a)='1' then 0 else 1 end ,case when (select b.collection from(select collection from articlemiddle where id = #{id}) as b)='1' then 1 else 0 end )")
    void support(@Param("id") String id,@Param("userId") int userId,@Param("articleId") int articleId);

    @Select("replace into articlemiddle(id,userId,articleId,support,collection) values (#{id},#{userId},#{articleId},case when (select a.support from(select support from articlemiddle where id = #{id}) as a)='1' then 1 else 0 end ,case when (select b.collection from(select collection from articlemiddle where id = #{id}) as b)='1' then 0 else 1 end)")
    void collection(@Param("id") String id,@Param("userId") int userId,@Param("articleId") int articleId);

    @Update("update articlemiddle set support = 0 where id = #{id}")
    void offsupport(@Param("id") String id);

    @Update("update articlemiddle set collection = 0 where id = #{id}")
    void offcollection(@Param("id") String id);

}

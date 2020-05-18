package com.xmut.ly.imart.Mapper;

import com.xmut.ly.imart.Domain.Article;
import com.xmut.ly.imart.Domain.Commentdetail;
import com.xmut.ly.imart.Domain.Replydetail;
import com.xmut.ly.imart.ResultVo.ArticleMainVo;
import com.xmut.ly.imart.ResultVo.CommentDetailVo;
import com.xmut.ly.imart.ResultVo.ReplyDetailVo;
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

    @Select("select a.id ,a.img1 as imageUrl,a.title as name,a.price,a.support as fire ,u.name as username from article as a left join user as u on (a.userid = u.id) where a.kind = #{kind} and a.status = 1 order by support desc")
    List<SecondMainVo> getSecondMain(@Param("kind") int kind);

    @Insert("insert into article(userid,title,text,kind,img1,price,time) values(#{userid},#{title},#{text},#{kind},#{img1},#{price},#{time})")
    boolean addArticle(Article article);

    @Select("select * from article where id = #{id}")
    ArticleMainVo getById(@Param("id") int id);

    @Select("replace into articlemiddle(id,userid,articleId,support,collection) values (#{id},#{userid},#{articleId},case when (select a.support from(select support from articlemiddle where id = #{id}) as a)='1' then 0 else 1 end ,case when (select b.collection from(select collection from articlemiddle where id = #{id}) as b)='1' then 1 else 0 end )")
    void support(@Param("id") String id,@Param("userid") int userid,@Param("articleId") int articleId);

    @Select("replace into articlemiddle(id,userid,articleId,support,collection) values (#{id},#{userid},#{articleId},case when (select a.support from(select support from articlemiddle where id = #{id}) as a)='1' then 1 else 0 end ,case when (select b.collection from(select collection from articlemiddle where id = #{id}) as b)='1' then 0 else 1 end)")
    void collection(@Param("id") String id,@Param("userid") int userid,@Param("articleId") int articleId);

    @Update("update articlemiddle set support = 0 where id = #{id}")
    void offsupport(@Param("id") String id);

    @Update("update articlemiddle set collection = 0 where id = #{id}")
    void offcollection(@Param("id") String id);

    @Select("select count(id) from articlemiddle where articleId = #{articleId} and support = 1")
    int getSupport(@Param("articleId") int articleId);

    @Select("select count(id) from articlemiddle where articleId = #{articleId} and collection = 1")
    int getCollection(@Param("articleId") int articleId);

    @Select("select id from article  where status = 1")
    List<Integer> getAllArticleId();

    @Select("update article set support = (select count(id) from articlemiddle where articleId = #{id}) where id = #{id} ")
    void updateArticleById(@Param("id") int id);

    @Select("select id,articleId,userid,content,createDate from commentdetail where articleId = #{articleId} and status = 1")
    List<CommentDetailVo> getCommentDetail(@Param("articleId") int articleId);

    @Select("select id,userid,commentId,content,createDate from replydetail where commentId = #{commentId} and status = 1")
    List<ReplyDetailVo> getReplyDetail(@Param("commentId") int commentId);

    @Insert("insert into commentdetail(articleId,userid,content,replyTotal,createDate) values(#{articleId},#{userid},#{content},0,#{createDate})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    void postComment(Commentdetail commentdetail);


    @Insert("insert into replydetail(commentId,userid,content,createDate) values(#{commentId},#{userid},#{content},#{createDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn = "id")
    void postReply(Replydetail replydetail);

    @Select("select support from articlemiddle where userid = #{userid} and articleId = #{articleId}")
    Integer getUserSupport(@Param("userid") int userid,@Param("articleId") int articleId);

    @Select("select collection from articlemiddle where userid = #{userid} and articleId = #{articleId}")
    Integer getUserCollection(@Param("userid") int userid,@Param("articleId") int articleId);

    @Insert("insert into articlemiddle(id,userid,articleId) values(#{id},#{userid},#{articleId})")
    void initMiddle(@Param("id") String id,@Param("userid") int userid,@Param("articleId") int articleId);

}

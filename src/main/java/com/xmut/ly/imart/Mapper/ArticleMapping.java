package com.xmut.ly.imart.Mapper;

import com.xmut.ly.imart.Domain.Article;
import com.xmut.ly.imart.ResultVo.ArticleMainVo;
import com.xmut.ly.imart.ResultVo.SecondMainVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
}

package com.xmut.ly.imart.Service.Impl;

import com.xmut.ly.imart.Domain.Article;
import com.xmut.ly.imart.Mapper.ArticleMapping;
import com.xmut.ly.imart.Mapper.UserMapping;
import com.xmut.ly.imart.RequestVo.AddArticleVo;
import com.xmut.ly.imart.ResultVo.ArticleMainVo;
import com.xmut.ly.imart.ResultVo.SecondMainVo;
import com.xmut.ly.imart.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;

/**
 * @USER: lynn
 * @DATE: 2020/3/10
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    UserMapping userMapping;
    @Autowired
    ArticleMapping articleMapping;

    @Override
    public List<SecondMainVo> getSecondMain(int kind) {

        List<SecondMainVo> secondMainVoList = articleMapping.getSecondMain(kind);
        return secondMainVoList;
    }

    @Override
    public boolean addArticle(AddArticleVo addArticleVo) {
        int userId = userMapping.getIdByUsername(addArticleVo.getUsername());
        String title = addArticleVo.getTitle();
        String text = addArticleVo.getText();
        int kind = addArticleVo.getKind();
        String img1 = addArticleVo.getImg1();
        Article article = new Article();
        article.setUserId(userId);
        article.setTitle(title);
        article.setText(text);
        article.setKind(kind);
        article.setImg1(img1);
        article.setPrice(99.9);
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");
        article.setTime(dateFormat.format(date));
        return articleMapping.addArticle(article);
    }

    @Override
    public ArticleMainVo getById(int id) {
        ArticleMainVo articleMainVo = articleMapping.getById(id);
        articleMainVo.setUsername(userMapping.getUsernameById(articleMainVo.getUserId()));
        articleMainVo.setUserInfo(userMapping.getShow(articleMainVo.getUsername()));
        articleMainVo.setUserImg(userMapping.getImg(articleMainVo.getUserId()));
        return articleMainVo;
    }

    @Override
    public void action(String username, int articleId, int kind) {
        int userId = userMapping.getIdByUsername(username);
        String userAddArticle = userId+"-"+articleId;
        if (kind == 1) {        //点赞
            articleMapping.support(userAddArticle, userId, articleId);
        } else if (kind ==2){   //收藏
            articleMapping.collection(userAddArticle, userId, articleId);
        }

    }
}

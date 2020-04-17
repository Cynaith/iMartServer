package com.xmut.ly.imart.Service;

import com.xmut.ly.imart.RequestVo.AddArticleVo;
import com.xmut.ly.imart.ResultVo.*;

import java.util.List;

/**
 * @USER: lynn
 * @DATE: 2020/3/10
 **/
public interface ArticleService {
    List<SecondMainVo> getSecondMain(int kind);
    boolean addArticle(AddArticleVo addArticleVo);
    ArticleMainVo getById(int id);
    void action(String username,int articleId,int kind);
    int getSupportById(int articleId);
    int getCollectionById(int articleId);
    void updateMiddle();
    List<CommentDetailVo> getComment(int articleId);
    CommentDetailVo postComment(int articleId,String username,String content);
    ReplyDetailVo postReply(int commentId, String username, String content);
    ActionStatusVo getActionStatus(String username,int articleId);
}

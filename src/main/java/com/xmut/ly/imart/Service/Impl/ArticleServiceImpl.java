package com.xmut.ly.imart.Service.Impl;

import com.xmut.ly.imart.Domain.Article;
import com.xmut.ly.imart.Domain.Commentdetail;
import com.xmut.ly.imart.Domain.Replydetail;
import com.xmut.ly.imart.Mapper.ArticleMapping;
import com.xmut.ly.imart.Mapper.UserMapping;
import com.xmut.ly.imart.RequestVo.AddArticleVo;
import com.xmut.ly.imart.ResultVo.*;
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
        int userid = userMapping.getIdByUsername(addArticleVo.getUsername());
        String title = addArticleVo.getTitle();
        String text = addArticleVo.getText();
        int kind = addArticleVo.getKind();
        String img1 = addArticleVo.getImg1();
        Article article = new Article();
        article.setUserid(userid);
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
        articleMainVo.setUsername(userMapping.getUsernameById(articleMainVo.getUserid()));
        articleMainVo.setUserInfo(userMapping.getShow(articleMainVo.getUsername()));
        articleMainVo.setUserImg(userMapping.getImg(articleMainVo.getUserid()));
        return articleMainVo;
    }

    @Override
    public void action(String username, int articleId, int kind) {
        int userid = userMapping.getIdByUsername(username);
        String userAddArticle = userid+"-"+articleId;
        if (kind == 1) {        //点赞
            articleMapping.support(userAddArticle, userid, articleId);
        } else if (kind ==2){   //收藏
            articleMapping.collection(userAddArticle, userid, articleId);
        }

    }

    @Override
    public int getSupportById(int articleId) {
        return articleMapping.getSupport(articleId);
    }

    @Override
    public int getCollectionById(int articleId) {
        return articleMapping.getCollection(articleId);
    }

    @Override
    public void updateMiddle() {
        List<Integer> list = articleMapping.getAllArticleId();
        list.forEach(integer -> {articleMapping.updateArticleById(integer);});
    }

    @Override
    public List<CommentDetailVo> getComment(int articleId) {
        List<CommentDetailVo> commentDetailVos = articleMapping.getCommentDetail(articleId);
        commentDetailVos.forEach(commentDetailVo -> {
                    commentDetailVo.setNickName(
                            userMapping.getUsernameById(commentDetailVo.getUserid()));
                    commentDetailVo.setUserLogo(
                            userMapping.getImg(commentDetailVo.getUserid())
                    );
                    List<ReplyDetailVo> replyDetailVoList =
                            articleMapping.getReplyDetail(commentDetailVo.getId());
                    replyDetailVoList.forEach(replyDetailVo ->{
                        replyDetailVo.setNickName(
                                userMapping.getUsernameById(replyDetailVo.getUserid())
                        );
                        replyDetailVo.setUserLogo(
                                userMapping.getImg(replyDetailVo.getUserid()));
                    });
                    commentDetailVo.setReplyList(replyDetailVoList);
                    commentDetailVo.setReplyTotal(replyDetailVoList.size());
                }
                 );

        return commentDetailVos;
    }

    @Override
    public CommentDetailVo postComment(int articleId, String username, String content) {
        //插入评论
        int userid = userMapping.getIdByUsername(username);
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");
        String createDate = dateFormat.format(date);
        Commentdetail commentdetail = new Commentdetail();
        commentdetail.setArticleId(articleId);
        commentdetail.setUserid(userid);
        commentdetail.setCreateDate(createDate);
        commentdetail.setContent(content);
        articleMapping.postComment(commentdetail);


        //获取插入这条的信息
        CommentDetailVo commentDetailVo = new CommentDetailVo();
        commentDetailVo.setId(commentdetail.getId());
        commentDetailVo.setUserid(userid);
        commentDetailVo.setNickName(username);
        commentDetailVo.setContent(content);
        commentDetailVo.setUserLogo(userMapping.getImg(userid));
        commentDetailVo.setCreateDate(createDate);
        return commentDetailVo;
    }

    @Override
    public ReplyDetailVo postReply(int commentId, String username, String content) {
        int userid = userMapping.getIdByUsername(username);
        Replydetail replydetail = new Replydetail();
        replydetail.setUserid(userid);
        replydetail.setCommentId(commentId);
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");
        String createDate = dateFormat.format(date);
        replydetail.setCreateDate(createDate);
        replydetail.setContent(content);
        articleMapping.postReply(replydetail);
        ReplyDetailVo replyDetailVo = new ReplyDetailVo();
        replyDetailVo.setId(replydetail.getId());
        replyDetailVo.setUserid(userid);
        replyDetailVo.setNickName(username);
        replyDetailVo.setCommentId(commentId);
        replyDetailVo.setContent(content);
        replyDetailVo.setCreateDate(createDate);
        return replyDetailVo;
    }

    /**
     * 获取点赞状态
     * @param username
     * @param articleId
     * @return
     */
    @Override
    public ActionStatusVo getActionStatus(String username, int articleId) {
        int userid = userMapping.getIdByUsername(username);
        int isSupport = 0;
        int isCollection = 0;
        try{
            isSupport = articleMapping.getUserSupport(userid,articleId);
            isCollection = articleMapping.getUserCollection(userid,articleId);
        }catch (Exception e){
            String userAddArticle = userid+"-"+articleId;
            articleMapping.initMiddle(userAddArticle,userid,articleId);
        }

        ActionStatusVo actionStatusVo = new ActionStatusVo();
        actionStatusVo.setSupport(isSupport>0);
        actionStatusVo.setCollection(isCollection>0);
        actionStatusVo.setSupportCount(articleMapping.getSupport(articleId));
        actionStatusVo.setCollectionCount(articleMapping.getCollection(articleId));
        return actionStatusVo;
    }
}

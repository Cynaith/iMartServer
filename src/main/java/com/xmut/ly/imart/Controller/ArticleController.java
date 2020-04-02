package com.xmut.ly.imart.Controller;

import com.xmut.ly.imart.RequestVo.AddArticleVo;
import com.xmut.ly.imart.Service.ArticleService;
import com.xmut.ly.imart.Utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @USER: lynn
 * @DATE: 2020/3/10
 **/

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("getAll")
    public ResponseWrapper getAllArticle(@RequestParam("kind") int kind){
        articleService.updateMiddle();
        return ResponseWrapper.markSuccess(articleService.getSecondMain(kind));
    }

    @RequestMapping(value = "add")
    public ResponseWrapper addArticle(AddArticleVo addArticleVo){
        return ResponseWrapper.markSuccess(articleService.addArticle(addArticleVo));
    }

    @RequestMapping("getById")
    public ResponseWrapper getById(@RequestParam("id") int id){
        return  ResponseWrapper.markSuccess(articleService.getById(id));
    }

    @RequestMapping("action")  //kind =1点赞 =2收藏
    public ResponseWrapper action(@RequestParam("username") String username,@RequestParam("articleId") int articleId,@RequestParam("kind") int kind){
        articleService.action(username, articleId, kind);
        return ResponseWrapper.markSuccessButNoData();
    }

    @RequestMapping("support")
    public ResponseWrapper getSupportById(@RequestParam("articleId") int articleId){
        return ResponseWrapper.markSuccess(articleService.getSupportById(articleId));
    }

    @RequestMapping("collection")
    public ResponseWrapper getCollectionById(@RequestParam("articleId") int articleId){
        return ResponseWrapper.markSuccess(articleService.getCollectionById(articleId));
    }

    @RequestMapping("updateMiddle")
    public ResponseWrapper updateMiddle(){
        articleService.updateMiddle();
        return ResponseWrapper.markSuccessButNoData();
    }

    @RequestMapping("getComment")
    public ResponseWrapper getComment(@RequestParam("articleId") int articleId){
        return ResponseWrapper.markSuccess(articleService.getComment(articleId));
    }

    @RequestMapping("postComment")
    public ResponseWrapper postComment(@RequestParam("articleId") int articleId,
                                       @RequestParam("username") String username,
                                       @RequestParam("content") String content){
        return ResponseWrapper.markSuccess(articleService.postComment(articleId, username, content));
    }

    @RequestMapping("postReply")
    public ResponseWrapper postReply(@RequestParam("commentId") int commentId,
                                     @RequestParam("username") String username,
                                     @RequestParam("content") String content){
        return ResponseWrapper.markSuccess(articleService.postReply(commentId, username, content));
    }

    @RequestMapping("actionStatus")
    public ResponseWrapper actionStatus(@RequestParam("username") String username,
                                        @RequestParam("articleId") int articleId){
        return ResponseWrapper.markSuccess(articleService.getActionStatus(username, articleId));
    }
}

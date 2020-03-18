package com.xmut.ly.imart.Controller;

import com.xmut.ly.imart.RequestVo.AddArticleVo;
import com.xmut.ly.imart.Service.ArticleService;
import com.xmut.ly.imart.Utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
        return ResponseWrapper.markSuccess(articleService.getSecondMain(kind));
    }

    @RequestMapping("add")
    public ResponseWrapper addArticle(AddArticleVo addArticleVo){
        return ResponseWrapper.markSuccess(articleService.addArticle(addArticleVo));
    }

    @RequestMapping("getById")
    public ResponseWrapper getById(@RequestParam("id") int id){
        return  ResponseWrapper.markSuccess(articleService.getById(id));
    }

    @RequestMapping("action")
    public ResponseWrapper action(@RequestParam("username") String username,@RequestParam("articleId") int articleId,@RequestParam("kind") int kind){
        articleService.action(username, articleId, kind);
        return ResponseWrapper.markSuccessButNoData();
    }


}

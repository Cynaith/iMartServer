package com.xmut.ly.imart.Controller;

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


}

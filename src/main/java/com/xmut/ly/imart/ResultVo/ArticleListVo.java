package com.xmut.ly.imart.ResultVo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @USER: lynn
 * @DATE: 2020/3/10
 **/

@Data
@AllArgsConstructor
public class ArticleListVo {
    public int articleId;

    public String imageUrl;

    public String name;

    public String content;
}

package com.xmut.ly.imart.RequestVo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @USER: lynn
 * @DATE: 2020/3/16
 **/


@AllArgsConstructor
@Data
public class AddArticleVo {

    String username;
    String title;
    String text;
    int kind;
    String img1;
}

package com.xmut.ly.imart.ResultVo;

import lombok.Data;

/**
 * @USER: lynn
 * @DATE: 2020/3/29
 **/

@Data
public class AdminArticleVo {
    int id;
    String username;
    String title;
    String text;
    int support;
    String time;
    int status;
}

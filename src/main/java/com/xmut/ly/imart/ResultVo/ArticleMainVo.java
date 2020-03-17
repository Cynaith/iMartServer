package com.xmut.ly.imart.ResultVo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @USER: lynn
 * @DATE: 2020/3/17
 **/

@Data
public class ArticleMainVo {
    int userId;
    String username;
    String title;
    String userInfo;
    String text;
    String time;
    String userImg;
//    要加一个List评论
}

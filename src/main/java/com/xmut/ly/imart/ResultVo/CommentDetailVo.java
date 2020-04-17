package com.xmut.ly.imart.ResultVo;

import lombok.Data;

import java.util.List;

/**
 * @USER: lynn
 * @DATE: 2020/3/19
 **/

@Data
public class CommentDetailVo {
    private int id;
    int articleId;
    int userid;
    private String nickName;
    private String userLogo;
    private String content;
    private String imgId;
    private int replyTotal;
    private String createDate;
    private List<ReplyDetailVo> replyList;
}

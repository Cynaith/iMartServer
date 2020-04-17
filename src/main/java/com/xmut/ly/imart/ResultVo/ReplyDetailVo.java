package com.xmut.ly.imart.ResultVo;

import lombok.Data;

/**
 * @USER: lynn
 * @DATE: 2020/3/19
 **/

@Data
public class ReplyDetailVo {
    private String nickName;
    private String userLogo;
    private int id;
    private int userid;
    private int commentId;
    private String content;
    private String status;
    private String createDate;
}

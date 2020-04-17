package com.xmut.ly.imart.ResultVo;

import lombok.Data;

/**
 * @USER: lynn
 * @DATE: 2020/3/29
 **/
@Data
public class AdminCommentVo {
    int id;
    String articletitle;
    String commentusername;
    String text;
    String time;
    int status;
}

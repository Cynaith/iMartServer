package com.xmut.ly.imart.ResultVo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @USER: lynn
 * @DATE: 2020/3/10
 **/

@AllArgsConstructor
@Data
public class MyshowVo {
    String username;

    String userinfo;

    String userimg;

    int followNum;

    int followedNum;

    int articleNum;

    boolean isFollow;
}

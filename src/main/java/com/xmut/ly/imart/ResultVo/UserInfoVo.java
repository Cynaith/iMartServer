package com.xmut.ly.imart.ResultVo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @USER: lynn
 * @DATE: 2020/3/9
 **/

@Data
@AllArgsConstructor
public class UserInfoVo {

    String userName;
    String userShow;
    int followNum;
    int followedNum;
    int articleNum;
    String imgUrl;
//    int friendNum;
}

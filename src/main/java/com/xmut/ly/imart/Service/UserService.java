package com.xmut.ly.imart.Service;

import com.xmut.ly.imart.Domain.User;
import com.xmut.ly.imart.ResultVo.FriendListVo;
import com.xmut.ly.imart.ResultVo.UserInfoVo;

import java.util.List;


public interface UserService {
    //登陆
    boolean checkCodeByUserphone(String userPhone,int code);
    boolean haveUserByUserphone(String userPhone);
    User findUserByUserphone(String userPhone);
    //获取用户信息
    UserInfoVo getUserInfo(String userName);
    List<FriendListVo> getFollow(String userName);
    List<FriendListVo> getFollowed(String userName);

}

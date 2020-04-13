package com.xmut.ly.imart.Service;

import com.xmut.ly.imart.Domain.User;
import com.xmut.ly.imart.ResultVo.*;

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
    List<ArticleListVo> getArticle(String userName);
    List<ArticleListVo> getCollection(String userName);

    MyshowVo getShow(String userName,String loginName);
    List<Myshow1Vo> getMyshow1(String userName);
    List<Myshow1Vo> getMyshow2(String userName);
    List<Myshow1Vo> getMyshow3(String userName);
    String getUserimg(String username);
    void followUser(String followName,String userName);
    void update(String usershow,String userimg,String name,int age);
}

package com.xmut.ly.imart.Service.Impl;

import com.xmut.ly.imart.Domain.User;
import com.xmut.ly.imart.Mapper.UserMapping;
import com.xmut.ly.imart.RequestVo.RegisterVo;
import com.xmut.ly.imart.ResultVo.*;
import com.xmut.ly.imart.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    UserMapping userMapping;

    @Override
    public void register(RegisterVo registerVo) {
        userMapping.register(registerVo);
    }

    @Override
    public boolean checkCodeByUserphone(String userPhone, int code) {
        return true;
    }

    @Override
    public boolean haveUserByUserphone(String userPhone) {

        try {
            userMapping.haveUserByUserphone(userPhone);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public User findUserByUserphone(String userPhone) {
        return userMapping.findUserByUserphone(userPhone);
    }

    @Override
    public UserInfoVo getUserInfo(String userName) {
        int id = userMapping.getIdByUsername(userName);
        String show = userMapping.getShow(userName);
        int followNum = userMapping.getFollowNum(id);
        int followedNum = userMapping.getFollowedNum(id);
        int articleNum = userMapping.getArticleNum(id);
        String imgUrl = userMapping.getImg(id);
        int supportNum = userMapping.totalArticleSupport(id);
        supportNum+=userMapping.totalVideoSupport(id);
        UserInfoVo infoVo = new UserInfoVo(userName, show, followNum, followedNum, articleNum, imgUrl,supportNum);
        return infoVo;
    }

    @Override
    public List<FriendListVo> getFollow(String userName) {
        int id = userMapping.getIdByUsername(userName);
        List<Integer> followid = new ArrayList<Integer>();
        List<FriendListVo> friendListVoList = new ArrayList<FriendListVo>();
        followid = userMapping.getFollowId(id);
        if (followid.size() > 0)
            for (int i = 0; i < followid.size(); i++) {
//            System.out.println(userMapping.getFriendList(followid.get(i)));
                FriendListVo friendListVo = userMapping.getFriendList(followid.get(i));
                friendListVoList.add(friendListVo);
            }
        return friendListVoList;
    }
    @Override
    public List<FriendListVo> getSupport(String userName) {
        int id = userMapping.getIdByUsername(userName);
        List<FriendListVo> friendListVoList = new ArrayList<FriendListVo>();
        friendListVoList = userMapping.getWhoSupported(id);
        friendListVoList.forEach(friendListVo -> {
            friendListVo.setContent("你点赞了此用户的：\""+friendListVo.getContent()+"\"");
        });
        return friendListVoList;
    }
    @Override
    public List<FriendListVo> getFollowed(String userName) {
        int id = userMapping.getIdByUsername(userName);
        List<Integer> followid = new ArrayList<Integer>();
        List<FriendListVo> friendListVoList = new ArrayList<FriendListVo>();
        followid = userMapping.getFollowedId(id);
        if (followid.size() > 0)
            for (int i = 0; i < followid.size(); i++) {
//                System.out.println(userMapping.getFriendList(followid.get(i)));
                FriendListVo friendListVo = userMapping.getFriendList(followid.get(i));
                friendListVoList.add(friendListVo);
            }
        return friendListVoList;
    }

    @Override
    public List<ArticleListVo> getArticle(String userName) {
        int id = userMapping.getIdByUsername(userName);
        List<ArticleListVo> articleList = userMapping.getArticle(id);

        return articleList;
    }

    @Override
    public List<ArticleListVo> getCollection(String userName) {
        int id = userMapping.getIdByUsername(userName);
        List<ArticleListVo> articleList = userMapping.getCollection(id);
        return articleList;
    }

    @Override
    public MyshowVo getShow(String userName, String loginName) {
        int id = userMapping.getIdByUsername(userName);
        int loginId = userMapping.getIdByUsername(loginName);
        boolean isFollow;

        //如果自己进自己的主页
        if (id != loginId) {
            isFollow = userMapping.isFollow(id, loginId) > 0 ? true : false;
        } else isFollow = true;
        String userInfo = userMapping.getShow(userName);
        String userimg = userMapping.getImg(id);
        int followNum = userMapping.getFollowNum(id);
        int followedNum = userMapping.getFollowedNum(id);
        int articleNum = userMapping.getArticleNum(id);


        MyshowVo myshowVo = new MyshowVo(userName, userInfo, userimg, followNum, followedNum, articleNum, isFollow);
        return myshowVo;
    }

    @Override
    public List<Myshow1Vo> getMyshow1(String userName) {
        int userid = userMapping.getIdByUsername(userName);
        return userMapping.getMyshowVo1(userid);
    }

    @Override
    public List<Myshow1Vo> getMyshow2(String userName) {
        int userid = userMapping.getIdByUsername(userName);
        return userMapping.getMySupport(userid);
    }

    @Override
    public List<Myshow1Vo> getMyshow3(String userName) {
        int userid = userMapping.getIdByUsername(userName);
        return userMapping.getMyCollection(userid);
    }

    @Override
    public String getUserimg(String username) {
        String imgurl = null;
        try {
             imgurl = userMapping.getImg(userMapping.getIdByUsername(username));
        }catch (Exception e){
            imgurl = userMapping.getImg(userMapping.getIdByUsername("admin"));
        }
        return imgurl;
    }

    @Override
    public void followUser(String followName, String userName) {
        int followid = userMapping.getIdByUsername(followName);
        int userid = userMapping.getIdByUsername(userName);
        int isFollowed = userMapping.checkFollow(userid,followid);
        if (isFollowed != 0 ){
            userMapping.replaceFollow(userid,followid);
        }else {
            userMapping.insertFollow(userid,followid);
        }
    }

    @Override
    public void update(String usershow, String userimg,String name,int age) {
        if (userimg.equals("")) userimg=null;
        if (usershow.equals("")) usershow=null;
    userMapping.update(usershow, userimg, name,age);
    }
}

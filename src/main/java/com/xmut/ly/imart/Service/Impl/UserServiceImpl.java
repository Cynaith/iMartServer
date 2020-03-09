package com.xmut.ly.imart.Service.Impl;

import com.xmut.ly.imart.Domain.User;
import com.xmut.ly.imart.Mapper.UserMapping;
import com.xmut.ly.imart.ResultVo.FriendListVo;
import com.xmut.ly.imart.ResultVo.UserInfoVo;
import com.xmut.ly.imart.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    UserMapping userMapping;

    @Override
    public boolean checkCodeByUserphone(String userPhone, int code) {
        return true;
    }

    @Override
    public boolean haveUserByUserphone(String userPhone) {

        try {
            userMapping.haveUserByUserphone(userPhone);
            return true;
        }catch (Exception e){
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
        UserInfoVo infoVo = new UserInfoVo(userName,show,followNum,followedNum,articleNum,imgUrl);
        return infoVo;
    }

    @Override
    public List<FriendListVo> getFollow(String userName) {
        int id = userMapping.getIdByUsername(userName);
        List<Integer> followid = new ArrayList<Integer>();
        List<FriendListVo> friendListVoList = new ArrayList<FriendListVo>();
        followid = userMapping.getFollowId(id);
        if (followid.size()>0)
        for(int i = 0;i<followid.size();i++){
            FriendListVo friendListVo =userMapping.getFriendList(followid.get(i));
            friendListVoList.add(friendListVo);
        }
        return friendListVoList;
    }

    @Override
    public List<FriendListVo> getFollowed(String userName) {
        int id = userMapping.getIdByUsername(userName);
        List<Integer> followid = new ArrayList<Integer>();
        List<FriendListVo> friendListVoList = new ArrayList<FriendListVo>();
        followid = userMapping.getFollowedId(id);
        if (followid.size()>0)
            for(int i = 0;i<followid.size();i++){
                FriendListVo friendListVo =userMapping.getFriendList(followid.get(i));
                friendListVoList.add(friendListVo);
            }
        return friendListVoList;
    }
}

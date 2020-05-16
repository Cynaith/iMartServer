package com.xmut.ly.imart.Service.Impl;

import com.xmut.ly.imart.Domain.User;
import com.xmut.ly.imart.Mapper.AdminMapping;
import com.xmut.ly.imart.Mapper.UserMapping;
import com.xmut.ly.imart.ResultVo.AdminArticleVo;
import com.xmut.ly.imart.ResultVo.AdminCommentVo;
import com.xmut.ly.imart.ResultVo.AdminQuestionVo;
import com.xmut.ly.imart.ResultVo.AdminUserVo;
import com.xmut.ly.imart.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @USER: lynn
 * @DATE: 2020/3/28
 **/

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapping adminMapping;

    @Autowired
    UserMapping userMapping;
    @Override
    public List<AdminUserVo> getUserInfo(String name) {
        return adminMapping.getUserInfo(name);
    }

    @Override
    public List<AdminArticleVo> getArticleInfo(String title,String name) {
        return adminMapping.getArticleInfo(title,name);
    }

    @Override
    public List<AdminArticleVo> getArticleByName(String name) {
        return adminMapping.getArticleByName(name);
    }

    @Override
    public List<AdminCommentVo> getCommentInfo(String name,String title,String text) {
        return adminMapping.getCommentInfo(name,title,text);
    }

    @Override
    public void Question(String username, String message,String title) {
        int id = userMapping.getIdByUsername(username);
        adminMapping.question(id,message,title);
    }

    @Override
    public List<AdminQuestionVo> getQuestion(String title, String name) {
        return adminMapping.getQuestion(title,name);
    }
}

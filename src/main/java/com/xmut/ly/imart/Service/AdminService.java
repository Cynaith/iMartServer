package com.xmut.ly.imart.Service;

import com.xmut.ly.imart.Domain.User;
import com.xmut.ly.imart.ResultVo.AdminArticleVo;
import com.xmut.ly.imart.ResultVo.AdminCommentVo;
import com.xmut.ly.imart.ResultVo.AdminUserVo;

import java.util.List;

/**
 * @USER: lynn
 * @DATE: 2020/3/28
 **/
public interface AdminService {
    List<AdminUserVo> getUserInfo(String name);
    List<AdminArticleVo> getArticleInfo(String title,String name);
    List<AdminArticleVo> getArticleByName(String name);
    List<AdminCommentVo> getCommentInfo(String name,String title,String text);
 }

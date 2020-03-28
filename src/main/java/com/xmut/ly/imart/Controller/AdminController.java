package com.xmut.ly.imart.Controller;

import com.xmut.ly.imart.ResultVo.AdminArticleVo;
import com.xmut.ly.imart.ResultVo.AdminCommentVo;
import com.xmut.ly.imart.ResultVo.AdminUserVo;
import com.xmut.ly.imart.Service.AdminService;
import com.xmut.ly.imart.Utils.PageWrapperForLayui;
import com.xmut.ly.imart.Utils.ResponseWrapper;
import com.xmut.ly.imart.repository.ArticleRepository;
import com.xmut.ly.imart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @USER: lynn
 * @DATE: 2020/3/28
 **/

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    AdminService adminService;

//    @RequestMapping("getuserinfo")
//    public PageWrapperForLayui getUserInfo(@RequestParam(name = "page", defaultValue = "1") int page,
//                                           @RequestParam(name = "limit", defaultValue = "10") int size) {
//
//        Pageable pageable = PageRequest.of(page - 1, size);
//        return PageWrapperForLayui.markSuccess((int) userRepository.count(), userRepository.findAll(pageable));
//    }
//
//    @RequestMapping("getarticleinfo")
//    public PageWrapperForLayui getArticleInfo(@RequestParam(name = "page", defaultValue = "1") int page,
//                                              @RequestParam(name = "limit", defaultValue = "10") int size) {
//        Pageable pageable = PageRequest.of(page - 1, size);
//        return PageWrapperForLayui.markSuccess((int) articleRepository.count(), articleRepository.findAll(pageable));
//    }

    @RequestMapping("getuserinfo")
    public PageWrapperForLayui getUserInfo(@RequestParam(value = "name",defaultValue = "") String name){
        List<AdminUserVo> adminUserVos = adminService.getUserInfo(name);
        return PageWrapperForLayui.markSuccess(adminUserVos.size(),adminUserVos);
    }

    @RequestMapping("getarticleinfo")
    public PageWrapperForLayui getArticleInfo(@RequestParam(value = "title",defaultValue = "") String title){
        List<AdminArticleVo> adminArticleVos = adminService.getArticleInfo(title);

        return PageWrapperForLayui.markSuccess(adminArticleVos.size(),adminArticleVos);
    }

    @RequestMapping("getarticleinfobyname")
    public PageWrapperForLayui getarticleinfobyname(@RequestParam(value = "name",defaultValue = "") String name){
        List<AdminArticleVo> adminArticleVos = adminService.getArticleByName(name);
        return PageWrapperForLayui.markSuccess(adminArticleVos.size(),adminArticleVos);
    }


    @RequestMapping("getarticlecomment")
    public PageWrapperForLayui getArticleComment(@RequestParam(value = "name",defaultValue = "") String username ){
        List<AdminCommentVo> adminCommentVos = adminService.getCommentInfo(username);
        return PageWrapperForLayui.markSuccess(adminCommentVos.size(),adminCommentVos);
    }

}

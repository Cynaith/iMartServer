package com.xmut.ly.imart.Controller;

import com.xmut.ly.imart.ResultVo.AdminArticleVo;
import com.xmut.ly.imart.ResultVo.AdminCommentVo;
import com.xmut.ly.imart.ResultVo.AdminUserVo;
import com.xmut.ly.imart.Service.AdminService;
import com.xmut.ly.imart.Utils.PageWrapperForLayui;
import com.xmut.ly.imart.Utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @USER: lynn
 * @DATE: 2020/3/28
 **/

@RestController
@RequestMapping("admin")
public class AdminController {


    @Autowired
    AdminService adminService;



    @RequestMapping("getuserinfo")
    public PageWrapperForLayui getUserInfo(@RequestParam(value = "name", defaultValue = "") String name,
                                           @RequestParam(value = "page", defaultValue = "1") int page,
                                           @RequestParam(value = "limit", defaultValue = "10") int size) {
        List<AdminUserVo> adminUserVos = adminService.getUserInfo(name);
        List<AdminUserVo> returnlist = new ArrayList<>();
        final int[] i = {0};
        adminUserVos.forEach(adminUserVo -> {
            if (i[0] > (page - 1) * size - 1 && i[0] < page * size) {
                returnlist.add(adminUserVo);
            }
            i[0]++;
        });
        return PageWrapperForLayui.markSuccess(adminUserVos.size(), returnlist);
    }

    @RequestMapping("getarticleinfo")
    public PageWrapperForLayui getArticleInfo(@RequestParam(value = "name", defaultValue = "") String name,
                                              @RequestParam(value = "title", defaultValue = "") String title,
                                              @RequestParam(value = "page", defaultValue = "1") int page,
                                              @RequestParam(value = "limit", defaultValue = "10") int size) {
        List<AdminArticleVo> adminArticleVos = adminService.getArticleInfo(title,name);
        List<AdminArticleVo> returnlist = new ArrayList<>();
        final int[] i = {0};
        adminArticleVos.forEach(adminArticleVo -> {
            if (i[0] > ((page - 1) * size - 1) && i[0] < (page * size)) {
                returnlist.add(adminArticleVo);
            }
            i[0]++;
        });
        return PageWrapperForLayui.markSuccess(adminArticleVos.size(), returnlist);
    }

//    @RequestMapping("getarticleinfobyname")
//    public PageWrapperForLayui getarticleinfobyname(@RequestParam(value = "name", defaultValue = "") String name,
//                                                    @RequestParam(value = "page", defaultValue = "1") int page,
//                                                    @RequestParam(value = "limit", defaultValue = "10") int size) {
//        List<AdminArticleVo> adminArticleVos = adminService.getArticleByName(name);
//        List<AdminArticleVo> returnlist = new ArrayList<>();
//        final int[] i = {0};
//        adminArticleVos.forEach(adminArticleVo -> {
//            if (i[0] > ((page - 1) * size - 1) && i[0] < (page * size)) {
//                returnlist.add(adminArticleVo);
//            }
//            i[0]++;
//        });
//        return PageWrapperForLayui.markSuccess(adminArticleVos.size(), returnlist);
//    }


    @RequestMapping("getarticlecomment")
    public PageWrapperForLayui getArticleComment(@RequestParam(value = "title", defaultValue = "") String title,
                                                 @RequestParam(value = "name", defaultValue = "") String username,
                                                 @RequestParam(value = "text", defaultValue = "") String text,
                                                 @RequestParam(value = "page", defaultValue = "1") int page,
                                                 @RequestParam(value = "limit", defaultValue = "10") int size) {
        List<AdminCommentVo> adminCommentVos = adminService.getCommentInfo(username, title,text);
        List<AdminCommentVo> returnlist = new ArrayList<>();
        final int[] i = {0};
        adminCommentVos.forEach(adminComment -> {
            if (i[0] > ((page - 1) * size - 1) && i[0] < (page * size)) {
                returnlist.add(adminComment);
            }
            i[0]++;
        });
        return PageWrapperForLayui.markSuccess(adminCommentVos.size(), returnlist);
    }

}

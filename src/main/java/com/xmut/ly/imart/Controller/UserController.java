package com.xmut.ly.imart.Controller;

import com.xmut.ly.imart.Domain.User;
import com.xmut.ly.imart.RequestVo.RegisterVo;
import com.xmut.ly.imart.Service.UserService;
import com.xmut.ly.imart.Utils.ResponseWrapper;
import com.xmut.ly.imart.Utils.ReturnCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("register")
    public void register(RegisterVo registerVo){
        userService.register(registerVo);
    }

    @RequestMapping("/login")
    public ResponseWrapper UserLogin(@RequestParam("userPhone") String userPhone, @RequestParam("userCode") int userCode) {

        //判断验证码是否正确
        if (userService.checkCodeByUserphone(userPhone, userCode)) {
            //是否注册过
            if (userService.haveUserByUserphone(userPhone)) {
                return ResponseWrapper.markSuccess(userService.findUserByUserphone(userPhone));
            }
            //第一次登陆
            else {
                return ResponseWrapper.markCustom(true, "0001", "注册", ReturnCode.NODATA);
            }
        }
        return ResponseWrapper.markError();

    }

    @RequestMapping("info")
    public ResponseWrapper UserInfo(@RequestParam("userName") String userName) {
        return ResponseWrapper.markSuccess(userService.getUserInfo(userName));
    }

    @RequestMapping("follow")
    public ResponseWrapper getFollow(@RequestParam("userName") String userName) {
        return ResponseWrapper.markSuccess(userService.getFollow(userName));
    }

    @RequestMapping("followed")
    public ResponseWrapper getFollowed(@RequestParam("userName") String userName) {
        return ResponseWrapper.markSuccess(userService.getFollowed(userName));
    }

    @RequestMapping("myshow")
    //userName 主页人的名字
    //user 登陆账户
    public ResponseWrapper getShow(@RequestParam("userName") String userName, @RequestParam("loginName") String loginName) {
        return ResponseWrapper.markSuccess(userService.getShow(userName, loginName));
    }

    @RequestMapping("article")
    public ResponseWrapper getArticle(@RequestParam("userName") String userName) {
        return ResponseWrapper.markSuccess(userService.getArticle(userName));
    }

    @RequestMapping("collection")
    public ResponseWrapper getCollection(@RequestParam("userName") String username) {
        return ResponseWrapper.markSuccess(userService.getCollection(username));
    }

    @RequestMapping("myshow1")
    public ResponseWrapper getMyshow1(@RequestParam("userName") String userName) {
        return ResponseWrapper.markSuccess(userService.getMyshow1(userName));
    }

    @RequestMapping("myshow2")
    public ResponseWrapper getMyshow2(@RequestParam("userName") String userName) {
        return ResponseWrapper.markSuccess(userService.getMyshow2(userName));
    }

    @RequestMapping("myshow3")
    public ResponseWrapper getMyshow3(@RequestParam("userName") String userName) {
        return ResponseWrapper.markSuccess(userService.getMyshow3(userName));
    }

    @RequestMapping("getUserimg")
    public String getUserimg(@RequestParam(value = "username", defaultValue = "admin") String username) {
        return userService.getUserimg(username);
    }

    @RequestMapping("followUser")
    public void followUser(@RequestParam("followName") String followName,
                           @RequestParam("userName") String userName) {
        userService.followUser(followName, userName);
    }

    @RequestMapping("update")
    public void updateUser(@RequestParam("usershow") String usershow,
                           @RequestParam("userimg") String userimg,
                           @RequestParam("username") String username,
                           @RequestParam("age") int age) {
        userService.update(usershow, userimg, username,age);
    }
}

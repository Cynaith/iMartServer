package com.xmut.ly.imart.Controller;

import com.xmut.ly.imart.Domain.User;
import com.xmut.ly.imart.Service.UserService;
import com.xmut.ly.imart.Utils.ResponseWrapper;
import com.xmut.ly.imart.Utils.ReturnCode;
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

    @RequestMapping("/login")
    public ResponseWrapper UserLogin(@RequestParam("userPhone") String userPhone,@RequestParam("userCode") int userCode){

        //判断验证码是否正确
        if (userService.checkCodeByUserphone(userPhone, userCode)){
            //是否注册过
            if (userService.haveUserByUserphone(userPhone)){
                return ResponseWrapper.markSuccess(userService.findUserByUserphone(userPhone));
            }
            //第一次登陆
            else {
                return ResponseWrapper.markCustom(true,"0001","注册",ReturnCode.NODATA);
            }
        }
        return ResponseWrapper.markError();

    }

    @RequestMapping("info")
    public ResponseWrapper UserInfo(@RequestParam("userName") String userName){
        return ResponseWrapper.markSuccess(userService.getUserInfo(userName));
    }

    @RequestMapping("follow")
    public ResponseWrapper getFollow(@RequestParam("userName") String userName){
        return ResponseWrapper.markSuccess(userService.getFollow(userName));
    }

    @RequestMapping("followed")
    public ResponseWrapper getFollowed(@RequestParam("userName") String userName){
        return ResponseWrapper.markSuccess(userService.getFollowed(userName));
    }

    @RequestMapping("myshow")
    //userName 主页人的名字
    //user 登陆账户
    public ResponseWrapper getShow(@RequestParam("userName") String userName,@RequestParam("loginName") String loginName){
        return ResponseWrapper.markSuccess(userService.getShow(userName,loginName));
    }

    @RequestMapping("article")
    public ResponseWrapper getArticle(@RequestParam("userName") String userName){
        return ResponseWrapper.markSuccess(userService.getArticle(userName));
    }

    @RequestMapping("myshow1")
    public ResponseWrapper getMyshow1(@RequestParam("userName") String userName){
        return ResponseWrapper.markSuccess(userService.getMyshow1(userName));
    }

}

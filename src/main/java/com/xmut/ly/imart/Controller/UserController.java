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


}

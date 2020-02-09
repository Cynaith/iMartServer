package com.xmut.ly.imart.Service.Impl;

import com.xmut.ly.imart.Domain.User;
import com.xmut.ly.imart.Mapper.UserMapping;
import com.xmut.ly.imart.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
}

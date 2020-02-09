package com.xmut.ly.imart.Service;

import com.xmut.ly.imart.Domain.User;


public interface UserService {
    boolean checkCodeByUserphone(String userPhone,int code);
    boolean haveUserByUserphone(String userPhone);
    User findUserByUserphone(String userPhone);

}

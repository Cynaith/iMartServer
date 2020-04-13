package com.xmut.ly.imart.Mapper;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

/**
 * @USER: lynn
 * @DATE: 2020/4/13
 **/

public class UpdateProvider {

    public String updateUser(String usershow,String userimg,String name,int age){
        return new SQL(){
            {
                UPDATE("user");
                if (usershow!=null){
                    SET("usershow=#{usershow}");
                }
                if (userimg!=null){
                    SET("imgurl=#{userimg}");
                }
                if (age>0&&age<100) SET("age=#{age}");
                WHERE("name=#{name}");
            }
        }.toString();
    }
}

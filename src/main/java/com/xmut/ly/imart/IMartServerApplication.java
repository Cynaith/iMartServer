package com.xmut.ly.imart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/xmut/ly/imart/Mapper")
public class IMartServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(IMartServerApplication.class, args);
    }

}

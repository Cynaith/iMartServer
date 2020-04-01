package com.xmut.ly.imart.ResultVo;

import lombok.Data;

/**
 * @USER: lynn
 * @DATE: 2020/4/1
 **/

@Data
public class VideoListVo {
    int id;
    String username;
    String title;
    String videourl;
    int support;
    String createtime;
    String userimg;
    boolean issupport;
}

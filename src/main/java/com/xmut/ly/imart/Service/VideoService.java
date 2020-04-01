package com.xmut.ly.imart.Service;

import com.xmut.ly.imart.ResultVo.VideoListVo;

import java.util.List;

/**
 * @USER: lynn
 * @DATE: 2020/4/1
 **/
public interface VideoService {
    public List<VideoListVo> getVideos(String username);
    public boolean addVideo(String username,String title,String videourl);
    public boolean support(int videoid,String username);
}

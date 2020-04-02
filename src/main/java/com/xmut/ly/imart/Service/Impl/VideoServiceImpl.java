package com.xmut.ly.imart.Service.Impl;

import com.xmut.ly.imart.Domain.Video;
import com.xmut.ly.imart.Mapper.UserMapping;
import com.xmut.ly.imart.Mapper.VideoMapping;
import com.xmut.ly.imart.ResultVo.VideoListVo;
import com.xmut.ly.imart.Service.VideoService;
import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @USER: lynn
 * @DATE: 2020/4/1
 **/
@Service
public class VideoServiceImpl implements VideoService {

@Autowired
    VideoMapping videoMapping;
@Autowired
    UserMapping userMapping;

    @Override
    public List<VideoListVo> getVideos(String username) {
        List<VideoListVo> videoListVos = videoMapping.getVideos();
        videoListVos.forEach(videoListVo -> {
            String id = userMapping.getIdByUsername(username)+"-"+videoListVo.getId();
            try{
                videoListVo.setIssupport(videoMapping.getSupportById(id) == 1);
            }catch (BindingException e){
                videoListVo.setIssupport(false);
            }

        });

        return videoListVos;
    }

    @Override
    public boolean addVideo(String username, String title, String videourl) {
        int userid = userMapping.getIdByUsername(username);
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");
        String time = dateFormat.format(date);
        return videoMapping.addVideo(userid,title,videourl,time);
    }

    @Override
    public boolean support(int videoid, String username) {
        int userid = userMapping.getIdByUsername(username);
        String userAddVideo = userid+"-"+videoid;
        videoMapping.support(userAddVideo,userid,videoid);
        return true;
    }
}

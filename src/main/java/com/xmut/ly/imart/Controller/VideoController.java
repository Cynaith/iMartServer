package com.xmut.ly.imart.Controller;

import com.xmut.ly.imart.Service.VideoService;
import com.xmut.ly.imart.Utils.ResponseWrapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @USER: lynn
 * @DATE: 2020/4/1
 **/

@RestController
@RequestMapping("video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @RequestMapping("getVideo")
    public ResponseWrapper getVideos(@RequestParam("username") String username) {
        return ResponseWrapper.markSuccess(videoService.getVideos(username));
    }

    @RequestMapping("addvideo")
    public ResponseWrapper addVideo(@RequestParam("username") String username,@RequestParam("title") String title,@RequestParam("videourl") String videourl){
        return ResponseWrapper.markSuccess(videoService.addVideo(username, title, videourl));
    }

    @RequestMapping("supportvideo")
    public ResponseWrapper supportVideo(@RequestParam("videoid") int videoid,@RequestParam("username") String username){
            return ResponseWrapper.markSuccess(videoService.support(videoid, username));
    }
}

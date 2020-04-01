package com.xmut.ly.imart.Mapper;

import com.xmut.ly.imart.Domain.Video;
import com.xmut.ly.imart.ResultVo.VideoListVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @USER: lynn
 * @DATE: 2020/4/1
 **/

@Repository
@Mapper
public interface VideoMapping {


    @Select("select v.id,u.name as username,v.title,v.videourl,v.support,v.createtime,u.imgurl as userimg " +
            "from video as v left join user as u on(v.userid = u.id) where v.status = 1")
    public List<VideoListVo> getVideos();

    @Insert("insert into video(userid,title,videourl,createtime) values(#{userid},#{title},#{videourl},#{createtime})")
    public boolean addVideo(@Param("userid") int userid,@Param("title") String title,@Param("videourl") String videourl,@Param("createtime") String time);

    @Select("replace into videomiddle(id,userid,videoid,support) values (#{id},#{userid},#{videoid},case when (select a.support from(select support from videomiddle where id = #{id}) as a)='1' then 0 else 1 end )")
    void support(@Param("id") String id,@Param("userid") int userid,@Param("videoid") int videoid);

    @Select("select support from videomiddle where id = #{id}")
    int getSupportById(@Param("id") String id);
}

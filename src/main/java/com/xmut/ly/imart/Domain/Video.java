package com.xmut.ly.imart.Domain;


public class Video {

  private long id;
  private long userid;
  private String title;
  private String videourl;
  private String support;
  private String createtime;
  private long status;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getVideourl() {
    return videourl;
  }

  public void setVideourl(String videourl) {
    this.videourl = videourl;
  }


  public String getSupport() {
    return support;
  }

  public void setSupport(String support) {
    this.support = support;
  }


  public String getCreatetime() {
    return createtime;
  }

  public void setCreatetime(String createtime) {
    this.createtime = createtime;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }

}

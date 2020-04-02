package com.xmut.ly.imart.Domain;


import lombok.Data;

@Data
public class Commentdetail {

  private int id;
  private long articleId;
  private long userid;
  private String content;
  private long imgId;
  private long replyTotal;
  private String createDate;
  private long support;
  private long status;




}

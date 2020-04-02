package com.xmut.ly.imart.Domain;


import lombok.Data;

@Data
public class Replydetail {

  private int id;
  private long commentId;
  private long userid;
  private String content;
  private String createDate;
  private long status;

}

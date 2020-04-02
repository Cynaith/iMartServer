package com.xmut.ly.imart.Domain;


import lombok.Data;

@Data
public class Article {

  private long id;
  private long userid;
  private String title;
  private String text;
  private int kind;
  private long support;
  private String img1;
  private String img2;
  private String img3;
  private String status;
  private double price;
  private String time;



}

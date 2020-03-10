package com.xmut.ly.imart.Service;

import com.xmut.ly.imart.ResultVo.SecondMainVo;

import java.util.List;

/**
 * @USER: lynn
 * @DATE: 2020/3/10
 **/
public interface ArticleService {
    List<SecondMainVo> getSecondMain(int kind);
}

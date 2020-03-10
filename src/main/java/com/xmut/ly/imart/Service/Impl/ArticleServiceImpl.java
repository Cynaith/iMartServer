package com.xmut.ly.imart.Service.Impl;

import com.xmut.ly.imart.Mapper.ArticleMapping;
import com.xmut.ly.imart.Mapper.UserMapping;
import com.xmut.ly.imart.ResultVo.SecondMainVo;
import com.xmut.ly.imart.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @USER: lynn
 * @DATE: 2020/3/10
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    UserMapping userMapping;
    @Autowired
    ArticleMapping articleMapping;

    @Override
    public List<SecondMainVo> getSecondMain(int kind) {

        List<SecondMainVo> secondMainVoList = articleMapping.getSecondMain(kind);
        return secondMainVoList;
    }
}

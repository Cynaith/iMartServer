package com.xmut.ly.imart.ResultVo;

import lombok.Data;

/**
 * @USER: lynn
 * @DATE: 2020/3/22
 **/

@Data
public class ActionStatusVo {
    boolean isSupport;
    boolean isCollection;
    int supportCount;
    int collectionCount;

}

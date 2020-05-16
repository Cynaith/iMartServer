package com.xmut.ly.imart.BaiduAPI.Bus;

import com.alibaba.fastjson.JSONObject;
import com.xmut.ly.imart.BaiduAPI.Diy.ResponsePlaceBean;
import org.springframework.web.client.RestTemplate;

/**
 * @USER: lynn
 * @DATE: 2020/3/24
 **/
public class WayWithBus {

    /**
     * 根据两点经纬度获取公交方式(全)
     * @param origin
     * @param destination
     * @return
     */
    public static ResponseBusBean getBusWay(ResponseBusBean.ResultBean.OriginBean.LocationBean origin,
                                              ResponseBusBean.ResultBean.OriginBean.LocationBean destination){
        RestTemplate restTemplate = new RestTemplate();
        String responsePlaceBean =
                restTemplate.
                        getForObject("http://api.map.baidu.com/direction/v2/transit?" +
                                        "origin="+origin.getLat()+","+origin.getLng()+
                                        "&destination="+destination.getLat()+","+destination.getLng()+"&ak=oTdmc4R89H66zYEm6V3XAYz9BiMfkmCI"
                                ,String.class);
        ResponseBusBean responseBusBean = JSONObject.parseObject(responsePlaceBean,ResponseBusBean.class);
        return responseBusBean;
    }



}

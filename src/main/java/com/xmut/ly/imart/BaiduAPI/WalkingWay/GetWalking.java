package com.xmut.ly.imart.BaiduAPI.WalkingWay;

import com.alibaba.fastjson.JSONObject;
import com.xmut.ly.imart.BaiduAPI.Address.ResponseLocationToCityBean;
import com.xmut.ly.imart.BaiduAPI.Address.ipToAddress;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @USER: lynn
 * @DATE: 2020/3/24
 **/
public class GetWalking {

    public static List<String> getWalkingFun(ResponseLocationToCityBean.ResultBean.LocationBean originLocation,
                                             ResponseLocationToCityBean.ResultBean.LocationBean destinationLocation){
        List<String> walkingWay = new ArrayList<>();
        if (!ipToAddress.getCitynameByLocationFun(originLocation).equals(ipToAddress.getCitynameByLocationFun(destinationLocation))){
            walkingWay.add("请选择同一个城市");
            return walkingWay;
        }
        RestTemplate restTemplate = new RestTemplate();
        String responsePlaceBean =
                restTemplate.
                        getForObject("https://restapi.amap.com/v3/direction/walking?origin="+originLocation.getLng()+","+originLocation.getLat()+"&destination="+destinationLocation.getLng()+","+destinationLocation.getLat()+"&key=107e73303d8e4a3593a3e7073bc0ef17"
                                         ,String.class);
        ResponseWalkingBean responseWalkingBean = JSONObject.parseObject(responsePlaceBean,ResponseWalkingBean.class);
        responseWalkingBean.getRoute().getPaths().get(0).getSteps().forEach(stepsBean -> {
            walkingWay.add(stepsBean.getInstruction());
        });
        return walkingWay;
    }
}

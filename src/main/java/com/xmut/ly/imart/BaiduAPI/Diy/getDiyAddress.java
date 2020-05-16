package com.xmut.ly.imart.BaiduAPI.Diy;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static com.xmut.ly.imart.BaiduAPI.Address.ipToAddress.getAddressByIpFun;


/**
 * @USER: lynn
 * @DATE: 2020/3/23
 **/
public class getDiyAddress {

    /**
     * 通过城市获取Diy地址
     * @param region
     * @return
     */
    public static ResponsePlaceBean getDiy(String region){
        RestTemplate restTemplate = new RestTemplate();
        String responsePlaceBean =
                restTemplate.
                        getForObject("http://api.map.baidu.com/place/v2/search?" +
                                        "query=DIY&output=json&ak=oTdmc4R89H66zYEm6V3XAYz9BiMfkmCI&" +
                                        "region="+region
                ,String.class);
        ResponsePlaceBean responsePlaceBean1 = JSONObject.parseObject(responsePlaceBean,ResponsePlaceBean.class);
        return responsePlaceBean1;
    }

    /**
     * 通过城市获取DIY的名字和经纬度
     * @param region
     * @return
     */
    public static Map<String,ResponsePlaceBean.ResultsBean.LocationBean> getDiyLocation(String region){
        Map<String,ResponsePlaceBean.ResultsBean.LocationBean> locationBeans = new HashMap<>();
        ResponsePlaceBean responsePlaceBean = getDiy(region);
        responsePlaceBean.getResults().forEach(resultsBean -> {
            locationBeans.put(resultsBean.getName(),resultsBean.getLocation());
        });
        return locationBeans;
    }

    public static void main(String[] args) {
        System.out.println(getDiy("牡丹江").toString());
        System.out.println(getDiyLocation("牡丹江").toString());
        System.out.println(getAddressByIpFun("111.41.207.71").toString());
    }


}

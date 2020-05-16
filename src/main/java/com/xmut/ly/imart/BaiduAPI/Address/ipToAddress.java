package com.xmut.ly.imart.BaiduAPI.Address;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.client.RestTemplate;

/**
 * @USER: lynn
 * @DATE: 2020/3/24
 **/
public class ipToAddress {

    /**
     * 通过IP获取地址
     * @param ip
     * @return
     */
    public static ResponseIpToAddressBean getAddressByIpFun(String ip){
        RestTemplate restTemplate = new RestTemplate();
        String responsePlaceBean =
                restTemplate.
                        getForObject("http://api.map.baidu.com/location/ip?ak=oTdmc4R89H66zYEm6V3XAYz9BiMfkmCI&coor=bd09ll&ip="+ip
                                ,String.class);
        ResponseIpToAddressBean responseIpToAddressBean = JSONObject.parseObject(responsePlaceBean,ResponseIpToAddressBean.class);
        return responseIpToAddressBean;
    }
    public static void main(String[] args) {
        System.out.println(getAddressByIpFun("111.41.207.71").toString());

    }

    /**
     * 获取 CityCode By Location
     * @param locationBean
     * @return
     */

    public static int getCityByLocationFun(ResponseLocationToCityBean.ResultBean.LocationBean locationBean){
        RestTemplate restTemplate = new RestTemplate();
        String responsePlaceBean =
                restTemplate.
                        getForObject("http://api.map.baidu.com/geocoder?location="+locationBean.getLat()+","+locationBean.getLng()+"&output=json&ak=oTdmc4R89H66zYEm6V3XAYz9BiMfkmCI"
                                ,String.class);
        ResponseLocationToCityBean responseLocationToCityBean = JSONObject.parseObject(responsePlaceBean,ResponseLocationToCityBean.class);
        return responseLocationToCityBean.getResult().getCityCode();
    }

    /**
     * 获取 CityName By Location
     * @param locationBean
     * @return
     */

    public static String getCitynameByLocationFun(ResponseLocationToCityBean.ResultBean.LocationBean locationBean){
        RestTemplate restTemplate = new RestTemplate();
        String responsePlaceBean =
                restTemplate.
                        getForObject("http://api.map.baidu.com/geocoder?location="+locationBean.getLat()+","+locationBean.getLng()+"&output=json&ak=oTdmc4R89H66zYEm6V3XAYz9BiMfkmCI"
                                ,String.class);
        System.out.println("本次app请求定位为"+responsePlaceBean);
        ResponseLocationToCityBean responseLocationToCityBean = JSONObject.parseObject(responsePlaceBean,ResponseLocationToCityBean.class);
        return responseLocationToCityBean.getResult().getAddressComponent().getCity();
    }

}

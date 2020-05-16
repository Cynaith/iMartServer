package com.xmut.ly.imart.GaodeApi.POI;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @USER: lynn
 * @DATE: 2020/3/25
 **/
public class GetDiyByCity {


    /**
     * 根据高德地图获取diy门店 （带图片）
     * @param region
     * @return
     */

    public static List<DiyInfo> getDiyPOI(String region){
        String key = "107e73303d8e4a3593a3e7073bc0ef17";
        RestTemplate restTemplate = new RestTemplate();
        String accessToken =
                restTemplate.getForObject("https://restapi.amap.com/v3/place/text?" +
                        "keywords=diy&city="+region+"&output=json&offset=100&page=1&key="+key+"&extensions=all",String.class);
        ResponseDiyInfo responseDiyInfo = JSONObject.parseObject(accessToken,ResponseDiyInfo.class);
        List<DiyInfo> diyInfoList = new ArrayList<>();
        responseDiyInfo.getPois().forEach(poisBean -> {
            if (poisBean.getName().contains("DIY")|| poisBean.getName().contains("Diy")||
                    poisBean.getName().contains("diy")||poisBean.getName().contains("创意工坊")||
                    poisBean.getName().contains("手工")||poisBean.getName().contains("创作")){
            }
            else {
                System.out.println(poisBean.getName());
                return;
            }

            DiyInfo diyInfo = new DiyInfo();
            diyInfo.setName(poisBean.getName());
            diyInfo.setAddress(poisBean.getCityname()+poisBean.getAdname()+" "+poisBean.getAddress());
            diyInfo.setLocation(poisBean.getLocation());
            String tel1 = poisBean.getTel();
            if (tel1.equals("[]")) return;
            if(tel1.contains(";")){
                StringBuffer phone = new StringBuffer(poisBean.getTel());
                String tel = phone.substring(0,phone.indexOf(";"));
                diyInfo.setTel(tel);
            }
            else diyInfo.setTel(poisBean.getTel());

            diyInfo.setId(poisBean.getId());
            try{
                diyInfo.setPhoto(poisBean.getPhotos().get(0).getUrl());
            }catch (IndexOutOfBoundsException e){
//                System.out.println(poisBean.getName()+"无图片");
//                diyInfo.setPhoto("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1585127677902&di=2dcdd4c0ef1d16829d91fef8856913e5&imgtype=0&src=http%3A%2F%2Fku.90sjimg.com%2Felement_origin_min_pic%2F01%2F47%2F26%2F835743e2ba5da85.jpg");
                //无图片 就不加
                return;
            }

            diyInfoList.add(diyInfo);
        });
        return diyInfoList;
    }
}

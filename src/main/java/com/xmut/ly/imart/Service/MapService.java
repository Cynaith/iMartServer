package com.xmut.ly.imart.Service;

import com.xmut.ly.imart.BaiduAPI.Diy.ResponsePlaceBean;
import com.xmut.ly.imart.GaodeApi.POI.DiyInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @USER: lynn
 * @DATE: 2020/3/23
 **/
public interface MapService {
    Map<String, ResponsePlaceBean.ResultsBean.LocationBean> getDiyByAddress(String address);
    List<DiyInfo> getDiyByAddressWithPhoto(String region);
    List<DiyInfo> getDiyByLocation(double lat,double lng);
    int getCityByLocation(double lng,double lat);
    String getCitynameByLocation(double lng,double lat);
    List<String> getWalkingWay(double originlng,double originlat,double destinationlng,double destinationlat);
}

package com.xmut.ly.imart.Service.Impl;

import com.xmut.ly.imart.BaiduAPI.Address.ResponseLocationToCityBean;
import com.xmut.ly.imart.BaiduAPI.Address.ipToAddress;
import com.xmut.ly.imart.BaiduAPI.Diy.ResponsePlaceBean;
import com.xmut.ly.imart.BaiduAPI.WalkingWay.GetWalking;
import com.xmut.ly.imart.GaodeApi.POI.DiyInfo;
import com.xmut.ly.imart.GaodeApi.POI.GetDiyByCity;
import com.xmut.ly.imart.Service.MapService;
import com.xmut.ly.imart.Utils.ResponseWrapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.xmut.ly.imart.BaiduAPI.Diy.getDiyAddress.getDiyLocation;

/**
 * @USER: lynn
 * @DATE: 2020/3/23
 **/
@Service
public class MapServiceImpl implements MapService {

    @Override
    public Map<String, ResponsePlaceBean.ResultsBean.LocationBean> getDiyByAddress(String address) {
        return getDiyLocation(address);
    }

    @Override
    public List<DiyInfo> getDiyByLocation(double lat, double lng) {
        ResponseLocationToCityBean.ResultBean.LocationBean locationBean = new ResponseLocationToCityBean.ResultBean.LocationBean();
        locationBean.setLat(lat);
        locationBean.setLng(lng);
        String region = ipToAddress.getCitynameByLocationFun(locationBean);
        return GetDiyByCity.getDiyPOI(region);
    }

    @Override
    public List<DiyInfo> getDiyByAddressWithPhoto(String region) {
        return GetDiyByCity.getDiyPOI(region);
    }

    @Override
    public int getCityByLocation(double lng,double lat) {
        ResponseLocationToCityBean.ResultBean.LocationBean locationBean = new ResponseLocationToCityBean.ResultBean.LocationBean();
        locationBean.setLng(lng);
        locationBean.setLat(lat);
        return ipToAddress.getCityByLocationFun(locationBean);
    }

    @Override
    public String getCitynameByLocation(double lng,double lat) {
        ResponseLocationToCityBean.ResultBean.LocationBean locationBean = new ResponseLocationToCityBean.ResultBean.LocationBean();
        locationBean.setLng(lng);
        locationBean.setLat(lat);
        return ipToAddress.getCitynameByLocationFun(locationBean);
    }

    @Override
    public List<String> getWalkingWay(double originlng, double originlat, double destinationlng, double destinationlat) {
        ResponseLocationToCityBean.ResultBean.LocationBean
                originLocation = new ResponseLocationToCityBean.ResultBean.LocationBean(),
                destinationLocation = new ResponseLocationToCityBean.ResultBean.LocationBean();
        destinationLocation.setLng(destinationlng);
        destinationLocation.setLat(destinationlat);
        originLocation.setLat(originlat);
        originLocation.setLng(originlng);
        return GetWalking.getWalkingFun(originLocation,destinationLocation);
    }
}

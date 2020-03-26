package com.xmut.ly.imart.Controller;

import com.xmut.ly.imart.BaiduAPI.Address.ResponseLocationToCityBean;
import com.xmut.ly.imart.BaiduAPI.Diy.ResponsePlaceBean;
import com.xmut.ly.imart.BaiduAPI.WalkingWay.ResponseWalkingBean;
import com.xmut.ly.imart.Service.MapService;
import com.xmut.ly.imart.Utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @USER: lynn
 * @DATE: 2020/3/23
 **/

@RestController
@RequestMapping("map")
public class MapController {

    @Autowired
    MapService mapService;

    /**
     * 获取Diy地址By地址
     *
     * @param address
     * @return
     */
    @RequestMapping("getDiyByAddress")
    public ResponseWrapper getDiyByAddress(String address) {
        return ResponseWrapper.markSuccess(mapService.getDiyByAddress(address));
    }

    @RequestMapping("getDiyByAddressWithPhoto")
    public ResponseWrapper getDiyByAddressWithPhoto(String address) {
        System.out.println("请求" + address);
        return ResponseWrapper.markSuccess(mapService.getDiyByAddressWithPhoto(address));
    }

    /**
     * 前端配合高德定位实现Diy的获取 ：已上线
     * @param lat
     * @param lng
     * @return
     */
    @RequestMapping("getDiyByLocation")
    public ResponseWrapper getDiyByLocation(@RequestParam("lat") double lat, @RequestParam("lng") double lng) {
        return ResponseWrapper.markSuccess(mapService.getDiyByLocation(lat,lng));
    }


    /**
     * 获取CityCode By lng(大),lat(小)
     *
     * @param lng
     * @param lat
     * @return
     */
    @RequestMapping("getCityByLocation")
    public ResponseWrapper getCityByLocation(@RequestParam("lng") double lng, @RequestParam("lat") double lat) {
        return ResponseWrapper.markSuccess(mapService.getCityByLocation(lng, lat));
    }


    /**
     * 获取CityName By Location
     *
     * @param lng
     * @param lat
     * @return
     */
    @RequestMapping("getCitynameByLocation")
    public ResponseWrapper getCitynameByLocation(@RequestParam("lng") double lng, @RequestParam("lat") double lat) {
        return ResponseWrapper.markSuccess(mapService.getCitynameByLocation(lng, lat));
    }

    /**
     * 根据起始点Location 获取步行路经
     *
     * @param originlng
     * @param originlat
     * @param destinationlng
     * @param destinationlat
     * @return
     */
    @RequestMapping("getWalkingWay")
    public ResponseWrapper getWalkingWay(@RequestParam("originlng") double originlng,
                                         @RequestParam("originlat") double originlat,
                                         @RequestParam("destinationlng") double destinationlng,
                                         @RequestParam("destinationlat") double destinationlat) {
        return ResponseWrapper.markSuccess(mapService.getWalkingWay(originlng, originlat, destinationlng, destinationlat).toString());

    }

}

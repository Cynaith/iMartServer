package com.xmut.ly.imart.BaiduAPI.Diy;

import java.io.Serializable;
import java.util.List;

/**
 * @USER: lynn
 * @DATE: 2020/3/23
 **/
public class ResponsePlaceBean implements Serializable {


    /**
     * status : 0
     * message : ok
     * results : [{"name":"中国工商银行ATM(北京大兴支行)","location":{"lat":39.732214,"lng":116.347146},"address":"黄村兴政街24号","province":"北京市","city":"北京市","area":"大兴区","street_id":"6ed3083ae94631c92b3a9f23","detail":1,"uid":"6ed3083ae94631c92b3a9f23"},{"name":"中国建设银行ATM(北京昌平回龙观支行)","location":{"lat":40.09387,"lng":116.350636},"address":"北京市昌平区龙回苑28号","province":"北京市","city":"北京市","area":"昌平区","street_id":"750368359a2e38af5e0d021b","detail":1,"uid":"750368359a2e38af5e0d021b"},{"name":"中国银行ATM(北京站)","location":{"lat":39.909493,"lng":116.432836},"address":"毛家湾胡同甲13号北京站F1层","province":"北京市","city":"北京市","area":"东城区","street_id":"a53295d23a68a92651e5c5ff","detail":1,"uid":"a53295d23a68a92651e5c5ff"},{"name":"招商银行ATM(拱辰大街店)","location":{"lat":39.738496,"lng":116.14899},"address":"良乡拱辰南大街金花商业大厦家乐福超市1层","province":"北京市","city":"北京市","area":"房山区","street_id":"ca0046bad95624d65d17c30f","detail":1,"uid":"ca0046bad95624d65d17c30f"},{"name":"招商银行ATM(龙湖北京大兴天街购物中心)","location":{"lat":39.691844,"lng":116.326719},"address":"北京市大兴区永兴路7号院1号楼北京龙湖大兴天街F1层","province":"北京市","city":"北京市","area":"大兴区","detail":1,"uid":"afcff8c5d34d542e7402698e"},{"name":"中国农业银行(北京北苑支行)","location":{"lat":40.03925,"lng":116.422294},"address":"北京市朝阳区红军营南路辅路","province":"北京市","city":"北京市","area":"朝阳区","detail":1,"uid":"55290d03c0947d03581093aa"},{"name":"中国工商银行ATM","location":{"lat":39.877569,"lng":116.464648},"address":"北京市朝阳区华威里27号长安大饭店1层","province":"北京市","city":"北京市","area":"朝阳区","detail":1,"uid":"cf17f8cdce96e12bca09f0e5"},{"name":"中国建设银行ATM(府学路店)","location":{"lat":40.226248,"lng":116.254461},"address":"北京市昌平区府学路18号中国石油大学北京分部","province":"北京市","city":"北京市","area":"昌平区","street_id":"bcaebff84dee6654c9e33c0d","detail":1,"uid":"bcaebff84dee6654c9e33c0d"},{"name":"华夏银行ATM(君天大厦)","location":{"lat":39.910953,"lng":116.521218},"address":"北京市朝阳区惠河南街","province":"北京市","city":"北京市","area":"朝阳区","street_id":"658e08bced9f2f05e60738ef","detail":1,"uid":"658e08bced9f2f05e60738ef"},{"name":"中国工商银行ATM(中粮万科FUNMIX半岛广场)","location":{"lat":39.759717,"lng":116.216979},"address":"北京市房山区广阳新路9号院1号楼中粮万科FUNMIX半岛广场F1","province":"北京市","city":"北京市","area":"房山区","detail":1,"uid":"c83b1522901be73400ff2dc1"}]
     */

    private int status;
    private String message;
    private List<ResultsBean> results;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ResponsePlaceBean{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", results=" + results +
                '}';
    }

    public static class ResultsBean {
        /**
         * name : 中国工商银行ATM(北京大兴支行)
         * location : {"lat":39.732214,"lng":116.347146}
         * address : 黄村兴政街24号
         * province : 北京市
         * city : 北京市
         * area : 大兴区
         * street_id : 6ed3083ae94631c92b3a9f23
         * detail : 1
         * uid : 6ed3083ae94631c92b3a9f23
         */

        private String name;
        private LocationBean location;
        private String address;
        private String province;
        private String city;
        private String area;
        private String street_id;
        private int detail;
        private String uid;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getStreet_id() {
            return street_id;
        }

        public void setStreet_id(String street_id) {
            this.street_id = street_id;
        }

        public int getDetail() {
            return detail;
        }

        public void setDetail(int detail) {
            this.detail = detail;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        @Override
        public String toString() {
            return "ResultsBean{" +
                    "name='" + name + '\'' +
                    ", location=" + location +
                    ", address='" + address + '\'' +
                    ", province='" + province + '\'' +
                    ", city='" + city + '\'' +
                    ", area='" + area + '\'' +
                    ", street_id='" + street_id + '\'' +
                    ", detail=" + detail +
                    ", uid='" + uid + '\'' +
                    '}';
        }

        public static class LocationBean {
            /**
             * lat : 39.732214
             * lng : 116.347146
             */

            private double lat;
            private double lng;

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            @Override
            public String toString() {
                return "LocationBean{" +
                        "lat=" + lat +
                        ", lng=" + lng +
                        '}';
            }
        }
    }
}

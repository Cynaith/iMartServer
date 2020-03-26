package com.xmut.ly.imart.BaiduAPI.Address;

/**
 * @USER: lynn
 * @DATE: 2020/3/24
 **/
public class ResponseIpToAddressBean {

    /**
     * address : CN|上海|上海|None|ALIBABA|0|0
     * content : {"address":"上海市","address_detail":{"city":"上海市","city_code":289,"district":"","province":"上海市","street":"","street_number":""},"point":{"x":"121.48789949","y":"31.24916171"}}
     * status : 0
     */

    private String address;
    private ContentBean content;
    private int status;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResponseIpToAddressBean{" +
                "address='" + address + '\'' +
                ", content=" + content +
                ", status=" + status +
                '}';
    }

    public static class ContentBean {
        /**
         * address : 上海市
         * address_detail : {"city":"上海市","city_code":289,"district":"","province":"上海市","street":"","street_number":""}
         * point : {"x":"121.48789949","y":"31.24916171"}
         */

        private String address;
        private AddressDetailBean address_detail;
        private PointBean point;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public AddressDetailBean getAddress_detail() {
            return address_detail;
        }

        public void setAddress_detail(AddressDetailBean address_detail) {
            this.address_detail = address_detail;
        }

        public PointBean getPoint() {
            return point;
        }

        public void setPoint(PointBean point) {
            this.point = point;
        }

        @Override
        public String toString() {
            return "ContentBean{" +
                    "address='" + address + '\'' +
                    ", address_detail=" + address_detail +
                    ", point=" + point +
                    '}';
        }

        public static class AddressDetailBean {
            /**
             * city : 上海市
             * city_code : 289
             * district :
             * province : 上海市
             * street :
             * street_number :
             */

            private String city;
            private int city_code;
            private String district;
            private String province;
            private String street;
            private String street_number;

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public int getCity_code() {
                return city_code;
            }

            public void setCity_code(int city_code) {
                this.city_code = city_code;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public String getStreet_number() {
                return street_number;
            }

            public void setStreet_number(String street_number) {
                this.street_number = street_number;
            }

            @Override
            public String toString() {
                return "AddressDetailBean{" +
                        "city='" + city + '\'' +
                        ", city_code=" + city_code +
                        ", district='" + district + '\'' +
                        ", province='" + province + '\'' +
                        ", street='" + street + '\'' +
                        ", street_number='" + street_number + '\'' +
                        '}';
            }
        }

        public static class PointBean {
            /**
             * x : 121.48789949
             * y : 31.24916171
             */

            private String x;
            private String y;

            public String getX() {
                return x;
            }

            public void setX(String x) {
                this.x = x;
            }

            public String getY() {
                return y;
            }

            public void setY(String y) {
                this.y = y;
            }

            @Override
            public String toString() {
                return "PointBean{" +
                        "x='" + x + '\'' +
                        ", y='" + y + '\'' +
                        '}';
            }
        }
    }
}

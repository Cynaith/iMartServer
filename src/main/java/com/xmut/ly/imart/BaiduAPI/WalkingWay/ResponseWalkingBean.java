package com.xmut.ly.imart.BaiduAPI.WalkingWay;

import java.util.List;

/**
 * @USER: lynn
 * @DATE: 2020/3/24
 **/
public class ResponseWalkingBean {

    /**
     * status : 1
     * info : ok
     * infocode : 10000
     * count : 1
     * route : {"origin":"116.434307,39.90909","destination":"116.434446,39.90816","paths":[{"distance":"216","duration":"173","steps":[{"instruction":"步行54米右转","orientation":[],"road":[],"distance":"54","duration":"43","polyline":"116.434323,39.909041;116.434965,39.909041","action":"右转","assistant_action":[],"walk_type":"0"},{"instruction":"沿建国门北大街向南步行85米直行","orientation":"南","road":"建国门北大街","distance":"85","duration":"68","polyline":"116.434965,39.909041;116.434931,39.908932;116.434887,39.908867;116.434887,39.908867;116.434818,39.908655;116.434826,39.908424;116.434883,39.908303","action":"直行","assistant_action":[],"walk_type":"0"},{"instruction":"沿建国门南大街向东南步行29米右转","orientation":"东南","road":"建国门南大街","distance":"29","duration":"23","polyline":"116.434883,39.908299;116.434974,39.908194;116.435009,39.908077","action":"右转","assistant_action":[],"walk_type":"0"},{"instruction":"步行48米到达目的地","orientation":[],"road":[],"distance":"48","duration":"38","polyline":"116.435009,39.908073;116.434449,39.908073","action":[],"assistant_action":"到达目的地","walk_type":"0"}]}]}
     */

    private String status;
    private String info;
    private String infocode;
    private String count;
    private RouteBean route;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfocode() {
        return infocode;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public RouteBean getRoute() {
        return route;
    }

    public void setRoute(RouteBean route) {
        this.route = route;
    }

    public static class RouteBean {
        /**
         * origin : 116.434307,39.90909
         * destination : 116.434446,39.90816
         * paths : [{"distance":"216","duration":"173","steps":[{"instruction":"步行54米右转","orientation":[],"road":[],"distance":"54","duration":"43","polyline":"116.434323,39.909041;116.434965,39.909041","action":"右转","assistant_action":[],"walk_type":"0"},{"instruction":"沿建国门北大街向南步行85米直行","orientation":"南","road":"建国门北大街","distance":"85","duration":"68","polyline":"116.434965,39.909041;116.434931,39.908932;116.434887,39.908867;116.434887,39.908867;116.434818,39.908655;116.434826,39.908424;116.434883,39.908303","action":"直行","assistant_action":[],"walk_type":"0"},{"instruction":"沿建国门南大街向东南步行29米右转","orientation":"东南","road":"建国门南大街","distance":"29","duration":"23","polyline":"116.434883,39.908299;116.434974,39.908194;116.435009,39.908077","action":"右转","assistant_action":[],"walk_type":"0"},{"instruction":"步行48米到达目的地","orientation":[],"road":[],"distance":"48","duration":"38","polyline":"116.435009,39.908073;116.434449,39.908073","action":[],"assistant_action":"到达目的地","walk_type":"0"}]}]
         */

        private String origin;
        private String destination;
        private List<PathsBean> paths;

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public List<PathsBean> getPaths() {
            return paths;
        }

        public void setPaths(List<PathsBean> paths) {
            this.paths = paths;
        }

        public static class PathsBean {
            /**
             * distance : 216
             * duration : 173
             * steps : [{"instruction":"步行54米右转","orientation":[],"road":[],"distance":"54","duration":"43","polyline":"116.434323,39.909041;116.434965,39.909041","action":"右转","assistant_action":[],"walk_type":"0"},{"instruction":"沿建国门北大街向南步行85米直行","orientation":"南","road":"建国门北大街","distance":"85","duration":"68","polyline":"116.434965,39.909041;116.434931,39.908932;116.434887,39.908867;116.434887,39.908867;116.434818,39.908655;116.434826,39.908424;116.434883,39.908303","action":"直行","assistant_action":[],"walk_type":"0"},{"instruction":"沿建国门南大街向东南步行29米右转","orientation":"东南","road":"建国门南大街","distance":"29","duration":"23","polyline":"116.434883,39.908299;116.434974,39.908194;116.435009,39.908077","action":"右转","assistant_action":[],"walk_type":"0"},{"instruction":"步行48米到达目的地","orientation":[],"road":[],"distance":"48","duration":"38","polyline":"116.435009,39.908073;116.434449,39.908073","action":[],"assistant_action":"到达目的地","walk_type":"0"}]
             */

            private String distance;
            private String duration;
            private List<StepsBean> steps;

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public List<StepsBean> getSteps() {
                return steps;
            }

            public void setSteps(List<StepsBean> steps) {
                this.steps = steps;
            }

            public static class StepsBean {
                /**
                 * instruction : 步行54米右转
                 * orientation : []
                 * road : []
                 * distance : 54
                 * duration : 43
                 * polyline : 116.434323,39.909041;116.434965,39.909041
                 * action : 右转
                 * assistant_action : []
                 * walk_type : 0
                 */

                private String instruction;
                private String distance;
                private String duration;
                private String polyline;
                private String action;
                private String walk_type;
                private List<?> orientation;
                private List<?> road;
                private List<?> assistant_action;

                public String getInstruction() {
                    return instruction;
                }

                public void setInstruction(String instruction) {
                    this.instruction = instruction;
                }

                public String getDistance() {
                    return distance;
                }

                public void setDistance(String distance) {
                    this.distance = distance;
                }

                public String getDuration() {
                    return duration;
                }

                public void setDuration(String duration) {
                    this.duration = duration;
                }

                public String getPolyline() {
                    return polyline;
                }

                public void setPolyline(String polyline) {
                    this.polyline = polyline;
                }

                public String getAction() {
                    return action;
                }

                public void setAction(String action) {
                    this.action = action;
                }

                public String getWalk_type() {
                    return walk_type;
                }

                public void setWalk_type(String walk_type) {
                    this.walk_type = walk_type;
                }

                public List<?> getOrientation() {
                    return orientation;
                }

                public void setOrientation(List<?> orientation) {
                    this.orientation = orientation;
                }

                public List<?> getRoad() {
                    return road;
                }

                public void setRoad(List<?> road) {
                    this.road = road;
                }

                public List<?> getAssistant_action() {
                    return assistant_action;
                }

                public void setAssistant_action(List<?> assistant_action) {
                    this.assistant_action = assistant_action;
                }
            }
        }
    }
}

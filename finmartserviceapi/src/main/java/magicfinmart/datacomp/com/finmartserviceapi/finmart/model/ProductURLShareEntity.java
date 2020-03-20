package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

public  class ProductURLShareEntity {
        /**
         * url :  https://www.policyboss.com/two-wheeler-insurance?utm_source=agent_campaign&utm_medium=813_813&utm_campaign=Insure_Your_Ride_Eng
         * msg : Hi Customer, Please visit through my url to Bike Insurance
         */

        private String url;
        private String msg;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
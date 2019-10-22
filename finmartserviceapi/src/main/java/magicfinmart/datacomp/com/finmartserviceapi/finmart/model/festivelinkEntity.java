package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

public  class festivelinkEntity {

        /**
         * campaignid : 1
         * name : test name
         * imagelink : http://api.magicfinmart.com/InsurerImages/car_44.png
         * title : test
         * description : test desc
         * shorturl : mgfm.in/1i1yaw
         * url : http://erp.rupeeboss.com?BrokerId=36886&FBAId=53686&client_source=Finmart&lead_id=
         * baseurl : http://erp.rupeeboss.com
         */

        private int campaignid;
        private String name;
        private String imagelink;
        private String title;
        private String description;
        private String shorturl;
        private String url;
        private String baseurl;

        public int getCampaignid() {
            return campaignid;
        }

        public void setCampaignid(int campaignid) {
            this.campaignid = campaignid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImagelink() {
            return imagelink;
        }

        public void setImagelink(String imagelink) {
            this.imagelink = imagelink;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getShorturl() {
            return shorturl;
        }

        public void setShorturl(String shorturl) {
            this.shorturl = shorturl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getBaseurl() {
            return baseurl;
        }

        public void setBaseurl(String baseurl) {
            this.baseurl = baseurl;
        }


    }
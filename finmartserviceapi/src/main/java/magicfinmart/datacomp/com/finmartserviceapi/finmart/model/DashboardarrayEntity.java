package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import io.realm.RealmObject;

public  class DashboardarrayEntity extends RealmObject {
        /**
         * ProdId : 25
         * url : https://qa.policyboss.com/WealthPlus/wealthplus.html?ss_id=14265&fba_id=37292&v=20200104&sub_fba_id=0
         */

        private String ProdId;
        private String url;

        public String getProdId() {
            return ProdId;
        }

        public void setProdId(String ProdId) {
            this.ProdId = ProdId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
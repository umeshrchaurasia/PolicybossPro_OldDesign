package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

public  class LeadDispositionEntity {
        /**
         * id : 1
         * disposition : Not Reachable
         * createddate : 2019-05-16T16:18:53.000Z
         */

        private int id;
        private String disposition;
        private String createddate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDisposition() {
            return disposition;
        }

        public void setDisposition(String disposition) {
            this.disposition = disposition;
        }

        public String getCreateddate() {
            return createddate;
        }

        public void setCreateddate(String createddate) {
            this.createddate = createddate;
        }
    }
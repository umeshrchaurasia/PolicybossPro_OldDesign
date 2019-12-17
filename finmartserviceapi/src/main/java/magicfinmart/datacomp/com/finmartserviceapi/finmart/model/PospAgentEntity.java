package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

public  class PospAgentEntity  {
        /**
         * Name : Test Posp
         * EmailId : tpnow@gmail.com
         * SSID : 2566
         * FBAID : 3037
         * UserType : POSP
         * ERPID : 
         */

        private String Name;
        private String EmailId;
        private String SSID;
        private String FBAID;
        private String UserType;
        private String ERPID;

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getEmailId() {
            return EmailId;
        }

        public void setEmailId(String EmailId) {
            this.EmailId = EmailId;
        }

        public String getSSID() {
            return SSID;
        }

        public void setSSID(String SSID) {
            this.SSID = SSID;
        }

        public String getFBAID() {
            return FBAID;
        }

        public void setFBAID(String FBAID) {
            this.FBAID = FBAID;
        }

        public String getUserType() {
            return UserType;
        }

        public void setUserType(String UserType) {
            this.UserType = UserType;
        }

        public String getERPID() {
            return ERPID;
        }

        public void setERPID(String ERPID) {
            this.ERPID = ERPID;
        }
    }
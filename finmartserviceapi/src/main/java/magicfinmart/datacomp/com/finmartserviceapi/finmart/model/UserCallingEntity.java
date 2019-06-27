package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

public  class UserCallingEntity {
        /**
         * MobileNo : 9769588193
         * EmailId : srinivas@policyboss.com
         * EmployeeName : H.R.Srinivas
         * Designation : Process_Head
         */

        private String MobileNo;
        private String EmailId;
        private String EmployeeName;
        private String Designation;

        public String getMobileNo() {
            return MobileNo;
        }

        public void setMobileNo(String MobileNo) {
            this.MobileNo = MobileNo;
        }

        public String getEmailId() {
            return EmailId;
        }

        public void setEmailId(String EmailId) {
            this.EmailId = EmailId;
        }

        public String getEmployeeName() {
            return EmployeeName;
        }

        public void setEmployeeName(String EmployeeName) {
            this.EmployeeName = EmployeeName;
        }

        public String getDesignation() {
            return Designation;
        }

        public void setDesignation(String Designation) {
            this.Designation = Designation;
        }
    }
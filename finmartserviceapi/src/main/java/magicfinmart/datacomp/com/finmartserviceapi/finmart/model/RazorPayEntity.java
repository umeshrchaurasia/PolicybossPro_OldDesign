package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

public  class RazorPayEntity {
        /**
         * SavedStatus : 0
         * FName : Vinit Chindarkar
         * State : MAHARASHTRA
         * CustId : 999
         * Pancard : null
         * InvNo : RB2019000017
         * PayDate : 2020-04-14T11:13:19.000Z
         * FBAID : 62549
         * address : 
         * Email : vinitchindarkar7@gmail.com
         */

        private int SavedStatus;
        private String FName;
        private String State;
        private int CustId;
        private Object Pancard;
        private String InvNo;
        private String PayDate;
        private int FBAID;
        private String address;
        private String Email;

        private String respmsg;

        public int getSavedStatus() {
            return SavedStatus;
        }

        public void setSavedStatus(int SavedStatus) {
            this.SavedStatus = SavedStatus;
        }

        public String getFName() {
            return FName;
        }

        public void setFName(String FName) {
            this.FName = FName;
        }

        public String getState() {
            return State;
        }

        public void setState(String State) {
            this.State = State;
        }

        public int getCustId() {
            return CustId;
        }

        public void setCustId(int CustId) {
            this.CustId = CustId;
        }

        public Object getPancard() {
            return Pancard;
        }

        public void setPancard(Object Pancard) {
            this.Pancard = Pancard;
        }

        public String getInvNo() {
            return InvNo;
        }

        public void setInvNo(String InvNo) {
            this.InvNo = InvNo;
        }

        public String getPayDate() {
            return PayDate;
        }

        public void setPayDate(String PayDate) {
            this.PayDate = PayDate;
        }

        public int getFBAID() {
            return FBAID;
        }

        public void setFBAID(int FBAID) {
            this.FBAID = FBAID;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            this.Email = Email;
        }

        public String getRespmsg() {
            return respmsg;
        }

        public void setRespmsg(String respmsg) {
            this.respmsg = respmsg;
        }

}
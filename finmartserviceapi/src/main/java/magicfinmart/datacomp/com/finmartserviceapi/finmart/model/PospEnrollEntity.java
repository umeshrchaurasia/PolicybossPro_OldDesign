package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import com.google.gson.annotations.SerializedName;

public  class PospEnrollEntity {
        /**
         * ErrorCode : null
         * ErrorDescription : null
         * MSG : Record found
         * MSGID : null
         * Status : 1
         * PaymRefeID : 18223172304767056
         * PaymentURL : https://goo.gl/pYNJLN
         */

        private Object ErrorCode;
        private Object ErrorDescription;
        private String MSG;
        private Object MSGID;
        @SerializedName("Status")
        private String StatusX;
        private long PaymRefeID;
        private String PaymentURL;

        public Object getErrorCode() {
            return ErrorCode;
        }

        public void setErrorCode(Object ErrorCode) {
            this.ErrorCode = ErrorCode;
        }

        public Object getErrorDescription() {
            return ErrorDescription;
        }

        public void setErrorDescription(Object ErrorDescription) {
            this.ErrorDescription = ErrorDescription;
        }

        public String getMSG() {
            return MSG;
        }

        public void setMSG(String MSG) {
            this.MSG = MSG;
        }

        public Object getMSGID() {
            return MSGID;
        }

        public void setMSGID(Object MSGID) {
            this.MSGID = MSGID;
        }

        public String getStatusX() {
            return StatusX;
        }

        public void setStatusX(String StatusX) {
            this.StatusX = StatusX;
        }

        public long getPaymRefeID() {
            return PaymRefeID;
        }

        public void setPaymRefeID(long PaymRefeID) {
            this.PaymRefeID = PaymRefeID;
        }

        public String getPaymentURL() {
            return PaymentURL;
        }

        public void setPaymentURL(String PaymentURL) {
            this.PaymentURL = PaymentURL;
        }
    }
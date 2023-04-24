package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

public  class SmsTemplateEntity {
        /**
         * fba_sms_id : 1
         * templete : A1
         */

        private int fba_sms_id;
        private String templete;

        public int getFba_sms_id() {
            return fba_sms_id;
        }

        public void setFba_sms_id(int fba_sms_id) {
            this.fba_sms_id = fba_sms_id;
        }

        public String getTemplete() {
            return templete;
        }

        public void setTemplete(String templete) {
            this.templete = templete;
        }
    }
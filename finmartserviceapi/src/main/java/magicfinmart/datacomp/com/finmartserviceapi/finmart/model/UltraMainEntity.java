package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.UltralakshaRequestEntity;

public  class UltraMainEntity {

        private List<UltralakshaRequestEntity> quote;
        private List<UltralakshaRequestEntity> application;

        public List<UltralakshaRequestEntity> getQuote() {
            return quote;
        }

        public void setQuote(List<UltralakshaRequestEntity> quote) {
            this.quote = quote;
        }

        public List<UltralakshaRequestEntity> getApplication() {
            return application;
        }

        public void setApplication(List<UltralakshaRequestEntity> application) {
            this.application = application;
        }


    }
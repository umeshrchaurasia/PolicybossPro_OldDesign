package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

public class OfflineSavedEntity {
        /**
         * TransId : 7
         * RequestId : 4
         * SavedStatus : 0
         */

        private int TransId;
        private int RequestId;
        private int SavedStatus;

        public int getTransId() {
            return TransId;
        }

        public void setTransId(int TransId) {
            this.TransId = TransId;
        }

        public int getRequestId() {
            return RequestId;
        }

        public void setRequestId(int RequestId) {
            this.RequestId = RequestId;
        }

        public int getSavedStatus() {
            return SavedStatus;
        }

        public void setSavedStatus(int SavedStatus) {
            this.SavedStatus = SavedStatus;
        }
    }
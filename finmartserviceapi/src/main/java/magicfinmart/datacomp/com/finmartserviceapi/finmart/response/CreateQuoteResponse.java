package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;

/**
 * Created by Rajeev Ranjan on 05/11/2018.
 */

public class CreateQuoteResponse extends APIResponse {


    private List<MasterDataBean> MasterData;

    public List<MasterDataBean> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<MasterDataBean> MasterData) {
        this.MasterData = MasterData;
    }

    public static class MasterDataBean {
        /**
         * reqid : 83
         * Result : Success
         * Message : Saved successfully!
         * SavedStatus : 0
         * docstatus : [{"Document_name":"Attach Last year policy copy","document_path":"http://qa.mgfm.in/OfflineDoc/83/1544612637986.jpg"},{"Document_name":"RC copy","document_path":"http://qa.mgfm.in/OfflineDoc/83/1544612660118.jpg"},{"Document_name":"Other 1","document_path":"http://qa.mgfm.in/OfflineDoc/83/1544612689058.jpg"},{"Document_name":"Other 2","document_path":"http://qa.mgfm.in/OfflineDoc/83/1544612711113.jpg"}]
         */

        private int reqid;
        private String Result;
        private String Message;
        private int SavedStatus;
        /**
         * Document_name : Attach Last year policy copy
         * document_path : http://qa.mgfm.in/OfflineDoc/83/1544612637986.jpg
         */

        private List<DocstatusBean> docstatus;

        public int getReqid() {
            return reqid;
        }

        public void setReqid(int reqid) {
            this.reqid = reqid;
        }

        public String getResult() {
            return Result;
        }

        public void setResult(String Result) {
            this.Result = Result;
        }

        public String getMessage() {
            return Message;
        }

        public void setMessage(String Message) {
            this.Message = Message;
        }

        public int getSavedStatus() {
            return SavedStatus;
        }

        public void setSavedStatus(int SavedStatus) {
            this.SavedStatus = SavedStatus;
        }

        public List<DocstatusBean> getDocstatus() {
            return docstatus;
        }

        public void setDocstatus(List<DocstatusBean> docstatus) {
            this.docstatus = docstatus;
        }

        public static class DocstatusBean {
            private String Document_name;
            private String document_path;

            public String getDocument_name() {
                return Document_name;
            }

            public void setDocument_name(String Document_name) {
                this.Document_name = Document_name;
            }

            public String getDocument_path() {
                return document_path;
            }

            public void setDocument_path(String document_path) {
                this.document_path = document_path;
            }
        }
        /**
         * reqid : 8
         * Result : Success
         * Message : Saved successfully!
         * SavedStatus : 0
         */

//        private int reqid;
//        private String Result;
//        @SerializedName("Message")
//        private String MessageX;
//        private int SavedStatus;
//
//
//
//        public int getReqid() {
//            return reqid;
//        }
//
//        public void setReqid(int reqid) {
//            this.reqid = reqid;
//        }
//
//        public String getResult() {
//            return Result;
//        }
//
//        public void setResult(String Result) {
//            this.Result = Result;
//        }
//
//        public String getMessageX() {
//            return MessageX;
//        }
//
//        public void setMessageX(String MessageX) {
//            this.MessageX = MessageX;
//        }
//
//        public int getSavedStatus() {
//            return SavedStatus;
//        }
//
//        public void setSavedStatus(int SavedStatus) {
//            this.SavedStatus = SavedStatus;
//        }


    }
}

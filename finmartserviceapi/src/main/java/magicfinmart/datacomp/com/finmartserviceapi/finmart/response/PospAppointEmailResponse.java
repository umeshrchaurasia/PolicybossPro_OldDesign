package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;

/**
 * Created by Rajeev Ranjan on 21/01/2019.
 */

public class PospAppointEmailResponse  extends APIResponse{


    private List<MasterDataBean> MasterData;

    public List<MasterDataBean> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<MasterDataBean> MasterData) {
        this.MasterData = MasterData;
    }

    public static class MasterDataBean {
        /**
         * id : 10
         * Message : Save successfully.
         */

        private int id;
        @SerializedName("Message")
        private String MessageX;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMessageX() {
            return MessageX;
        }

        public void setMessageX(String MessageX) {
            this.MessageX = MessageX;
        }
    }
}

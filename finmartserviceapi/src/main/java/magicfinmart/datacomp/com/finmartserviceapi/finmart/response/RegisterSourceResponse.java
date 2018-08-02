package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;

/**
 * Created by Nilesh Birhade on 02-08-2018.
 */

public class RegisterSourceResponse extends APIResponse {

    private List<SourceEntity> MasterData;

    public List<SourceEntity> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<SourceEntity> MasterData) {
        this.MasterData = MasterData;
    }

    public static class SourceEntity {
        /**
         * id : 1
         * Source_name : Fin-Mart
         */

        private int id;
        private String Source_name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSource_name() {
            return Source_name;
        }

        public void setSource_name(String Source_name) {
            this.Source_name = Source_name;
        }
    }
}

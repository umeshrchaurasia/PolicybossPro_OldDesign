package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RaiseDocWebEntity;

/**
 * Created by Rajeev Ranjan on 05/03/2020.
 */
public class CommonWebDocResponse extends APIResponse {
    /**
     * MasterData : {"file_name":"image_ic","file_path":"/var/www/Production/HorizonAPI/SourceCode/tmp/ticketing/1583399294722.png"}
     */

    private RaiseDocWebEntity MasterData;

    public RaiseDocWebEntity getMasterData() {
        return MasterData;
    }

    public void setMasterData(RaiseDocWebEntity MasterData) {
        this.MasterData = MasterData;
    }


    /**
     * MasterData : {"file_name":"image_ic","file_path":"/var/www/Production/HorizonAPI/SourceCode/tmp/ticketing/1583397445822.png"}
     */

//    private RaiseDocWebEntity MasterData;
//
//    public RaiseDocWebEntity getMasterData() {
//        return MasterData;
//    }
//
//    public void setMasterData(RaiseDocWebEntity MasterData) {
//        this.MasterData = MasterData;
//    }




    /**
     * MasterData : /var/www/Production/HorizonAPI/SourceCode/tmp/ticketing/1583391059828.png
     */


}

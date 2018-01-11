package magicfinmart.datacomp.com.finmartserviceapi.master.response;


import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.master.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.master.model.MasterDataEntity;

/**
 * Created by Nilesh Birhade on 29-11-2017.
 */

public class CarMasterResponse extends APIResponse {


    /**
     * DataCount : 3002
     * MasterData : [{"Cubic_Capacity":"5935","ExShowroomPrice":"19000000","Fuel_ID":1,"Make_ID":1,"Make_Name":"Aston Martin","Model_ID":1,"Model_ID1":1,"Model_Name":"DB9","Seating_Capacity":"2","Variant_ID":1,"Variant_Name":"Coupe"},{"Cubic_Capacity":"5935","ExShowroomPrice":"20500000","Fuel_ID":1,"Make_ID":1,"Make_Name":"Aston Martin","Model_ID":1,"Model_ID1":1,"Model_Name":"DB9","Seating_Capacity":"2","Variant_ID":2,"Variant_Name":"Volante"}]
     */

    private int DataCount;
    private List<MasterDataEntity> MasterData;

    public int getDataCount() {
        return DataCount;
    }

    public void setDataCount(int DataCount) {
        this.DataCount = DataCount;
    }

    public List<MasterDataEntity> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<MasterDataEntity> MasterData) {
        this.MasterData = MasterData;
    }

}

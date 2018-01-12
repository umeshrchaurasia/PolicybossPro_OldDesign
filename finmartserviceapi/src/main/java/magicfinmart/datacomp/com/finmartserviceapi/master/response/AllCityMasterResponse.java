package magicfinmart.datacomp.com.finmartserviceapi.master.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.master.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.master.model.VehicleMasterEntity;


public class AllCityMasterResponse extends APIResponse {

    private List<VehicleMasterEntity> lstvehicle;

    public List<VehicleMasterEntity> getListvehicle() {
        return lstvehicle;
    }

    public void setListvehicle(List<VehicleMasterEntity> lstvehicle) {
        this.lstvehicle = lstvehicle;
    }


}
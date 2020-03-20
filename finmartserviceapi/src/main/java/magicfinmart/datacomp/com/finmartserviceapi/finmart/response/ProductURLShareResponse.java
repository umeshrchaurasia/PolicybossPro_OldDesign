package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ProductURLShareEntity;

public class ProductURLShareResponse extends APIResponse {


    /**
     * MasterData : {"url":" https://www.policyboss.com/two-wheeler-insurance?utm_source=agent_campaign&utm_medium=813_813&utm_campaign=Insure_Your_Ride_Eng","msg":"Hi Customer, Please visit through my url to Bike Insurance"}
     */

    private ProductURLShareEntity MasterData;

    public ProductURLShareEntity getMasterData() {
        return MasterData;
    }

    public void setMasterData(ProductURLShareEntity MasterData) {
        this.MasterData = MasterData;
    }


}

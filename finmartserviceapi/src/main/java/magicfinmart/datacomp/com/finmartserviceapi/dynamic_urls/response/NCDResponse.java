package magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.model.NDCMasterEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;

/**
 * Created by Nilesh Birhade on 11-12-2018.
 */

public class NCDResponse extends APIResponse {

    /**
     * MasterData : {"id":2,"camapignname":"NCD of Edelweiss finance Ltd.","campaigndescription":"","insurancecompanyname":"Edelweiss finance Ltd","bannerimage":"http://bo.mgfm.in/ncd//2/ncdedelweiss.jpeg","guid":"dfd59151-fd0c-11e8-bdfa-0273323e097a","document":[{"id":2,"ncdcampaignid":2,"documentpath":"http://bo.mgfm.in/ncd//2/ncdedelweissbrokragestructure.pdf","documentname":"Brokerage Structure","documenttype":"pdf"},{"id":3,"ncdcampaignid":2,"documentpath":"http://bo.mgfm.in/ncd//2/ncdedelweissproductnote.pdf","documentname":"Product note","documenttype":"pdf"},{"id":4,"ncdcampaignid":2,"documentpath":"http://bo.mgfm.in/ncd//2/ncdedelweissprocessnote.pdf","documentname":"Process note","documenttype":"pdf"},{"id":5,"ncdcampaignid":2,"documentpath":"http://bo.mgfm.in/ncd//2/ncdedelweissprefilledform.pdf","documentname":"Pre-filled form","documenttype":"pdf"},{"id":6,"ncdcampaignid":2,"documentpath":"http://180.179.141.99/FormPrinting/FrmDirectPrinting.aspx?details=vtxpKyclyfS6yTyLXjwvbw==&&Reference=2ylelx+gCU+ocwOm2EiTYA==&&Flag=K1byKZlOeCylulT1F2Yh/g==","documentname":"Download application form","documenttype":"html"}]}
     */

    private NDCMasterEntity MasterData;

    public NDCMasterEntity getMasterData() {
        return MasterData;
    }

    public void setMasterData(NDCMasterEntity MasterData) {
        this.MasterData = MasterData;
    }


}

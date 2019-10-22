package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;


import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.festivelinkEntity;


public class festivelinkResponse extends APIResponse {


    /**
     * Message : Success
     * Status : success
     * StatusNo : 0
     * MasterData : [{"campaignid":1,"name":"test name","imagelink":"http://api.magicfinmart.com/InsurerImages/car_44.png","title":"test","description":"test desc","shorturl":"mgfm.in/1i1yaw","url":"http://erp.rupeeboss.com?BrokerId=36886&FBAId=53686&client_source=Finmart&lead_id=","baseurl":"http://erp.rupeeboss.com"},{"campaignid":2,"name":"diwali campaign","imagelink":"https://rupeeboss.com/emailer/Diwali/emailer.html","title":"diwali","description":"desc","shorturl":"mgfm.in/mg5tw0","url":"https://rupeeboss.com/emailer/Diwali/emailer1.php?BrokerId=36886&FBAId=53686&client_source=Finmart&lead_id=","baseurl":"https://rupeeboss.com/emailer/Diwali/emailer1.php"}]
     */

    private String Message;
    private String Status;
    private int StatusNo;
    private List<festivelinkEntity> MasterData;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getStatusNo() {
        return StatusNo;
    }

    public void setStatusNo(int StatusNo) {
        this.StatusNo = StatusNo;
    }

    public List<festivelinkEntity> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<festivelinkEntity> MasterData) {
        this.MasterData = MasterData;
    }


}

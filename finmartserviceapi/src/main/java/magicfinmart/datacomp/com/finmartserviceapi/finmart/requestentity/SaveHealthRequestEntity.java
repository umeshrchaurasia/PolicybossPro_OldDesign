package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MemberListEntity;

/**
 * Created by Rajeev Ranjan on 17/01/2019.
 */

public class SaveHealthRequestEntity {


    /**
     * HealthRequest : {"CityID":0,"ContactEmail":"","ContactMobile":"8087571995","ContactName":"Test For Development","DeductibleAmount":0,"ExistingCustomerReferenceID":0,"FBAID":0,"HealthRequestId":0,"HealthType":"Health","MaritalStatusID":1,"MemberList":[{"Age":50,"HealthMemberListId":null,"HealthRequestId":null,"MemberDOB":"20-06-1968","MemberDOBTemp":null,"MemberGender":null,"MemberNumber":null,"MemberRelationShip":null,"MemberType":"Adult","MemberTypeID":null}],"PBStatus":null,"PolicyFor":"Self","PolicyTermYear":1,"ProductID":2,"Quote_Application_Status":null,"SessionID":0,"SourceType":"APP","StatusPercent":0,"SumInsured":"100000","SupportsAgentID":2,"agent_source":null,"conversion_date":null,"created_date":null,"crn":null,"isActive":0,"pincode":400051,"selectedPrevInsID":0,"updated_date":null}
     * HealthRequestId : 0
     * agent_source : App
     * crn : null
     * fba_id : 1976
     */

    private HealthRequestEntity HealthRequest;
    private int HealthRequestId;
    private String agent_source;
    private String crn;
    private int fba_id;

    public HealthRequestEntity getHealthRequest() {
        return HealthRequest;
    }

    public void setHealthRequest(HealthRequestEntity HealthRequest) {
        this.HealthRequest = HealthRequest;
    }

    public int getHealthRequestId() {
        return HealthRequestId;
    }

    public void setHealthRequestId(int HealthRequestId) {
        this.HealthRequestId = HealthRequestId;
    }

    public String getAgent_source() {
        return agent_source;
    }

    public void setAgent_source(String agent_source) {
        this.agent_source = agent_source;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public int getFba_id() {
        return fba_id;
    }

    public void setFba_id(int fba_id) {
        this.fba_id = fba_id;
    }


}

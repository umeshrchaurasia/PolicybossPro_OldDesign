package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuoteEntity;

/**
 * Created by Nilesh Birhade on 08-03-2018.
 */

public class HealthCompareRequestEntity {


    /**
     * fba_id : 123
     * HealthRequestId : 11
     * agent_source : App
     * crn : 2132132
     * HealthRequest : {"CityID":1020,"PlanID":94,"PinCode":"400095","ContactEmail":"test.test@rupeeboss.com","ContactMobile":"900000000","ContactName":"pramod parit","DeductibleAmount":0,"ExistingCustomerReferenceID":0,"HealthType":"Health","MaritalStatusID":1,"MemberList":[{"MemberDOB":"07-06-1984","MemberGender":"M","MemberNumber":"1","MemberType":"Adult","MemberTypeID":"1","Age":35},{"MemberDOB":"07-06-1989","MemberGender":"F","MemberNumber":"2","MemberType":"Adult","MemberTypeID":"2","Age":28},{"MemberDOB":"29-04-2012","MemberGender":"F","MemberNumber":"5","MemberType":"Child","MemberTypeID":"3","Age":5}],"PolicyFor":"Family","PolicyTermYear":1,"ProductID":2,"SessionID":0,"SourceType":"APP","SumInsured":300000,"SupportsAgentID":2}
     */

    private int fba_id;
    private String HealthRequestId;
    private String agent_source;
    private String crn;
    private HealthQuoteEntity HealthRequest;

    public int getFba_id() {
        return fba_id;
    }

    public void setFba_id(int fba_id) {
        this.fba_id = fba_id;
    }

    public String getHealthRequestId() {
        return HealthRequestId;
    }

    public void setHealthRequestId(String HealthRequestId) {
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

    public HealthQuoteEntity getHealthRequest() {
        return HealthRequest;
    }

    public void setHealthRequest(HealthQuoteEntity HealthRequest) {
        this.HealthRequest = HealthRequest;
    }


}

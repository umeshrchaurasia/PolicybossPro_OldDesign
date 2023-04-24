package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class  HealthQuote implements Parcelable {
    /**
     * fba_id : 123
     * HealthRequestId : 13
     * agent_source : App
     * crn : 2132132
     * HealthRequest : {"HealthRequestId":13,"crn":"2132132","CityID":1020,"ContactEmail":"pramod.parit@rupeeboss.com","ContactMobile":"9930089092","ContactName":"pramod parit","DeductibleAmount":0,"ExistingCustomerReferenceID":0,"HealthType":"Health","MaritalStatusID":1,"PolicyFor":"Family","PolicyTermYear":1,"ProductID":2,"SessionID":0,"SourceType":"APP","SumInsured":"300000","SupportsAgentID":2,"fba_id":123,"agent_source":"App","Quote_Application_Status":"Q","conversion_date":null,"created_date":"2018-02-09T05:23:51.000Z","updated_date":null,"isActive":1,"MemberList":[{"HealthMemberListId":"37","MemberDOB":"07-06-1984","MemberGender":"M","MemberNumber":"1","MemberTypeID":"1","HealthRequestId":"13"},{"HealthMemberListId":"38","MemberDOB":"07-06-1989","MemberGender":"F","MemberNumber":"2","MemberTypeID":"2","HealthRequestId":"13"},{"HealthMemberListId":"39","MemberDOB":"29-04-2017","MemberGender":"F","MemberNumber":"5","MemberTypeID":"3","HealthRequestId":"13"}]}
     */

    private int fba_id;
    private int HealthRequestId;
    private String agent_source;
    private String crn;
    private String comment;
    private HealthRequestEntity HealthRequest;

    private List<OfflineQuoteListEntity> quote;




    public HealthQuote() {
    }


    protected HealthQuote(Parcel in) {
        fba_id = in.readInt();
        HealthRequestId = in.readInt();
        agent_source = in.readString();
        crn = in.readString();
        comment = in.readString();
        HealthRequest = in.readParcelable(HealthRequestEntity.class.getClassLoader());
        quote = in.createTypedArrayList(OfflineQuoteListEntity.CREATOR);
    }

    public static final Creator<HealthQuote> CREATOR = new Creator<HealthQuote>() {
        @Override
        public HealthQuote createFromParcel(Parcel in) {
            return new HealthQuote(in);
        }

        @Override
        public HealthQuote[] newArray(int size) {
            return new HealthQuote[size];
        }
    };

    public int getFba_id() {
        return fba_id;
    }

    public void setFba_id(int fba_id) {
        this.fba_id = fba_id;
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

    public HealthRequestEntity getHealthRequest() {
        return HealthRequest;
    }
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public void setHealthRequest(HealthRequestEntity HealthRequest) {
        this.HealthRequest = HealthRequest;
    }

    public List<OfflineQuoteListEntity> getQuote() {
        return quote;
    }

    public void setQuote(List<OfflineQuoteListEntity> quote) {
        this.quote = quote;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(fba_id);
        dest.writeInt(HealthRequestId);
        dest.writeString(agent_source);
        dest.writeString(crn);
        dest.writeString(comment);
        dest.writeParcelable(HealthRequest, flags);
        dest.writeTypedList(quote);
    }
}

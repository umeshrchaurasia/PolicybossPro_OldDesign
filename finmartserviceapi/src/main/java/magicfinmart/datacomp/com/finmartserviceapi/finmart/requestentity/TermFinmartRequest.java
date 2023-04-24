package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.OfflineQuoteListEntity;

/**
 * Created by Rajeev Ranjan on 07/04/2018.
 */

public class TermFinmartRequest implements Parcelable {

    int termRequestId;
    String insImage;
    int statusProgress;
    private String NetPremium;


    private String CreatedByUserFbaId;
    private String CreatedByUserFbaName;
    int fba_id;

    public TermFinmartRequest() {
    }


    protected TermFinmartRequest(Parcel in) {
        termRequestId = in.readInt();
        insImage = in.readString();
        statusProgress = in.readInt();
        NetPremium = in.readString();
        CreatedByUserFbaId = in.readString();
        CreatedByUserFbaName = in.readString();
        fba_id = in.readInt();
        termRequestEntity = in.readParcelable(TermRequestEntity.class.getClassLoader());
        quote = in.createTypedArrayList(OfflineQuoteListEntity.CREATOR);
    }

    public static final Creator<TermFinmartRequest> CREATOR = new Creator<TermFinmartRequest>() {
        @Override
        public TermFinmartRequest createFromParcel(Parcel in) {
            return new TermFinmartRequest(in);
        }

        @Override
        public TermFinmartRequest[] newArray(int size) {
            return new TermFinmartRequest[size];
        }
    };

    public int getStatusProgress() {
        return statusProgress;
    }

    public void setStatusProgress(int statusProgress) {
        this.statusProgress = statusProgress;
    }

    public int getFba_id() {
        return fba_id;
    }

    public void setFba_id(int fba_id) {
        this.fba_id = fba_id;
    }


    TermRequestEntity termRequestEntity;

    private List<OfflineQuoteListEntity> quote;


    public List<OfflineQuoteListEntity> getQuote() {
        return quote;
    }

    public void setQuote(List<OfflineQuoteListEntity> quote) {
        this.quote = quote;
    }


    public int getTermRequestId() {
        return termRequestId;
    }

    public void setTermRequestId(int termRequestId) {
        this.termRequestId = termRequestId;
    }

    public TermRequestEntity getTermRequestEntity() {
        return termRequestEntity;
    }

    public void setTermRequestEntity(TermRequestEntity termRequestEntity) {
        this.termRequestEntity = termRequestEntity;
    }

    public String getInsImage() {
        return insImage;
    }

    public void setInsImage(String insImage) {
        this.insImage = insImage;
    }

    public int getStatus_progress() {
        return statusProgress;
    }

    public void setStatus_progress(int status_progress) {
        this.statusProgress = status_progress;
    }

    public String getNetPremium() {
        return NetPremium;
    }

    public void setNetPremium(String NetPremium) {
        this.NetPremium = NetPremium;
    }

    public String getCreatedByUserFbaId() {
        return CreatedByUserFbaId;
    }

    public void setCreatedByUserFbaId(String createdByUserFbaId) {
        CreatedByUserFbaId = createdByUserFbaId;
    }

    public String getCreatedByUserFbaName() {
        return CreatedByUserFbaName;
    }

    public void setCreatedByUserFbaName(String createdByUserFbaName) {
        CreatedByUserFbaName = createdByUserFbaName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(termRequestId);
        dest.writeString(insImage);
        dest.writeInt(statusProgress);
        dest.writeString(NetPremium);
        dest.writeString(CreatedByUserFbaId);
        dest.writeString(CreatedByUserFbaName);
        dest.writeInt(fba_id);
        dest.writeParcelable(termRequestEntity, flags);
        dest.writeTypedList(quote);
    }
}

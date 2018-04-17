package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rajeev Ranjan on 07/04/2018.
 */

public class TermFinmartRequest implements Parcelable {
    int termRequestId;
    String insImage;
    int statusProgress;

    TermRequestEntity termRequestEntity;

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.termRequestId);
        dest.writeString(this.insImage);
        dest.writeInt(this.statusProgress);
        dest.writeParcelable(this.termRequestEntity, flags);
    }

    public TermFinmartRequest() {
    }

    protected TermFinmartRequest(Parcel in) {
        this.termRequestId = in.readInt();
        this.insImage = in.readString();
        this.statusProgress = in.readInt();
        this.termRequestEntity = in.readParcelable(TermRequestEntity.class.getClassLoader());
    }

    public static final Parcelable.Creator<TermFinmartRequest> CREATOR = new Parcelable.Creator<TermFinmartRequest>() {
        @Override
        public TermFinmartRequest createFromParcel(Parcel source) {
            return new TermFinmartRequest(source);
        }

        @Override
        public TermFinmartRequest[] newArray(int size) {
            return new TermFinmartRequest[size];
        }
    };
}

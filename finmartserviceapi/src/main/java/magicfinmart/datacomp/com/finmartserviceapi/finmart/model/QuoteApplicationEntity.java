package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuoteApplicationEntity implements Parcelable {

    @SerializedName("quote")
    private List<QuoteListEntity> QuoteList;
    @SerializedName("application")
    private List<ApplicationListEntity> ApplicationList;

    public List<QuoteListEntity> getQuoteList() {
        return QuoteList;
    }

    public void setQuoteList(List<QuoteListEntity> QuoteList) {
        this.QuoteList = QuoteList;
    }

    public List<ApplicationListEntity> getApplicationList() {
        return ApplicationList;
    }

    public void setApplicationList(List<ApplicationListEntity> ApplicationList) {
        this.ApplicationList = ApplicationList;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.QuoteList);
        dest.writeTypedList(this.ApplicationList);
    }

    public QuoteApplicationEntity() {
    }

    protected QuoteApplicationEntity(Parcel in) {
        this.QuoteList = in.createTypedArrayList(QuoteListEntity.CREATOR);
        this.ApplicationList = in.createTypedArrayList(ApplicationListEntity.CREATOR);
    }

    public static final Parcelable.Creator<QuoteApplicationEntity> CREATOR = new Parcelable.Creator<QuoteApplicationEntity>() {
        @Override
        public QuoteApplicationEntity createFromParcel(Parcel source) {
            return new QuoteApplicationEntity(source);
        }

        @Override
        public QuoteApplicationEntity[] newArray(int size) {
            return new QuoteApplicationEntity[size];
        }
    };
}

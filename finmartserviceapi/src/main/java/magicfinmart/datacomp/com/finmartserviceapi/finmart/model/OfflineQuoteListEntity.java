package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import android.os.Parcel;
import android.os.Parcelable;

public class OfflineQuoteListEntity implements Parcelable {


    /**
     * TranId : 2
     * Document_name :
     * document_path : 1540994210.download 2.jpg
     */

    private String TranId;
    private String Document_name;
    private String document_path;

    public String getTranId() {
        return TranId;
    }

    public void setTranId(String TranId) {
        this.TranId = TranId;
    }

    public String getDocument_name() {
        return Document_name;
    }

    public void setDocument_name(String Document_name) {
        this.Document_name = Document_name;
    }

    public String getDocument_path() {
        return document_path;
    }

    public void setDocument_path(String document_path) {
        this.document_path = document_path;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.TranId);
        dest.writeString(this.Document_name);
        dest.writeString(this.document_path);
    }

    public OfflineQuoteListEntity() {
    }

    protected OfflineQuoteListEntity(Parcel in) {
        this.TranId = in.readString();
        this.Document_name = in.readString();
        this.document_path = in.readString();
    }

    public static final Parcelable.Creator<OfflineQuoteListEntity> CREATOR = new Parcelable.Creator<OfflineQuoteListEntity>() {
        @Override
        public OfflineQuoteListEntity createFromParcel(Parcel source) {
            return new OfflineQuoteListEntity(source);
        }

        @Override
        public OfflineQuoteListEntity[] newArray(int size) {
            return new OfflineQuoteListEntity[size];
        }
    };
}

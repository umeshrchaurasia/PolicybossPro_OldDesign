package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class UploadMotorEntity implements Parcelable  {
    /**
     * TransId : 4
     * RequestId : 4
     * SavedStatus : 0
     * Document : [{"docname":"Last year policy copy","docpath":"OfflineDoc/87/1544620796437.jpg","id":"58"},{"docname":"RC copy","docpath":"","id":""},{"docname":"Other 1","docpath":"","id":""},{"docname":"Other 2","docpath":"","id":""}]
     */

    private String TransId;
    private int RequestId;
    private int SavedStatus;
    private List<DocumentEntity> Document;

    protected UploadMotorEntity(Parcel in) {
        TransId = in.readString();
        RequestId = in.readInt();
        SavedStatus = in.readInt();
        Document = in.createTypedArrayList(DocumentEntity.CREATOR);
    }

    public static final Creator<UploadMotorEntity> CREATOR = new Creator<UploadMotorEntity>() {
        @Override
        public UploadMotorEntity createFromParcel(Parcel in) {
            return new UploadMotorEntity(in);
        }

        @Override
        public UploadMotorEntity[] newArray(int size) {
            return new UploadMotorEntity[size];
        }
    };

    public String getTransId() {
        return TransId;
    }

    public void setTransId(String transId) {
        TransId = transId;
    }

    public int getRequestId() {
        return RequestId;
    }

    public void setRequestId(int requestId) {
        RequestId = requestId;
    }

    public int getSavedStatus() {
        return SavedStatus;
    }

    public void setSavedStatus(int savedStatus) {
        SavedStatus = savedStatus;
    }

    public List<DocumentEntity> getDocument() {
        return Document;
    }

    public void setDocument(List<DocumentEntity> document) {
        Document = document;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(TransId);
        dest.writeInt(RequestId);
        dest.writeInt(SavedStatus);
        dest.writeTypedList(Document);
    }
}
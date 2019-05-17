package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DocumentEntity implements Parcelable {
            /**
             * docname : Last year policy copy
             * docpath : OfflineDoc/87/1544620796437.jpg
             * id : 58
             */

            private String docname;
            private String docpath;
            private String id;

            public String getDocname() {
                return docname;
            }

            public void setDocname(String docname) {
                this.docname = docname;
            }

            public String getDocpath() {
                return docpath;
            }

            public void setDocpath(String docpath) {
                this.docpath = docpath;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.docname);
        dest.writeString(this.docpath);
        dest.writeString(this.id);
    }

    public DocumentEntity() {
    }

    protected DocumentEntity(Parcel in) {
        this.docname = in.readString();
        this.docpath = in.readString();
        this.id = in.readString();
    }

    public static final Parcelable.Creator<DocumentEntity> CREATOR = new Parcelable.Creator<DocumentEntity>() {
        @Override
        public DocumentEntity createFromParcel(Parcel source) {
            return new DocumentEntity(source);
        }

        @Override
        public DocumentEntity[] newArray(int size) {
            return new DocumentEntity[size];
        }
    };
}
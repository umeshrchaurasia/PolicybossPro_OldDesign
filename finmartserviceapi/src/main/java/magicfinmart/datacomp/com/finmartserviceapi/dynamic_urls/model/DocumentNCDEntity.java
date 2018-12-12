package magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.model;

import android.os.Parcel;
import android.os.Parcelable;

public  class DocumentNCDEntity implements Parcelable {
            /**
             * id : 2
             * ncdcampaignid : 2
             * documentpath : http://bo.mgfm.in/ncd//2/ncdedelweissbrokragestructure.pdf
             * documentname : Brokerage Structure
             * documenttype : pdf
             */

            private int id;
            private int ncdcampaignid;
            private String documentpath;
            private String documentname;
            private String documenttype;

    protected DocumentNCDEntity(Parcel in) {
        id = in.readInt();
        ncdcampaignid = in.readInt();
        documentpath = in.readString();
        documentname = in.readString();
        documenttype = in.readString();
    }

    public static final Creator<DocumentNCDEntity> CREATOR = new Creator<DocumentNCDEntity>() {
        @Override
        public DocumentNCDEntity createFromParcel(Parcel in) {
            return new DocumentNCDEntity(in);
        }

        @Override
        public DocumentNCDEntity[] newArray(int size) {
            return new DocumentNCDEntity[size];
        }
    };

    public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getNcdcampaignid() {
                return ncdcampaignid;
            }

            public void setNcdcampaignid(int ncdcampaignid) {
                this.ncdcampaignid = ncdcampaignid;
            }

            public String getDocumentpath() {
                return documentpath;
            }

            public void setDocumentpath(String documentpath) {
                this.documentpath = documentpath;
            }

            public String getDocumentname() {
                return documentname;
            }

            public void setDocumentname(String documentname) {
                this.documentname = documentname;
            }

            public String getDocumenttype() {
                return documenttype;
            }

            public void setDocumenttype(String documenttype) {
                this.documenttype = documenttype;
            }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(ncdcampaignid);
        dest.writeString(documentpath);
        dest.writeString(documentname);
        dest.writeString(documenttype);
    }
}

package magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public  class NDCMasterEntity implements Parcelable {
        /**
         * id : 2
         * camapignname : NCD of Edelweiss finance Ltd.
         * campaigndescription : 
         * insurancecompanyname : Edelweiss finance Ltd
         * bannerimage : http://bo.mgfm.in/ncd//2/ncdedelweiss.jpeg
         * guid : dfd59151-fd0c-11e8-bdfa-0273323e097a
         * document : [{"id":2,"ncdcampaignid":2,"documentpath":"http://bo.mgfm.in/ncd//2/ncdedelweissbrokragestructure.pdf","documentname":"Brokerage Structure","documenttype":"pdf"},{"id":3,"ncdcampaignid":2,"documentpath":"http://bo.mgfm.in/ncd//2/ncdedelweissproductnote.pdf","documentname":"Product note","documenttype":"pdf"},{"id":4,"ncdcampaignid":2,"documentpath":"http://bo.mgfm.in/ncd//2/ncdedelweissprocessnote.pdf","documentname":"Process note","documenttype":"pdf"},{"id":5,"ncdcampaignid":2,"documentpath":"http://bo.mgfm.in/ncd//2/ncdedelweissprefilledform.pdf","documentname":"Pre-filled form","documenttype":"pdf"},{"id":6,"ncdcampaignid":2,"documentpath":"http://180.179.141.99/FormPrinting/FrmDirectPrinting.aspx?details=vtxpKyclyfS6yTyLXjwvbw==&&Reference=2ylelx+gCU+ocwOm2EiTYA==&&Flag=K1byKZlOeCylulT1F2Yh/g==","documentname":"Download application form","documenttype":"html"}]
         */

        private int id;
        private String camapignname;
        private String campaigndescription;
        private String insurancecompanyname;
        private String bannerimage;
        private String guid;
        private List<DocumentBean> document;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCamapignname() {
            return camapignname;
        }

        public void setCamapignname(String camapignname) {
            this.camapignname = camapignname;
        }

        public String getCampaigndescription() {
            return campaigndescription;
        }

        public void setCampaigndescription(String campaigndescription) {
            this.campaigndescription = campaigndescription;
        }

        public String getInsurancecompanyname() {
            return insurancecompanyname;
        }

        public void setInsurancecompanyname(String insurancecompanyname) {
            this.insurancecompanyname = insurancecompanyname;
        }

        public String getBannerimage() {
            return bannerimage;
        }

        public void setBannerimage(String bannerimage) {
            this.bannerimage = bannerimage;
        }

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public List<DocumentBean> getDocument() {
            return document;
        }

        public void setDocument(List<DocumentBean> document) {
            this.document = document;
        }

        public static class DocumentBean {
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
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.camapignname);
        dest.writeString(this.campaigndescription);
        dest.writeString(this.insurancecompanyname);
        dest.writeString(this.bannerimage);
        dest.writeString(this.guid);
        dest.writeList(this.document);
    }

    public NDCMasterEntity() {
    }

    protected NDCMasterEntity(Parcel in) {
        this.id = in.readInt();
        this.camapignname = in.readString();
        this.campaigndescription = in.readString();
        this.insurancecompanyname = in.readString();
        this.bannerimage = in.readString();
        this.guid = in.readString();
        this.document = new ArrayList<DocumentBean>();
        in.readList(this.document, DocumentBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<NDCMasterEntity> CREATOR = new Parcelable.Creator<NDCMasterEntity>() {
        @Override
        public NDCMasterEntity createFromParcel(Parcel source) {
            return new NDCMasterEntity(source);
        }

        @Override
        public NDCMasterEntity[] newArray(int size) {
            return new NDCMasterEntity[size];
        }
    };
}
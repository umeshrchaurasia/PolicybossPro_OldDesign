package magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class NDCMasterEntity implements Parcelable {
    /**
     * id : 2
     * camapignname : NCD of Edelweiss finance Ltd.
     * campaigndescription :
     * insurancecompanyname : Edelweiss finance Ltd
     * bannerimage : https://bo.mgfm.in/ncd//2/ncdedelweiss.jpeg
     * guid : dfd59151-fd0c-11e8-bdfa-0273323e097a
     * document : [{"id":2,"ncdcampaignid":2,"documentpath":"https://bo.mgfm.in/ncd//2/ncdedelweissbrokragestructure.pdf","documentname":"Brokerage Structure","documenttype":"pdf"},{"id":3,"ncdcampaignid":2,"documentpath":"https://bo.mgfm.in/ncd//2/ncdedelweissproductnote.pdf","documentname":"Product note","documenttype":"pdf"},{"id":4,"ncdcampaignid":2,"documentpath":"http://bo.mgfm.in/ncd//2/ncdedelweissprocessnote.pdf","documentname":"Process note","documenttype":"pdf"},{"id":5,"ncdcampaignid":2,"documentpath":"http://bo.mgfm.in/ncd//2/ncdedelweissprefilledform.pdf","documentname":"Pre-filled form","documenttype":"pdf"},{"id":6,"ncdcampaignid":2,"documentpath":"http://180.179.141.99/FormPrinting/FrmDirectPrinting.aspx?details=vtxpKyclyfS6yTyLXjwvbw==&&Reference=2ylelx+gCU+ocwOm2EiTYA==&&Flag=K1byKZlOeCylulT1F2Yh/g==","documentname":"Download application form","documenttype":"html"}]
     */

    private int id;
    private String camapignname;
    private String campaigndescription;
    private String insurancecompanyname;
    private String bannerimage;
    private String guid;
    private String viewaddedncd;
    private List<DocumentNCDEntity> document;

    public NDCMasterEntity() {
    }

    protected NDCMasterEntity(Parcel in) {
        id = in.readInt();
        camapignname = in.readString();
        campaigndescription = in.readString();
        insurancecompanyname = in.readString();
        bannerimage = in.readString();
        guid = in.readString();
        viewaddedncd = in.readString();
        document = in.createTypedArrayList(DocumentNCDEntity.CREATOR);
    }

    public static final Creator<NDCMasterEntity> CREATOR = new Creator<NDCMasterEntity>() {
        @Override
        public NDCMasterEntity createFromParcel(Parcel in) {
            return new NDCMasterEntity(in);
        }

        @Override
        public NDCMasterEntity[] newArray(int size) {
            return new NDCMasterEntity[size];
        }
    };

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

    public String getViewaddedncd() {
        return viewaddedncd;
    }

    public void setViewaddedncd(String viewaddedncd) {
        this.viewaddedncd = viewaddedncd;
    }

    public List<DocumentNCDEntity> getDocument() {
        return document;
    }

    public void setDocument(List<DocumentNCDEntity> document) {
        this.document = document;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(camapignname);
        dest.writeString(campaigndescription);
        dest.writeString(insurancecompanyname);
        dest.writeString(bannerimage);
        dest.writeString(guid);
        dest.writeString(viewaddedncd);
        dest.writeTypedList(document);
    }
}
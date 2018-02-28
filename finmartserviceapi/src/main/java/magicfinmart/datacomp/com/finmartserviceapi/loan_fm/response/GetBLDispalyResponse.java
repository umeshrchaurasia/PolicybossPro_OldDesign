package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.BLEntity;

/**
 * Created by IN-RB on 27-01-2018.
 */

public class GetBLDispalyResponse extends APIResponse implements Parcelable {

    /**
     * data : [{"Bank_Id":33,"Bank_Code":"KOTAK MAHINDRA","Bank_Name":"KOTAK MAHINDRA BANK","roi":"11.49","pf":"2.00","pf_type":"Percentage","Bank_Logo":"http://erp.rupeeboss.com/Banklogo/kotak.png","processingfee":10000,"roi_type":"Fixed"},{"Bank_Id":20,"Bank_Code":"HDFC","Bank_Name":"HDFC BANK LTD","roi":"11.49","pf":"2.00","pf_type":"Percentage","Bank_Logo":"http://erp.rupeeboss.com/Banklogo/hdfc.png","processingfee":10000,"roi_type":"Fixed"},{"Bank_Id":26,"Bank_Code":"IDFC","Bank_Name":"IDFC BANK","roi":"11.50","pf":"2.00","pf_type":"Percentage","Bank_Logo":"http://erp.rupeeboss.com/Banklogo/idfc_bank.jpg","processingfee":10000,"roi_type":"Fixed"},{"Bank_Id":25,"Bank_Code":"ICICI","Bank_Name":"ICICI BANK LIMITED","roi":"11.59","pf":"2.50","pf_type":"Percentage","Bank_Logo":"http://erp.rupeeboss.com/Banklogo/icici.png","processingfee":12500,"roi_type":"Fixed"},{"Bank_Id":5,"Bank_Code":"BAJAJ FINANCE","Bank_Name":"BAJAJ FINANCE LIMITED","roi":"11.99","pf":"3.00","pf_type":"Percentage","Bank_Logo":"http://erp.rupeeboss.com/Banklogo/bajaj.png","processingfee":15000,"roi_type":"Fixed"},{"Bank_Id":4,"Bank_Code":"AXIS","Bank_Name":"AXIS BANK LTD","roi":"12.00","pf":"2.00","pf_type":"Percentage","Bank_Logo":"http://erp.rupeeboss.com/Banklogo/axis.jpg","processingfee":10000,"roi_type":"Fixed"},{"Bank_Id":50,"Bank_Code":"TATA CAPITAL","Bank_Name":"TATA CAPITAL FINANCIAL SERVICES LIMITED","roi":"12.50","pf":"2.00","pf_type":"Percentage","Bank_Logo":"http://erp.rupeeboss.com/Banklogo/tata-capital.png","processingfee":10000,"roi_type":"Fixed"}]
     * quote_id : 17992
     * url : http://erp.rupeeboss.com/BalanceTransfer/PL_BT_Form.aspx
     */

    private int quote_id;
    private String url;
    private List<BLEntity> data;


    public int getQuote_id() {
        return quote_id;
    }

    public void setQuote_id(int quote_id) {
        this.quote_id = quote_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<BLEntity> getData() {
        return data;
    }

    public void setData(List<BLEntity> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.quote_id);
        dest.writeString(this.url);
        dest.writeTypedList(this.data);
    }

    public GetBLDispalyResponse() {
    }

    protected GetBLDispalyResponse(Parcel in) {
        this.quote_id = in.readInt();
        this.url = in.readString();
        this.data = in.createTypedArrayList(BLEntity.CREATOR);
        in.readList(this.data, BLEntity.class.getClassLoader());
    }

    public static final Parcelable.Creator<GetBLDispalyResponse> CREATOR = new Parcelable.Creator<GetBLDispalyResponse>() {
        @Override
        public GetBLDispalyResponse createFromParcel(Parcel source) {
            return new GetBLDispalyResponse(source);
        }

        @Override
        public GetBLDispalyResponse[] newArray(int size) {
            return new GetBLDispalyResponse[size];
        }
    };
}

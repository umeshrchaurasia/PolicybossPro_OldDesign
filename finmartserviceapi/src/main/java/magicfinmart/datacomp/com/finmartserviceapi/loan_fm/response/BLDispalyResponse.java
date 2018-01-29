package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponseBL;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.BLEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.BLSavingEntity;

/**
 * Created by IN-RB on 27-01-2018.
 */

public class BLDispalyResponse extends APIResponseBL   {


    /**
     * status : 1
     * data : [{"Bank_Id":33,"Bank_Code":"KOTAK MAHINDRA","Bank_Name":"KOTAK MAHINDRA BANK","roi":"11.49","pf":"2.00","pf_type":"Percentage","Bank_Logo":"http://erp.rupeeboss.com/Banklogo/kotak.png","processingfee":10000,"roi_type":"Fixed"},{"Bank_Id":20,"Bank_Code":"HDFC","Bank_Name":"HDFC BANK LTD","roi":"11.49","pf":"2.00","pf_type":"Percentage","Bank_Logo":"http://erp.rupeeboss.com/Banklogo/hdfc.png","processingfee":10000,"roi_type":"Fixed"},{"Bank_Id":26,"Bank_Code":"IDFC","Bank_Name":"IDFC BANK","roi":"11.50","pf":"2.00","pf_type":"Percentage","Bank_Logo":"http://erp.rupeeboss.com/Banklogo/idfc_bank.jpg","processingfee":10000,"roi_type":"Fixed"},{"Bank_Id":25,"Bank_Code":"ICICI","Bank_Name":"ICICI BANK LIMITED","roi":"11.59","pf":"2.50","pf_type":"Percentage","Bank_Logo":"http://erp.rupeeboss.com/Banklogo/icici.png","processingfee":12500,"roi_type":"Fixed"},{"Bank_Id":5,"Bank_Code":"BAJAJ FINANCE","Bank_Name":"BAJAJ FINANCE LIMITED","roi":"11.99","pf":"3.00","pf_type":"Percentage","Bank_Logo":"http://erp.rupeeboss.com/Banklogo/bajaj.png","processingfee":15000,"roi_type":"Fixed"},{"Bank_Id":4,"Bank_Code":"AXIS","Bank_Name":"AXIS BANK LTD","roi":"12.00","pf":"2.00","pf_type":"Percentage","Bank_Logo":"http://erp.rupeeboss.com/Banklogo/axis.jpg","processingfee":10000,"roi_type":"Fixed"}]
     * saving : {"amount":11246.43,"new_amount":10993.79,"drop_emi":252.63,"drop_in_int":1,"savings":15157.95,"emiperlacs":0.10993793720498}
     */



    private BLSavingEntity saving;
    private List<BLEntity> data;



    public BLSavingEntity getSaving() {
        return saving;
    }

    public void setSaving(BLSavingEntity saving) {
        this.saving = saving;
    }

    public List<BLEntity> getData() {
        return data;
    }

    public void setData(List<BLEntity> data) {
        this.data = data;
    }




}

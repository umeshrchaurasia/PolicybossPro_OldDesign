package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import com.google.gson.annotations.SerializedName;

public class MpsDataEntity {
    /**
     * ErrorCode :
     * ErrorDescription :
     * MSG : Record found
     * MSGID :
     * Status : 1
     * PaymRefeID : 18317122913357780
     * PaymentURL : https://goo.gl/gnjL2E
     */

    private String ErrorCode;
    private String ErrorDescription;
    private String MSG;
    private String MSGID;
    @SerializedName("Status")
    private String StatusX;
    private long PaymRefeID;
    private String PaymentURL;

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public String getErrorDescription() {
        return ErrorDescription;
    }

    public void setErrorDescription(String ErrorDescription) {
        this.ErrorDescription = ErrorDescription;
    }

    public String getMSG() {
        return MSG;
    }

    public void setMSG(String MSG) {
        this.MSG = MSG;
    }

    public String getMSGID() {
        return MSGID;
    }

    public void setMSGID(String MSGID) {
        this.MSGID = MSGID;
    }

    public String getStatusX() {
        return StatusX;
    }

    public void setStatusX(String StatusX) {
        this.StatusX = StatusX;
    }

    public long getPaymRefeID() {
        return PaymRefeID;
    }

    public void setPaymRefeID(long PaymRefeID) {
        this.PaymRefeID = PaymRefeID;
    }

    public String getPaymentURL() {
        return PaymentURL;
    }

    public void setPaymentURL(String PaymentURL) {
        this.PaymentURL = PaymentURL;
    }
}
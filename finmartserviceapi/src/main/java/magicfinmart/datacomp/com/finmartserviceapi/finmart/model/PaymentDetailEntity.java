package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

public class PaymentDetailEntity {
    /**
     * CustID : 8407152
     * Name : tttttt Test
     * Email : testpay@yahoo.com
     * Mobile : 8198868870
     * image : images/salesmaterial/razorpay/finlog.png
     * dispmsg : Please Create CustomerId
     * Status : 0
     */

    private String CustID;
    private String Name;
    private String Email;
    private String Mobile;
    private String image;
    private String dispmsg;
    private int Status;


    private String productname;
    private String amount;



    private String displayamounts;

    public String getCustID() {
        return CustID;
    }

    public void setCustID(String CustID) {
        this.CustID = CustID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDispmsg() {
        return dispmsg;
    }

    public void setDispmsg(String dispmsg) {
        this.dispmsg = dispmsg;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDisplayamount() {
        return displayamounts;
    }

    public void setDisplayamount(String displayamounts) {
        this.displayamounts = displayamounts;
    }
}
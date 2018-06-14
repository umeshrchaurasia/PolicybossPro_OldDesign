package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

public class PendingCasesEntity {
    /**
     * Id : 296
     * CustomerName : danial
     * Category : Car
     * qatype : Q
     * ApplnStatus : 0
     * mobile : 9673484578
     * quotetype : MOI
     * created_date : 2018-02-19T12:21:35.000Z
     * pendingdays : 0
     */

    private int Id;
    private String CustomerName;
    private String Category;
    private String qatype;
    private String ApplnStatus;
    private String mobile;
    private String quotetype;
    private String created_date;
    private int pendingdays;
    private String BankImage;


    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getQatype() {
        return qatype;
    }

    public void setQatype(String qatype) {
        this.qatype = qatype;
    }

    public String getApplnStatus() {
        return ApplnStatus;
    }

    public void setApplnStatus(String ApplnStatus) {
        this.ApplnStatus = ApplnStatus;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getQuotetype() {
        return quotetype;
    }

    public void setQuotetype(String quotetype) {
        this.quotetype = quotetype;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public int getPendingdays() {
        return pendingdays;
    }

    public void setPendingdays(int pendingdays) {
        this.pendingdays = pendingdays;
    }

    public String getBankImage() {
        return BankImage;
    }

    public void setBankImage(String bankImage) {
        BankImage = bankImage;
    }

}
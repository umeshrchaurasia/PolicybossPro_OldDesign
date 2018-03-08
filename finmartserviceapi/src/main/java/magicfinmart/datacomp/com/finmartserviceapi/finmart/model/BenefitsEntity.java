package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

public class BenefitsEntity {
    /**
     * DisplayName :
     * ProdBeneID : 0
     * BeneID : 1
     * BeneDesc : Room Rent Limit
     * Benefit : No Limit
     */

    private String DisplayName;
    private int ProdBeneID;
    private int BeneID;
    private String BeneDesc;
    private String Benefit;

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String DisplayName) {
        this.DisplayName = DisplayName;
    }

    public int getProdBeneID() {
        return ProdBeneID;
    }

    public void setProdBeneID(int ProdBeneID) {
        this.ProdBeneID = ProdBeneID;
    }

    public int getBeneID() {
        return BeneID;
    }

    public void setBeneID(int BeneID) {
        this.BeneID = BeneID;
    }

    public String getBeneDesc() {
        return BeneDesc;
    }

    public void setBeneDesc(String BeneDesc) {
        this.BeneDesc = BeneDesc;
    }

    public String getBenefit() {
        return Benefit;
    }

    public void setBenefit(String Benefit) {
        this.Benefit = Benefit;
    }
}
package magicfinmart.datacomp.com.finmartserviceapi.model;

public class BenefitsPopupEntity {
    /**
     * Term : 20
     * ULOnDeath : 5000000
     */

    private String Term;
    private String ULOnDeath;

    public String getAnnualPayout() {
        return AnnualPayout;
    }

    public void setAnnualPayout(String annualPayout) {
        AnnualPayout = annualPayout;
    }

    private String AnnualPayout;

    public String getTerm() {
        return Term;
    }

    public void setTerm(String Term) {
        this.Term = Term;
    }

    public String getULOnDeath() {
        return ULOnDeath;
    }

    public void setULOnDeath(String ULOnDeath) {
        this.ULOnDeath = ULOnDeath;
    }
}
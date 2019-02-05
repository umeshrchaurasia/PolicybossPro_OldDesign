package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity;

public class LICIllustrationRequestEntity {

    /**
     * PlanNumber : 833
     * PlanTerm : 20
     * SumAssured : 1000000
     * PaymentMode : Y
     * DOB : 15/Dec/1988
     * TotalPrem : 56263
     * BasicPrem : 53840
     * GST1 : 2423
     * PremPaidUL : 71750
     * HdfcPrem : 14207
     */

    private String PlanNumber;
    private int PlanTerm;
    private int SumAssured;
    private String PaymentMode;
    private String DOB;
    private int TotalPrem;
    private int BasicPrem;
    private int GST1;
    private int PremPaidUL;
    private int HdfcPrem;

    public String getPlanNumber() {
        return PlanNumber;
    }

    public void setPlanNumber(String PlanNumber) {
        this.PlanNumber = PlanNumber;
    }

    public int getPlanTerm() {
        return PlanTerm;
    }

    public void setPlanTerm(int PlanTerm) {
        this.PlanTerm = PlanTerm;
    }

    public int getSumAssured() {
        return SumAssured;
    }

    public void setSumAssured(int SumAssured) {
        this.SumAssured = SumAssured;
    }

    public String getPaymentMode() {
        return PaymentMode;
    }

    public void setPaymentMode(String PaymentMode) {
        this.PaymentMode = PaymentMode;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public int getTotalPrem() {
        return TotalPrem;
    }

    public void setTotalPrem(int TotalPrem) {
        this.TotalPrem = TotalPrem;
    }

    public int getBasicPrem() {
        return BasicPrem;
    }

    public void setBasicPrem(int BasicPrem) {
        this.BasicPrem = BasicPrem;
    }

    public int getGST1() {
        return GST1;
    }

    public void setGST1(int GST1) {
        this.GST1 = GST1;
    }

    public int getPremPaidUL() {
        return PremPaidUL;
    }

    public void setPremPaidUL(int PremPaidUL) {
        this.PremPaidUL = PremPaidUL;
    }

    public int getHdfcPrem() {
        return HdfcPrem;
    }

    public void setHdfcPrem(int HdfcPrem) {
        this.HdfcPrem = HdfcPrem;
    }
}

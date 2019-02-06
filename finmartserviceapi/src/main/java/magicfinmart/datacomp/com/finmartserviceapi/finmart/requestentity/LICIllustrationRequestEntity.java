package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity;

public class LICIllustrationRequestEntity {


    /**
     * PlanTerm : 20
     * SumAssured : 5000000
     * PaymentMode : Y
     * DOB : 01/Aug/1980
     * HdfcPrem : 6784
     * HdfcBasicPrem : 6504
     * TotalPrem : 297444
     * BasicPrem : 284635
     * PremPaidUL : 304228
     * hdfcGst1 : 280
     * hdfcGst2 : 0
     * licGst1 : 12809
     * licGst2 : 6404
     */

    private String PlanTerm;
    private String PaymentMode;
    private String DOB;

    private long SumAssured;
    private long HdfcPrem;
    private long HdfcBasicPrem;
    private long TotalPrem;
    private long BasicPrem;

    private long PremPaidUL;
    private long hdfcGst1;
    private long hdfcGst2;
    private long licGst1;
    private long licGst2;



    public LICIllustrationRequestEntity() {

        this.SumAssured = 0;
        this.HdfcPrem = 0;
        this.HdfcBasicPrem= 0;
        this.TotalPrem = 0;
        this.BasicPrem = 0;

        this.PremPaidUL = 0;
        this.hdfcGst1 = 0;
        this.hdfcGst2 = 0;
        this.licGst1 = 0;
        this.licGst2 = 0;
    }

    public String getPlanTerm() {
        return PlanTerm;
    }

    public void setPlanTerm(String planTerm) {
        PlanTerm = planTerm;
    }

    public String getPaymentMode() {
        return PaymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        PaymentMode = paymentMode;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public long getSumAssured() {
        return SumAssured;
    }

    public void setSumAssured(long sumAssured) {
        SumAssured = sumAssured;
    }

    public long getHdfcPrem() {
        return HdfcPrem;
    }

    public void setHdfcPrem(long hdfcPrem) {
        HdfcPrem = hdfcPrem;
    }

    public long getHdfcBasicPrem() {
        return HdfcBasicPrem;
    }

    public void setHdfcBasicPrem(long hdfcBasicPrem) {
        HdfcBasicPrem = hdfcBasicPrem;
    }

    public long getTotalPrem() {
        return TotalPrem;
    }

    public void setTotalPrem(long totalPrem) {
        TotalPrem = totalPrem;
    }

    public long getBasicPrem() {
        return BasicPrem;
    }

    public void setBasicPrem(long basicPrem) {
        BasicPrem = basicPrem;
    }

    public long getPremPaidUL() {
        return PremPaidUL;
    }

    public void setPremPaidUL(long premPaidUL) {
        PremPaidUL = premPaidUL;
    }

    public long getHdfcGst1() {
        return hdfcGst1;
    }

    public void setHdfcGst1(long hdfcGst1) {
        this.hdfcGst1 = hdfcGst1;
    }

    public long getHdfcGst2() {
        return hdfcGst2;
    }

    public void setHdfcGst2(long hdfcGst2) {
        this.hdfcGst2 = hdfcGst2;
    }

    public long getLicGst1() {
        return licGst1;
    }

    public void setLicGst1(long licGst1) {
        this.licGst1 = licGst1;
    }

    public long getLicGst2() {
        return licGst2;
    }

    public void setLicGst2(long licGst2) {
        this.licGst2 = licGst2;
    }



}

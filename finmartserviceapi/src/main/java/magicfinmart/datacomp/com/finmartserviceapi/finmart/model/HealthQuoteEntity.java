package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import java.util.List;

public class HealthQuoteEntity {
    /**
     * CustomerReferenceID : 0
     * QuoteId : 0
     * PolicyTermYear : 1
     * PlanName : Supreme
     * InsurerName : Liberty Videocon
     * InsurerLogoName :
     * ProductName : Health Connect Floater
     * PlanID : 47
     * ZoneID : 0
     * OtherPlanID :
     * ProdID : 104
     * InsurerId : 26
     * ServiceTax : 0
     * SumInsured : 300000
     * HMBValue :
     * IsOnlinePayment : 0
     * KeyFeatures :
     * BroucherDownloadLink :
     * Discount : 0
     * Deductible_Amount : 0
     * NetPremium : 12166
     * GrossPremium : 0
     * DiscountPercent :
     * Premium :
     * Group_name :
     * QuoteStatus :
     * ProposerPageUrl :
     * pincode : 400095
     * FinalProductID : 104
     * LstbenfitsFive : [{"DisplayName":"","ProdBeneID":0,"BeneID":1,"BeneDesc":"Room Rent Limit","Benefit":"No Limit"}]
     */

    private int CustomerReferenceID;
    private int QuoteId;
    private int PolicyTermYear;
    private String PlanName;
    private String InsurerName;
    private String InsurerLogoName;
    private String ProductName;
    private int PlanID;
    private int ZoneID;
    private String OtherPlanID;
    private int ProdID;
    private int InsurerId;
    private int ServiceTax;
    private double SumInsured;
    private String HMBValue;
    private int IsOnlinePayment;
    private String KeyFeatures;
    private String BroucherDownloadLink;
    private int Discount;
    private int Deductible_Amount;
    private double NetPremium;
    private double GrossPremium;
    private String DiscountPercent;
    private String Premium;
    private String Group_name;
    private String QuoteStatus;
    private String ProposerPageUrl;
    private String pincode;
    private int FinalProductID;
    private List<BenefitsEntity> LstbenfitsFive;


    //for compare check
    private boolean isCompare;
    private boolean isMore;

    public boolean getIsMore() {
        return isMore;
    }

    public void setIsMore(boolean isMore) {
        this.isMore = isMore;
    }

    public boolean isCompare() {
        return isCompare;
    }

    public void setCompare(boolean compare) {
        isCompare = compare;
    }

    //to show no of childs count
    private int totalChilds;

    public int getTotalChilds() {
        return totalChilds;
    }

    public void setTotalChilds(int totalChilds) {
        this.totalChilds = totalChilds;
    }

    public int getCustomerReferenceID() {
        return CustomerReferenceID;
    }

    public void setCustomerReferenceID(int CustomerReferenceID) {
        this.CustomerReferenceID = CustomerReferenceID;
    }

    public int getQuoteId() {
        return QuoteId;
    }

    public void setQuoteId(int QuoteId) {
        this.QuoteId = QuoteId;
    }

    public int getPolicyTermYear() {
        return PolicyTermYear;
    }

    public void setPolicyTermYear(int PolicyTermYear) {
        this.PolicyTermYear = PolicyTermYear;
    }

    public String getPlanName() {
        return PlanName;
    }

    public void setPlanName(String PlanName) {
        this.PlanName = PlanName;
    }

    public String getInsurerName() {
        return InsurerName;
    }

    public void setInsurerName(String InsurerName) {
        this.InsurerName = InsurerName;
    }

    public String getInsurerLogoName() {
        return InsurerLogoName;
    }

    public void setInsurerLogoName(String InsurerLogoName) {
        this.InsurerLogoName = InsurerLogoName;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public int getPlanID() {
        return PlanID;
    }

    public void setPlanID(int PlanID) {
        this.PlanID = PlanID;
    }

    public int getZoneID() {
        return ZoneID;
    }

    public void setZoneID(int ZoneID) {
        this.ZoneID = ZoneID;
    }

    public String getOtherPlanID() {
        return OtherPlanID;
    }

    public void setOtherPlanID(String OtherPlanID) {
        this.OtherPlanID = OtherPlanID;
    }

    public int getProdID() {
        return ProdID;
    }

    public void setProdID(int ProdID) {
        this.ProdID = ProdID;
    }

    public int getInsurerId() {
        return InsurerId;
    }

    public void setInsurerId(int InsurerId) {
        this.InsurerId = InsurerId;
    }

    public int getServiceTax() {
        return ServiceTax;
    }

    public void setServiceTax(int ServiceTax) {
        this.ServiceTax = ServiceTax;
    }

    public double getSumInsured() {
        return SumInsured;
    }

    public void setSumInsured(double SumInsured) {
        this.SumInsured = SumInsured;
    }

    public String getHMBValue() {
        return HMBValue;
    }

    public void setHMBValue(String HMBValue) {
        this.HMBValue = HMBValue;
    }

    public int getIsOnlinePayment() {
        return IsOnlinePayment;
    }

    public void setIsOnlinePayment(int IsOnlinePayment) {
        this.IsOnlinePayment = IsOnlinePayment;
    }

    public String getKeyFeatures() {
        return KeyFeatures;
    }

    public void setKeyFeatures(String KeyFeatures) {
        this.KeyFeatures = KeyFeatures;
    }

    public String getBroucherDownloadLink() {
        return BroucherDownloadLink;
    }

    public void setBroucherDownloadLink(String BroucherDownloadLink) {
        this.BroucherDownloadLink = BroucherDownloadLink;
    }

    public int getDiscount() {
        return Discount;
    }

    public void setDiscount(int Discount) {
        this.Discount = Discount;
    }

    public int getDeductible_Amount() {
        return Deductible_Amount;
    }

    public void setDeductible_Amount(int Deductible_Amount) {
        this.Deductible_Amount = Deductible_Amount;
    }

    public double getNetPremium() {
        return NetPremium;
    }

    public void setNetPremium(double NetPremium) {
        this.NetPremium = NetPremium;
    }

    public double getGrossPremium() {
        return GrossPremium;
    }

    public void setGrossPremium(double GrossPremium) {
        this.GrossPremium = GrossPremium;
    }

    public String getDiscountPercent() {
        return DiscountPercent;
    }

    public void setDiscountPercent(String DiscountPercent) {
        this.DiscountPercent = DiscountPercent;
    }

    public String getPremium() {
        return Premium;
    }

    public void setPremium(String Premium) {
        this.Premium = Premium;
    }

    public String getGroup_name() {
        return Group_name;
    }

    public void setGroup_name(String Group_name) {
        this.Group_name = Group_name;
    }

    public String getQuoteStatus() {
        return QuoteStatus;
    }

    public void setQuoteStatus(String QuoteStatus) {
        this.QuoteStatus = QuoteStatus;
    }

    public String getProposerPageUrl() {
        return ProposerPageUrl;
    }

    public void setProposerPageUrl(String ProposerPageUrl) {
        this.ProposerPageUrl = ProposerPageUrl;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public int getFinalProductID() {
        return FinalProductID;
    }

    public void setFinalProductID(int FinalProductID) {
        this.FinalProductID = FinalProductID;
    }

    public List<BenefitsEntity> getLstbenfitsFive() {
        return LstbenfitsFive;
    }

    public void setLstbenfitsFive(List<BenefitsEntity> LstbenfitsFive) {
        this.LstbenfitsFive = LstbenfitsFive;
    }


}
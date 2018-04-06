package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity;

/**
 * Created by Nilesh Birhade on 05-04-2018.
 */

public class TermRequestEntity {

    /**
     * PolicyTerm : 20
     * InsuredGender : M
     * Is_TabaccoUser : false
     * SumAssured : 10000000
     * InsuredDOB : 13-03-1985
     * PaymentModeValue : 1
     * PolicyCommencementDate : 24-03-2018
     * CityName : Mumbai
     * State : Maharashtra
     * PlanTaken : Life
     * Frequency : Annual
     * DeathBenefitOption : Lump-Sum
     * PPT : 20
     * IncomeTerm : 20
     * MonthlyIncome : 25000
     * LumpsumAmount : 10000000
     * IncreaseIncomePercentage : 5
     * IncreaseSAPercentage :
     * ADBPercentage : 100
     * CISA :
     * LumpsumBSAProp :
     * ADBSA :
     * TypeOfLife :
     * ATPDSA :
     * HCBSA :
     * WOP :
     * PaymentOptn :
     * MaritalStatus :
     * PremiumPaymentOption :
     * ServiceTaxNotApplicable :
     * CIBenefit :
     * ADHB :
     * InsurerId : 39
     * SessionID :
     * Existing_ProductInsuranceMapping_Id :
     * ContactName : Xzb xhxh
     * ContactEmail : finmarttest@gmail.com
     * ContactMobile :
     * SupportsAgentID : 1682
     */

    private String PolicyTerm;
    private String InsuredGender;
    private String Is_TabaccoUser;
    private String SumAssured;
    private String InsuredDOB;
    private String PaymentModeValue;
    private String PolicyCommencementDate;
    private String CityName;
    private String State;
    private String PlanTaken;
    private String Frequency;
    private String DeathBenefitOption;
    private String PPT;
    private String IncomeTerm;

    //HDFC Specific Parameters
    private String MonthlyIncome;
    private String LumpsumAmount;
    private String IncreaseIncomePercentage;
    private String IncreaseSAPercentage;
    private String ADBPercentage;

    //Edelweiss Specific Parameters
    private String CISA;
    private String LumpsumBSAProp;
    private String ADBSA;
    private String TypeOfLife;
    private String ATPDSA;
    private String HCBSA;
    private String WOP;
    private String PaymentOptn;


    // ICICI Specific Paramaeters
    private String MaritalStatus;
    private String PremiumPaymentOption;
    private String ServiceTaxNotApplicable;
    private String CIBenefit;
    private String ADHB;

    private int InsurerId;
    private String SessionID;
    private String Existing_ProductInsuranceMapping_Id;
    private String ContactName;
    private String ContactEmail;
    private String ContactMobile;
    private String SupportsAgentID;

    public String getPolicyTerm() {
        return PolicyTerm;
    }

    public void setPolicyTerm(String PolicyTerm) {
        this.PolicyTerm = PolicyTerm;
    }

    public String getInsuredGender() {
        return InsuredGender;
    }

    public void setInsuredGender(String InsuredGender) {
        this.InsuredGender = InsuredGender;
    }

    public String getIs_TabaccoUser() {
        return Is_TabaccoUser;
    }

    public void setIs_TabaccoUser(String Is_TabaccoUser) {
        this.Is_TabaccoUser = Is_TabaccoUser;
    }

    public String getSumAssured() {
        return SumAssured;
    }

    public void setSumAssured(String SumAssured) {
        this.SumAssured = SumAssured;
    }

    public String getInsuredDOB() {
        return InsuredDOB;
    }

    public void setInsuredDOB(String InsuredDOB) {
        this.InsuredDOB = InsuredDOB;
    }

    public String getPaymentModeValue() {
        return PaymentModeValue;
    }

    public void setPaymentModeValue(String PaymentModeValue) {
        this.PaymentModeValue = PaymentModeValue;
    }

    public String getPolicyCommencementDate() {
        return PolicyCommencementDate;
    }

    public void setPolicyCommencementDate(String PolicyCommencementDate) {
        this.PolicyCommencementDate = PolicyCommencementDate;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getPlanTaken() {
        return PlanTaken;
    }

    public void setPlanTaken(String PlanTaken) {
        this.PlanTaken = PlanTaken;
    }

    public String getFrequency() {
        return Frequency;
    }

    public void setFrequency(String Frequency) {
        this.Frequency = Frequency;
    }

    public String getDeathBenefitOption() {
        return DeathBenefitOption;
    }

    public void setDeathBenefitOption(String DeathBenefitOption) {
        this.DeathBenefitOption = DeathBenefitOption;
    }

    public String getPPT() {
        return PPT;
    }

    public void setPPT(String PPT) {
        this.PPT = PPT;
    }

    public String getIncomeTerm() {
        return IncomeTerm;
    }

    public void setIncomeTerm(String IncomeTerm) {
        this.IncomeTerm = IncomeTerm;
    }

    public String getMonthlyIncome() {
        return MonthlyIncome;
    }

    public void setMonthlyIncome(String MonthlyIncome) {
        this.MonthlyIncome = MonthlyIncome;
    }

    public String getLumpsumAmount() {
        return LumpsumAmount;
    }

    public void setLumpsumAmount(String LumpsumAmount) {
        this.LumpsumAmount = LumpsumAmount;
    }

    public String getIncreaseIncomePercentage() {
        return IncreaseIncomePercentage;
    }

    public void setIncreaseIncomePercentage(String IncreaseIncomePercentage) {
        this.IncreaseIncomePercentage = IncreaseIncomePercentage;
    }

    public String getIncreaseSAPercentage() {
        return IncreaseSAPercentage;
    }

    public void setIncreaseSAPercentage(String IncreaseSAPercentage) {
        this.IncreaseSAPercentage = IncreaseSAPercentage;
    }

    public String getADBPercentage() {
        return ADBPercentage;
    }

    public void setADBPercentage(String ADBPercentage) {
        this.ADBPercentage = ADBPercentage;
    }

    public String getCISA() {
        return CISA;
    }

    public void setCISA(String CISA) {
        this.CISA = CISA;
    }

    public String getLumpsumBSAProp() {
        return LumpsumBSAProp;
    }

    public void setLumpsumBSAProp(String LumpsumBSAProp) {
        this.LumpsumBSAProp = LumpsumBSAProp;
    }

    public String getADBSA() {
        return ADBSA;
    }

    public void setADBSA(String ADBSA) {
        this.ADBSA = ADBSA;
    }

    public String getTypeOfLife() {
        return TypeOfLife;
    }

    public void setTypeOfLife(String TypeOfLife) {
        this.TypeOfLife = TypeOfLife;
    }

    public String getATPDSA() {
        return ATPDSA;
    }

    public void setATPDSA(String ATPDSA) {
        this.ATPDSA = ATPDSA;
    }

    public String getHCBSA() {
        return HCBSA;
    }

    public void setHCBSA(String HCBSA) {
        this.HCBSA = HCBSA;
    }

    public String getWOP() {
        return WOP;
    }

    public void setWOP(String WOP) {
        this.WOP = WOP;
    }

    public String getPaymentOptn() {
        return PaymentOptn;
    }

    public void setPaymentOptn(String PaymentOptn) {
        this.PaymentOptn = PaymentOptn;
    }

    public String getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(String MaritalStatus) {
        this.MaritalStatus = MaritalStatus;
    }

    public String getPremiumPaymentOption() {
        return PremiumPaymentOption;
    }

    public void setPremiumPaymentOption(String PremiumPaymentOption) {
        this.PremiumPaymentOption = PremiumPaymentOption;
    }

    public String getServiceTaxNotApplicable() {
        return ServiceTaxNotApplicable;
    }

    public void setServiceTaxNotApplicable(String ServiceTaxNotApplicable) {
        this.ServiceTaxNotApplicable = ServiceTaxNotApplicable;
    }

    public String getCIBenefit() {
        return CIBenefit;
    }

    public void setCIBenefit(String CIBenefit) {
        this.CIBenefit = CIBenefit;
    }

    public String getADHB() {
        return ADHB;
    }

    public void setADHB(String ADHB) {
        this.ADHB = ADHB;
    }

    public int getInsurerId() {
        return InsurerId;
    }

    public void setInsurerId(int InsurerId) {
        this.InsurerId = InsurerId;
    }

    public String getSessionID() {
        return SessionID;
    }

    public void setSessionID(String SessionID) {
        this.SessionID = SessionID;
    }

    public String getExisting_ProductInsuranceMapping_Id() {
        return Existing_ProductInsuranceMapping_Id;
    }

    public void setExisting_ProductInsuranceMapping_Id(String Existing_ProductInsuranceMapping_Id) {
        this.Existing_ProductInsuranceMapping_Id = Existing_ProductInsuranceMapping_Id;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String ContactName) {
        this.ContactName = ContactName;
    }

    public String getContactEmail() {
        return ContactEmail;
    }

    public void setContactEmail(String ContactEmail) {
        this.ContactEmail = ContactEmail;
    }

    public String getContactMobile() {
        return ContactMobile;
    }

    public void setContactMobile(String ContactMobile) {
        this.ContactMobile = ContactMobile;
    }

    public String getSupportsAgentID() {
        return SupportsAgentID;
    }

    public void setSupportsAgentID(String SupportsAgentID) {
        this.SupportsAgentID = SupportsAgentID;
    }
}

package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity;

public class UltralakshaRequestEntity {


    /**
     * PolicyTerm : 20
     * InsuredGender : F
     * Is_TabaccoUser : False
     * SumAssured : 10000000
     * InsuredDOB : 01-12-1980
     * ContactName : Mayuri Tikale
     * ContactEmail : mayuri.tikale@policyboss.com
     * ContactMobile : 9699579052
     * Frequency : Yearly
     */

    private int PolicyTerm;
    private String InsuredGender;
    private String Is_TabaccoUser;
    private int SumAssured;
    private String InsuredDOB;
    private String ContactName;
    private String ContactEmail;
    private String ContactMobile;
    private String Frequency;




    private int FBAID;

    public int getPolicyTerm() {
        return PolicyTerm;
    }

    public void setPolicyTerm(int PolicyTerm) {
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

    public int getSumAssured() {
        return SumAssured;
    }

    public void setSumAssured(int SumAssured) {
        this.SumAssured = SumAssured;
    }

    public String getInsuredDOB() {
        return InsuredDOB;
    }

    public void setInsuredDOB(String InsuredDOB) {
        this.InsuredDOB = InsuredDOB;
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

    public String getFrequency() {
        return Frequency;
    }

    public void setFrequency(String Frequency) {
        this.Frequency = Frequency;
    }

    public int getFBAID() {
        return FBAID;
    }

    public void setFBAID(int FBAID) {
        this.FBAID = FBAID;
    }
}

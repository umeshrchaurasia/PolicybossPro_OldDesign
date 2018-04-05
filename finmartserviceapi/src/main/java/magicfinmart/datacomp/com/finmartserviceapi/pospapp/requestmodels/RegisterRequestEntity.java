package magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels;

/**
 * Created by Rajeev Ranjan on 24/03/2017.
 */

public class RegisterRequestEntity {

    /**
     * ADHAR : String content
     * CategoryId : 2147483647
     * Email : String content
     * FBAId : 2147483647
     * FullName : String content
     * MobileNumber : 9223372036854775807
     * PAN : String content
     */

    private String ADHAR;
    private int CategoryId;
    private String Email;
    private int FBAId;
    private String FullName;
    private long MobileNumber;
    private String PAN;

    public String getADHAR() {
        return ADHAR;
    }

    public void setADHAR(String ADHAR) {
        this.ADHAR = ADHAR;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getFBAId() {
        return FBAId;
    }

    public void setFBAId(int FBAId) {
        this.FBAId = FBAId;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public long getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(long MobileNumber) {
        this.MobileNumber = MobileNumber;
    }

    public String getPAN() {
        return PAN;
    }

    public void setPAN(String PAN) {
        this.PAN = PAN;
    }
}

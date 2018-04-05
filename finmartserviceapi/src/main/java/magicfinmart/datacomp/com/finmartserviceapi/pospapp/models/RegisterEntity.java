package magicfinmart.datacomp.com.finmartserviceapi.pospapp.models;

public class RegisterEntity {
        /**
         * Category : Caller
         * CategoryId : 1
         * Email : rajeev@gmail.com
         * FullName : Rajeev Ranjan
         * MobileNumber : 9833112345
         * Password : 121212
         * UserId : 5
         */

        private String Category;
        private int CategoryId;
        private String Email;
        private String FullName;
        private long MobileNumber;
        private String Password;
        private int UserId;
    /**
     * ADHAR : 232323232
     * PAN : 12345678
     */

    private String ADHAR;
    private String PAN;
    /**
     * NoofAttempt : 2147483647
     */

    private int NoofAttempt;
    /**
     * FBAId : 2147483647
     */

    private int FBAId;
    /**
     * CurrentStudyTime : 9223372036854775807
     * IsLogin : true
     * TotalStudyTime : 9223372036854775807
     * UserPic : String content
     */

    private long CurrentStudyTime;
    private boolean IsLogin;
    private long TotalStudyTime;
    private String UserPic;

    public String getCategory() {
            return Category;
        }

        public void setCategory(String Category) {
            this.Category = Category;
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

        public String getPassword() {
            return Password;
        }

        public void setPassword(String Password) {
            this.Password = Password;
        }

        public int getUserId() {
            return UserId;
        }

        public void setUserId(int UserId) {
            this.UserId = UserId;
        }

    public String getADHAR() {
        return ADHAR;
    }

    public void setADHAR(String ADHAR) {
        this.ADHAR = ADHAR;
    }

    public String getPAN() {
        return PAN;
    }

    public void setPAN(String PAN) {
        this.PAN = PAN;
    }

    public int getNoofAttempt() {
        return NoofAttempt;
    }

    public void setNoofAttempt(int NoofAttempt) {
        this.NoofAttempt = NoofAttempt;
    }

    public int getFBAId() {
        return FBAId;
    }

    public void setFBAId(int FBAId) {
        this.FBAId = FBAId;
    }

    public long getCurrentStudyTime() {
        return CurrentStudyTime;
    }

    public void setCurrentStudyTime(long CurrentStudyTime) {
        this.CurrentStudyTime = CurrentStudyTime;
    }

    public boolean isIsLogin() {
        return IsLogin;
    }

    public void setIsLogin(boolean IsLogin) {
        this.IsLogin = IsLogin;
    }

    public long getTotalStudyTime() {
        return TotalStudyTime;
    }

    public void setTotalStudyTime(long TotalStudyTime) {
        this.TotalStudyTime = TotalStudyTime;
    }

    public String getUserPic() {
        return UserPic;
    }

    public void setUserPic(String UserPic) {
        this.UserPic = UserPic;
    }
}
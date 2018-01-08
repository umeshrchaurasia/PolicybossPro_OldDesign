package magicfinmart.datacomp.com.finmartserviceapi.requestmodel;

/**
 * Created by Nilesh Birhade on 05-01-2018.
 */

public class LoginRequest {


    /**
     * UserName : live@gmail.com
     * Password : iO7b9gPjVU2PsjWsA9NILg==
     * OldPassword : null
     * FBAId : 0
     * DeviceId : ffffffff-e77a-774f-162a-16fe162a16fe
     * DeviceOS :
     * DeviceName :
     * IpAdd : 02:00:00:00:00:00
     * LastLog :
     * EmailId :
     * TokenId :
     * MobileNo : 9930089092
     * UserType :
     * UserId : 0
     * VersionNo : 12
     * AppID : 124
     * AppUSERID : 98898788
     * AppPASSWORD : fgdfgg4554
     */

    private String UserName;
    private String Password;
    private Object OldPassword;
    private int FBAId;
    private String DeviceId;
    private String DeviceOS;
    private String DeviceName;
    private String IpAdd;
    private String LastLog;
    private String EmailId;
    private String TokenId;
    private long MobileNo;
    private String UserType;
    private int UserId;
    private int VersionNo;
    private int AppID;
    private int AppUSERID;
    private String AppPASSWORD;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Object getOldPassword() {
        return OldPassword;
    }

    public void setOldPassword(Object OldPassword) {
        this.OldPassword = OldPassword;
    }

    public int getFBAId() {
        return FBAId;
    }

    public void setFBAId(int FBAId) {
        this.FBAId = FBAId;
    }

    public String getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(String DeviceId) {
        this.DeviceId = DeviceId;
    }

    public String getDeviceOS() {
        return DeviceOS;
    }

    public void setDeviceOS(String DeviceOS) {
        this.DeviceOS = DeviceOS;
    }

    public String getDeviceName() {
        return DeviceName;
    }

    public void setDeviceName(String DeviceName) {
        this.DeviceName = DeviceName;
    }

    public String getIpAdd() {
        return IpAdd;
    }

    public void setIpAdd(String IpAdd) {
        this.IpAdd = IpAdd;
    }

    public String getLastLog() {
        return LastLog;
    }

    public void setLastLog(String LastLog) {
        this.LastLog = LastLog;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String EmailId) {
        this.EmailId = EmailId;
    }

    public String getTokenId() {
        return TokenId;
    }

    public void setTokenId(String TokenId) {
        this.TokenId = TokenId;
    }

    public long getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(long MobileNo) {
        this.MobileNo = MobileNo;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public int getVersionNo() {
        return VersionNo;
    }

    public void setVersionNo(int VersionNo) {
        this.VersionNo = VersionNo;
    }

    public int getAppID() {
        return AppID;
    }

    public void setAppID(int AppID) {
        this.AppID = AppID;
    }

    public int getAppUSERID() {
        return AppUSERID;
    }

    public void setAppUSERID(int AppUSERID) {
        this.AppUSERID = AppUSERID;
    }

    public String getAppPASSWORD() {
        return AppPASSWORD;
    }

    public void setAppPASSWORD(String AppPASSWORD) {
        this.AppPASSWORD = AppPASSWORD;
    }
}

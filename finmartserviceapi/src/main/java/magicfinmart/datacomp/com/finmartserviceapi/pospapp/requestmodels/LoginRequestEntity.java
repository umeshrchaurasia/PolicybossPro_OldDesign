package magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels;

/**
 * Created by Rajeev Ranjan on 24/03/2017.
 */

public class LoginRequestEntity {
    /**
     * DeviceId : 1212
     * DeviceToken : 1212
     * Email : vinit@gmail.com
     * Password : 123456
     */

    private String DeviceId;
    private String DeviceToken;
    private String Email;
    private String Password;
    /**
     * IP : String content
     */

    private String IP;
    /**
     * FBAId : 0
     */

    private int FBAId;

    public String getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(String DeviceId) {
        this.DeviceId = DeviceId;
    }

    public String getDeviceToken() {
        return DeviceToken;
    }

    public void setDeviceToken(String DeviceToken) {
        this.DeviceToken = DeviceToken;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public int getFBAId() {
        return FBAId;
    }

    public void setFBAId(int FBAId) {
        this.FBAId = FBAId;
    }
}

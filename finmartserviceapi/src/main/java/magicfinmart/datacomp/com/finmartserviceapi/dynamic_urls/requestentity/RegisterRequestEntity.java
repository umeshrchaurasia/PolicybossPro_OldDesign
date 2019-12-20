package magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.requestentity;

/**
 * Created by IN-RB on 15-03-2017.
 */

public class RegisterRequestEntity {


    /**
     * mobileno : 9820533646
     * name : shubhangi
     * password : 12345
     * lat : 19.0867
     * lng : 72.8889
     */

    private String uid;
    private String hrmsid;
    private String emailid;
    private String dept;

    private String mobileno;
    private String name;
    private String password;
    private String lat;
    private String lng;

    private String entrytype;
    private String DeviceId;
    private String DeviceToken;

    public String getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(String deviceId) {
        DeviceId = deviceId;
    }

    public String getDeviceToken() {
        return DeviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        DeviceToken = deviceToken;
    }



    public String getEntrytype() {
        return entrytype;
    }

    public void setEntrytype(String entrytype) {
        this.entrytype = entrytype;
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getHrmsid() {
        return hrmsid;
    }

    public void setHrmsid(String hrmsid) {
        this.hrmsid = hrmsid;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }


    public String getmobileno() {
        return mobileno;
    }

    public void setmobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}

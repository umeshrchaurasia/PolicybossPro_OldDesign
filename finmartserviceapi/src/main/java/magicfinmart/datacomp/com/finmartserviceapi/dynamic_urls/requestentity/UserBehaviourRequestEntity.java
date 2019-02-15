package magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.requestentity;

public class UserBehaviourRequestEntity {

    /**
     * bluetooth : ['test','test1','test3']
     * wifi : ['test','test1','test3']
     * installapps : ['test','test1','test3']
     * defaultlanguage : test
     */

    private String bluetooth;
    private String wifi;
    private String installapps;
    private String defaultlanguage;

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getInstallapps() {
        return installapps;
    }

    public void setInstallapps(String installapps) {
        this.installapps = installapps;
    }

    public String getDefaultlanguage() {
        return defaultlanguage;
    }

    public void setDefaultlanguage(String defaultlanguage) {
        this.defaultlanguage = defaultlanguage;
    }
}

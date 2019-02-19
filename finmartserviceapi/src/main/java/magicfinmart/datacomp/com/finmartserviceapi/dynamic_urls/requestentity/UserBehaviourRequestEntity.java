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
    private String fba_id;


    public String getFba_id() {
        return fba_id;
    }

    public void setFba_id(String fba_id) {
        this.fba_id = fba_id;
    }

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

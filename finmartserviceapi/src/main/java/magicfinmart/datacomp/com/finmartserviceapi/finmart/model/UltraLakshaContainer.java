package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import java.util.List;

public class UltraLakshaContainer {

    private List<HDFCEntity> HDFC;
    private List<LICEntity> LIC;

    public List<HDFCEntity> getHDFC() {
        return HDFC;
    }

    public void setHDFC(List<HDFCEntity> HDFC) {
        this.HDFC = HDFC;
    }

    public List<LICEntity> getLIC() {
        return LIC;
    }

    public void setLIC(List<LICEntity> LIC) {
        this.LIC = LIC;
    }
}
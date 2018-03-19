package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ConstantEntity extends RealmObject {
    /**
     * VersionCode : 0
     * IsForceUpdate : 0
     * PBNoOfHits : 5
     * PBHitTime : 6000
     * ROIHLBL : 8.3
     * ROIPLBL : 11.49
     * ROILABL : 8.75
     */
    @PrimaryKey
    private int VersionCode;
    private int IsForceUpdate;
    private int PBNoOfHits;
    private int PBHitTime;
    private double ROIHLBL;
    private double ROIPLBL;
    private double ROILABL;

    public int getVersionCode() {
        return VersionCode;
    }

    public void setVersionCode(int VersionCode) {
        this.VersionCode = VersionCode;
    }

    public int getIsForceUpdate() {
        return IsForceUpdate;
    }

    public void setIsForceUpdate(int IsForceUpdate) {
        this.IsForceUpdate = IsForceUpdate;
    }

    public int getPBNoOfHits() {
        return PBNoOfHits;
    }

    public void setPBNoOfHits(int PBNoOfHits) {
        this.PBNoOfHits = PBNoOfHits;
    }

    public int getPBHitTime() {
        return PBHitTime;
    }

    public void setPBHitTime(int PBHitTime) {
        this.PBHitTime = PBHitTime;
    }

    public double getROIHLBL() {
        return ROIHLBL;
    }

    public void setROIHLBL(double ROIHLBL) {
        this.ROIHLBL = ROIHLBL;
    }

    public double getROIPLBL() {
        return ROIPLBL;
    }

    public void setROIPLBL(double ROIPLBL) {
        this.ROIPLBL = ROIPLBL;
    }

    public double getROILABL() {
        return ROILABL;
    }

    public void setROILABL(double ROILABL) {
        this.ROILABL = ROILABL;
    }
}
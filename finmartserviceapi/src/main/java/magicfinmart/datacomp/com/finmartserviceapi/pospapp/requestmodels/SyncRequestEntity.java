package magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels;

/**
 * Created by Rajeev Ranjan on 03/05/2017.
 */

public class SyncRequestEntity {
    /**
     * CurrentStudyTime : 9223372036854775807
     * FBAId : 2147483647
     * ModuleNo : 2147483647
     * UserId : 2147483647
     */

    private long CurrentStudyTime;
    private int FBAId;
    private int ModuleNo;
    private int UserId;
    /**
     * checkstatus : String content
     */

    private String checkstatus;

    public long getCurrentStudyTime() {
        return CurrentStudyTime;
    }

    public void setCurrentStudyTime(long CurrentStudyTime) {
        this.CurrentStudyTime = CurrentStudyTime;
    }

    public int getFBAId() {
        return FBAId;
    }

    public void setFBAId(int FBAId) {
        this.FBAId = FBAId;
    }

    public int getModuleNo() {
        return ModuleNo;
    }

    public void setModuleNo(int ModuleNo) {
        this.ModuleNo = ModuleNo;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getCheckstatus() {
        return checkstatus;
    }

    public void setCheckstatus(String checkstatus) {
        this.checkstatus = checkstatus;
    }
}

package magicfinmart.datacomp.com.finmartserviceapi.pospapp.response;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.APIResponse;

/**
 * Created by Rajeev Ranjan on 03/05/2017.
 */

public class SyncTimeResponse extends APIResponse {

    /**
     * CurrentStudyTime : 9223372036854775807
     * TotalStudyTime : 9223372036854775807
     */

    private long CurrentStudyTime;
    private long TotalStudyTime;
    /**
     * IsEligible : true
     */

    private boolean IsEligible;
    /**
     * IsLogin : true
     */

    private boolean IsLogin;

    public long getCurrentStudyTime() {
        return CurrentStudyTime;
    }

    public void setCurrentStudyTime(long CurrentStudyTime) {
        this.CurrentStudyTime = CurrentStudyTime;
    }

    public long getTotalStudyTime() {
        return TotalStudyTime;
    }

    public void setTotalStudyTime(long TotalStudyTime) {
        this.TotalStudyTime = TotalStudyTime;
    }

    public boolean isIsEligible() {
        return IsEligible;
    }

    public void setIsEligible(boolean IsEligible) {
        this.IsEligible = IsEligible;
    }

    public boolean isIsLogin() {
        return IsLogin;
    }

    public void setIsLogin(boolean IsLogin) {
        this.IsLogin = IsLogin;
    }
}

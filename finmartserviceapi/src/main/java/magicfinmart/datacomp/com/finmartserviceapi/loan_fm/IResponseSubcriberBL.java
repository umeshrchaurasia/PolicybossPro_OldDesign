package magicfinmart.datacomp.com.finmartserviceapi.loan_fm;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponse;

/**
 * Created by IN-RB on 28-01-2018.
 */

public interface IResponseSubcriberBL {

    void OnSuccess(APIResponseBL response, String message);

    void OnFailure(Throwable t);
}

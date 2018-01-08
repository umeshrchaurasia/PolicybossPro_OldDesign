package magicfinmart.datacomp.com.finmartserviceapi.core;


import magicfinmart.datacomp.com.finmartserviceapi.core.APIResponse;

/**
 * Created by Nilesh Birhade on 17-10-2016.
 */

public interface IResponseSubcriber {

    void OnSuccess(APIResponse response, String message);

    void OnFailure(Throwable t);
}

package magicfinmart.datacomp.com.finmartserviceapi.pospapp;

/**
 * Created by Rajeev Ranjan on 21/03/2017.
 */
public interface IResponseSubcriber {

    void OnSuccess(APIResponse response, String message) throws InterruptedException;

    void OnFailure(Throwable t);
}
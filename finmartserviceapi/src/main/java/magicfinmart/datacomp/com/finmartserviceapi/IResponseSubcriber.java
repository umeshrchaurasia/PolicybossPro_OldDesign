package magicfinmart.datacomp.com.finmartserviceapi;




/**
 * Created by Nilesh Birhade on 17-10-2016.
 */

public interface IResponseSubcriber {

    void OnSuccess(APIResponse response, String message);

    void OnFailure(Throwable t);
}

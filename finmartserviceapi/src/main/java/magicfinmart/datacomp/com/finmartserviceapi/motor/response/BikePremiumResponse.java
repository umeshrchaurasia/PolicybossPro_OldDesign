package magicfinmart.datacomp.com.finmartserviceapi.motor.response;


import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.motor.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.motor.model.ResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.motor.model.SummaryEntity;

/**
 * Created by Nilesh Birhade on 15-11-2017.
 */

public class BikePremiumResponse extends APIResponse {

    private SummaryEntity Summary;
    private List<ResponseEntity> Response;

    public SummaryEntity getSummary() {
        return Summary;
    }

    public void setSummary(SummaryEntity Summary) {
        this.Summary = Summary;
    }

    public List<ResponseEntity> getResponse() {
        return Response;
    }

    public void setResponse(List<ResponseEntity> Response) {
        this.Response = Response;
    }


}

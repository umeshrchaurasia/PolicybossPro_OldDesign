package magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.submit;


import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.SubmitRequestEntity;

/**
 * Created by Rajeev Ranjan on 03/04/2017.
 */

public interface ISubmit {
    public void submitAnswer(SubmitRequestEntity submitRequestEntity, IResponseSubcriber iResponseSubcriber);
}

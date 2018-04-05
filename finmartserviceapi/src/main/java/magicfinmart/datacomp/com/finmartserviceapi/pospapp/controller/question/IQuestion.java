package magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.question;


import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;

/**
 * Created by Rajeev Ranjan on 24/03/2017.
 */

public interface IQuestion {
    void getQuestion(int CategoryId, int UserId, IResponseSubcriber iResponseSubcriber);
}

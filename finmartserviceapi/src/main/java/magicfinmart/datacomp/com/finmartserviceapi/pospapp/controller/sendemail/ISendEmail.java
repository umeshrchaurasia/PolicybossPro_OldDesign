package magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.sendemail;


import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;

/**
 * Created by Rajeev Ranjan on 27/04/2017.
 */

public interface ISendEmail {
    void sendEmail(String Email, String UserName, IResponseSubcriber iResponseSubcriber);
}

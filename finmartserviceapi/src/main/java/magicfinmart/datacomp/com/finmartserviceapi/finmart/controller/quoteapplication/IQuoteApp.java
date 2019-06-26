package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.quoteapplication;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MotorMyLeadEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.QuoteListEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.SaveMotorRequestEntity;

/**
 * Created by Nilesh Birhade on 25-01-2018.
 */

public interface IQuoteApp {


    void getQuoteAppList(int count, int type, String firstname, String vehicleReqID, int fbaID, int productID, String crn, IResponseSubcriber iResponseSubcriber);

    void saveQuote(SaveMotorRequestEntity entity, IResponseSubcriber iResponseSubcriber);

    void convertQuoteToApp(String vehicleRequestID, String selectedPrevInsID, String insImage, IResponseSubcriber iResponseSubcriber);

    void deleteQuote(String vehicleRequestID, IResponseSubcriber iResponseSubcriber);

    void ModifyLead(MotorMyLeadEntity entity, IResponseSubcriber iResponseSubcriber);

    void ViewLead(String VehicleRequestID, String LeadId, IResponseSubcriber iResponseSubcriber);

    void EditLead(String VehicleRequestID, String LeadId, IResponseSubcriber iResponseSubcriber);

    void getLeadDispositionMaster(IResponseSubcriber iResponseSubcriber);

    void saveLeadDisposition(String leadid, String dispositionid, String vehiclerequestid, String comment, IResponseSubcriber iResponseSubcriber);


    void getBOFbaList(String fbaID, String searchKeyWord, IResponseSubcriber iResponseSubcriber);

}

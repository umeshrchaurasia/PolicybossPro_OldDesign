package magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.modulepractice;


import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.SyncRequestEntity;

/**
 * Created by Rajeev Ranjan on 17/04/2017.
 */

public interface IModulePractice {
    void getModuleQuestion(int ModuleNo, int CategoryId, int UserId, IResponseSubcriber iResponseSubcriber);

    void getSyncTime(SyncRequestEntity syncRequestEntity, IResponseSubcriber iResponseSubcriber);
}

package magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.register;


import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.RegisterRequestEntity;

/**
 * Created by Rajeev Ranjan on 24/03/2017.
 */

public interface IRegister {
    void register(RegisterRequestEntity registerRequestEntity, IResponseSubcriber iResponseSubcriber);
}

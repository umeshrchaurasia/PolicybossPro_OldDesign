package magicfinmart.datacomp.com.finmartserviceapi.motor.controller;


import magicfinmart.datacomp.com.finmartserviceapi.motor.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.motor.requestentity.BikeRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.motor.requestentity.SaveAddOnRequestEntity;

/**
 * Created by Nilesh Birhade on 11-01-2018.
 */

public interface IMotor {

    void getMotorPremiumInitiate(BikeRequestEntity entity, IResponseSubcriber iResponseSubcriber);

    void getMotorQuote(int product, IResponseSubcriber iResponseSubcriber);

    void saveAddOn(SaveAddOnRequestEntity saveAddOnRequestEntity, IResponseSubcriber iResponseSubcriber);
}

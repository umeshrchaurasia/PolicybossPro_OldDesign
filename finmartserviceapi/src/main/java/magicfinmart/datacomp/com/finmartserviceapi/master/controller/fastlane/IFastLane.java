package magicfinmart.datacomp.com.finmartserviceapi.master.controller.fastlane;


import magicfinmart.datacomp.com.finmartserviceapi.motor.IResponseSubcriber;

/**
 * Created by Rajeev Ranjan on 17/01/2018.
 */

public interface IFastLane {
    void getFastLaneData(String vehicle, IResponseSubcriber iResponseSubcriber);
}

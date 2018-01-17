package magicfinmart.datacomp.com.finmartserviceapi.master.controller;


import magicfinmart.datacomp.com.finmartserviceapi.master.IResponseSubcriber;

/**
 * Created by Nilesh Birhade on 29-11-2017.
 */

public interface IMasterFetch {

    public void getCarMaster(IResponseSubcriber iResponseSubcriber);

    public void getBikeMaster(IResponseSubcriber iResponseSubcriber);

    public void getRTOMaster(IResponseSubcriber iResponseSubcriber);

}

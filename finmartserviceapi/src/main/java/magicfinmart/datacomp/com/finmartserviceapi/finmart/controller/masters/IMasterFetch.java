package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.masters;


import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;

/**
 * Created by Nilesh Birhade on 29-11-2017.
 */

public interface IMasterFetch {

    public void getCarMaster(IResponseSubcriber iResponseSubcriber);

    public void getBikeMaster(IResponseSubcriber iResponseSubcriber);

    public void getRTOMaster(IResponseSubcriber iResponseSubcriber);

    public void getInsuranceMaster(IResponseSubcriber iResponseSubcriber);

    public void getContactList(IResponseSubcriber iResponseSubcriber);

}

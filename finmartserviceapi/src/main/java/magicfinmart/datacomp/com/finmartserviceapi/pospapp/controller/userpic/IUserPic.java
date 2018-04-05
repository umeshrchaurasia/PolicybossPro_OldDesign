package magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.userpic;


import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;

/**
 * Created by Rajeev Ranjan on 06/04/2017.
 */

public interface IUserPic {
    public void uploadPic(String ImgString, int UserId, IResponseSubcriber iResponseSubcriber);
}

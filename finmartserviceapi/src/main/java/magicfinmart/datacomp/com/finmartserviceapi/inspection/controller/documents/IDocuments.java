package magicfinmart.datacomp.com.finmartserviceapi.inspection.controller.documents;

import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.inspection.IResponseSubcribe;
import magicfinmart.datacomp.com.finmartserviceapi.inspection.entity.VehSelfDeclarationEntity;
import okhttp3.MultipartBody;

/**
 * Created by Nilesh Birhade on 14-12-2017.
 */

public interface IDocuments {

    void uploadDocuments(MultipartBody.Part document, HashMap<String, String> body, final IResponseSubcribe iResponseSubcriber);

    void uploadVideo(MultipartBody.Part video, HashMap<String, String> body, final IResponseSubcribe iResponseSubcriber);

    void selfDeclaration(VehSelfDeclarationEntity selfDeclarationEntity, IResponseSubcribe iResponseSubcriber);
}

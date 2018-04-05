package magicfinmart.datacomp.com.finmartserviceapi.pospapp.response;


import magicfinmart.datacomp.com.finmartserviceapi.pospapp.APIResponse;

/**
 * Created by Rajeev Ranjan on 15/05/2017.
 */

public class CertificateResponse extends APIResponse {
    /**
     * PdfPath : String content
     */

    private String PdfPath;

    public String getPdfPath() {
        return PdfPath;
    }

    public void setPdfPath(String PdfPath) {
        this.PdfPath = PdfPath;
    }
}

package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import java.util.List;

public class UploadMotorEntity {
    /**
     * TransId : 4
     * RequestId : 4
     * SavedStatus : 0
     * Document : [{"docname":"Last year policy copy","docpath":"OfflineDoc/87/1544620796437.jpg","id":"58"},{"docname":"RC copy","docpath":"","id":""},{"docname":"Other 1","docpath":"","id":""},{"docname":"Other 2","docpath":"","id":""}]
     */

    private String TransId;
    private int RequestId;
    private int SavedStatus;
    private List<DocumentEntity> Document;

    public String getTransId() {
        return TransId;
    }

    public void setTransId(String TransId) {
        this.TransId = TransId;
    }

    public int getRequestId() {
        return RequestId;
    }

    public void setRequestId(int RequestId) {
        this.RequestId = RequestId;
    }

    public int getSavedStatus() {
        return SavedStatus;
    }

    public void setSavedStatus(int SavedStatus) {
        this.SavedStatus = SavedStatus;
    }

    public List<DocumentEntity> getDocument() {
        return Document;
    }

    public void setDocument(List<DocumentEntity> Document) {
        this.Document = Document;
    }


}
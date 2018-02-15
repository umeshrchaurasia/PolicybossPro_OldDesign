package magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model;

import java.util.List;

public class LstPackParameterEntity {
    /**
     * Name : CBC
     * ParamDetails : ["Basophils","Eosinophils","Hematocrit (Hct)","Hemoglobin (Hbg)","Lymphocytes","Mean corpuscular hemoglobin (MCH)","Mean corpuscular hemoglobin concentration","Mean corpuscular volume (MCV)","Mean Platelet Volume (MPV)","Monocytes","Neutrophils","Platelet count","Platelet Distribution Width","RBC","Red Blood Cell Count","Red cell distribution width (RDW)","WBC","White blood cell count (WBC or leukocyte count)"]
     */

    private String Name;
    private List<String> ParamDetails;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public List<String> getParamDetails() {
        return ParamDetails;
    }

    public void setParamDetails(List<String> ParamDetails) {
        this.ParamDetails = ParamDetails;
    }
}
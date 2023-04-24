package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response;


import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.EmiCalcuatorEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponse;

public class EmiCalculatorResponse  extends APIResponse {
    private EmiCalcuatorEntity data;
    private String err;

    public EmiCalcuatorEntity getData() {
        return data;
    }

    public void setData(EmiCalcuatorEntity data) {
        this.data = data;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
}

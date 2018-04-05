package magicfinmart.datacomp.com.finmartserviceapi.pospapp.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.models.PracticeModuleEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.APIResponse;

/**
 * Created by Rajeev Ranjan on 17/04/2017.
 */

public class ModulePracticeResponse extends APIResponse {

    /**
     * ModuleNo : 2147483647
     * PassMarks : 2147483647
     * QuestionSet : [{"CategoryId":2147483647,"CategoryName":"String content","CorrectAnswer":"String content","Marks":2147483647,"OptionA":"String content","OptionB":"String content","OptionC":"String content","OptionD":"String content","Question":"String content","QuestionId":2147483647}]
     * TotalMarks : 2147483647
     * TotalTime : 2147483647
     */

    private int ModuleNo;
    private int PassMarks;
    private int TotalMarks;
    private int TotalTime;
    private List<PracticeModuleEntity> QuestionSet;

    public int getModuleNo() {
        return ModuleNo;
    }

    public void setModuleNo(int ModuleNo) {
        this.ModuleNo = ModuleNo;
    }

    public int getPassMarks() {
        return PassMarks;
    }

    public void setPassMarks(int PassMarks) {
        this.PassMarks = PassMarks;
    }

    public int getTotalMarks() {
        return TotalMarks;
    }

    public void setTotalMarks(int TotalMarks) {
        this.TotalMarks = TotalMarks;
    }

    public int getTotalTime() {
        return TotalTime;
    }

    public void setTotalTime(int TotalTime) {
        this.TotalTime = TotalTime;
    }

    public List<PracticeModuleEntity> getQuestionSet() {
        return QuestionSet;
    }

    public void setQuestionSet(List<PracticeModuleEntity> QuestionSet) {
        this.QuestionSet = QuestionSet;
    }


}

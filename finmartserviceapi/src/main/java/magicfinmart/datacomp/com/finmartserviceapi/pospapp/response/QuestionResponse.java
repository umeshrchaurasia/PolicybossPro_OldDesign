package magicfinmart.datacomp.com.finmartserviceapi.pospapp.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.models.QuestionEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.APIResponse;

/**
 * Created by Rajeev Ranjan on 24/03/2017.
 */

public class QuestionResponse extends APIResponse {


    /**
     * IsAttempted : false
     * QuestionSet : [{"CategoryId":2,"CategoryName":"Marketing","CorrectAnswer":"D","LevelId":1,"LevelName":"Beginners","Marks":1,"OptionA":"3","OptionB":"7","OptionC":"8","OptionD":"4","Question":" 2 + 2???","QuestionId":21,"QuestionSetId":17,"UniqueQuestionSetId":"UQS17"},{"CategoryId":2,"CategoryName":"Marketing","CorrectAnswer":"A","LevelId":2,"LevelName":"Easy","Marks":2,"OptionA":"2000","OptionB":"2001","OptionC":"2340","OptionD":"5000","Question":"1000 + 1000 = ???","QuestionId":15,"QuestionSetId":17,"UniqueQuestionSetId":"UQS17"},{"CategoryId":2,"CategoryName":"Marketing","CorrectAnswer":"B","LevelId":2,"LevelName":"Easy","Marks":2,"OptionA":"Current liabilities","OptionB":"Fixed liabilities","OptionC":"Contingent liabilities","OptionD":"All of the above","Question":" The liabilities that are payable in more than a year and are not be liquidated from current assets","QuestionId":17,"QuestionSetId":17,"UniqueQuestionSetId":"UQS17"},{"CategoryId":2,"CategoryName":"Marketing","CorrectAnswer":"A","LevelId":3,"LevelName":"Medium","Marks":3,"OptionA":"A","OptionB":"B","OptionC":"C","OptionD":"D","Question":" ABBCD???","QuestionId":7,"QuestionSetId":17,"UniqueQuestionSetId":"UQS17"},{"CategoryId":2,"CategoryName":"Marketing","CorrectAnswer":"B","LevelId":3,"LevelName":"Medium","Marks":3,"OptionA":"12","OptionB":"10","OptionC":"11","OptionD":"9","Question":" 5 + 5 = ?","QuestionId":13,"QuestionSetId":17,"UniqueQuestionSetId":"UQS17"},{"CategoryId":2,"CategoryName":"Marketing","CorrectAnswer":"B","LevelId":4,"LevelName":"Hard","Marks":4,"OptionA":"Mumbai","OptionB":"Delhi","OptionC":"Punjab","OptionD":"Kolkata","Question":" Capital Of India?","QuestionId":20,"QuestionSetId":17,"UniqueQuestionSetId":"UQS17"}]
     * TotalMarks : 15
     * TotalTime : 30
     */

    private boolean IsAttempted;
    private int TotalMarks;
    private int TotalTime;
    private List<QuestionEntity> QuestionSet;
    /**
     * PassMarks : 2147483647
     */

    private int PassMarks;

    public boolean isIsAttempted() {
        return IsAttempted;
    }

    public void setIsAttempted(boolean IsAttempted) {
        this.IsAttempted = IsAttempted;
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

    public List<QuestionEntity> getQuestionSet() {
        return QuestionSet;
    }

    public void setQuestionSet(List<QuestionEntity> QuestionSet) {
        this.QuestionSet = QuestionSet;
    }

    public int getPassMarks() {
        return PassMarks;
    }

    public void setPassMarks(int PassMarks) {
        this.PassMarks = PassMarks;
    }
}

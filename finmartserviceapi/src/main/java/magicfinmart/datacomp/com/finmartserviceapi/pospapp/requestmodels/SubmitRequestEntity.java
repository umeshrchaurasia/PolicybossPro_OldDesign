package magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels;

import java.util.List;

/**
 * Created by Rajeev Ranjan on 03/04/2017.
 */

public class SubmitRequestEntity {

    /**
     * AnswerSet : [{"CategoryId":2147483647,"CategoryName":"String content","CorrectAnswer":"String content","LevelId":2147483647,"LevelName":"String content","Marks":2147483647,"OptionA":"String content","OptionB":"String content","OptionC":"String content","OptionD":"String content","Question":"String content","QuestionId":2147483647,"QuestionSetId":2147483647,"UniqueQuestionSetId":"String content","userInput":"String content"}]
     * QuestionSetId : 2147483647
     * UniqueQuestionSetId : String content
     * UserId : 2147483647
     * examTime : 2147483647
     * faceAway : 2147483647
     * faceFront : 2147483647
     * faceLeft : 2147483647
     * faceRight : 2147483647
     * marksObtained : 2147483647
     * totalMarks : 2147483647
     */
    private int QuestionSetId;
    private String UniqueQuestionSetId;
    private int UserId;
    private int examTime;
    private int faceAway;
    private int faceFront;
    private int faceLeft;
    private int faceRight;
    private int marksObtained;
    private int totalMarks;
    private List<AnswerSet> AnswerSet;
    /**
     * PassMarks : 2147483647
     */

    private int PassMarks;
    /**
     * FBAId : 2147483647
     */

    private int FBAId;

    public int getQuestionSetId() {
        return QuestionSetId;
    }

    public void setQuestionSetId(int QuestionSetId) {
        this.QuestionSetId = QuestionSetId;
    }

    public String getUniqueQuestionSetId() {
        return UniqueQuestionSetId;
    }

    public void setUniqueQuestionSetId(String UniqueQuestionSetId) {
        this.UniqueQuestionSetId = UniqueQuestionSetId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public int getExamTime() {
        return examTime;
    }

    public void setExamTime(int examTime) {
        this.examTime = examTime;
    }

    public int getFaceAway() {
        return faceAway;
    }

    public void setFaceAway(int faceAway) {
        this.faceAway = faceAway;
    }

    public int getFaceFront() {
        return faceFront;
    }

    public void setFaceFront(int faceFront) {
        this.faceFront = faceFront;
    }

    public int getFaceLeft() {
        return faceLeft;
    }

    public void setFaceLeft(int faceLeft) {
        this.faceLeft = faceLeft;
    }

    public int getFaceRight() {
        return faceRight;
    }

    public void setFaceRight(int faceRight) {
        this.faceRight = faceRight;
    }

    public int getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(int marksObtained) {
        this.marksObtained = marksObtained;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public List<AnswerSet> getAnswerSet() {
        return AnswerSet;
    }

    public void setAnswerSet(List<AnswerSet> AnswerSet) {
        this.AnswerSet = AnswerSet;
    }

    public int getPassMarks() {
        return PassMarks;
    }

    public void setPassMarks(int PassMarks) {
        this.PassMarks = PassMarks;
    }

    public int getFBAId() {
        return FBAId;
    }

    public void setFBAId(int FBAId) {
        this.FBAId = FBAId;
    }
}

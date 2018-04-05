package magicfinmart.datacomp.com.finmartserviceapi.pospapp.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rajeev Ranjan on 23/03/2017.
 */

public class QuestionEntity implements Parcelable {

    /**
     * CategoryId : 2
     * CategoryName : Marketing
     * CorrectAnswer : B
     * LevelId : 4
     * LevelName : Hard
     * Marks : 4
     * OptionA : Mumbai
     * OptionB : Delhi
     * OptionC : Punjab
     * OptionD : Kolkata
     * Question :  Capital Of India?
     * QuestionId : 20
     * QuestionSetId : 17
     * UniqueQuestionSetId : UQS17
     */

    private int CategoryId;
    private String CategoryName;
    private String CorrectAnswer;
    private int LevelId;
    private String LevelName;
    private int Marks;
    private String OptionA;
    private String OptionB;
    private String OptionC;
    private String OptionD;
    private String Question;
    private int QuestionId;
    private int QuestionSetId;
    private String UniqueQuestionSetId;

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(String CorrectAnswer) {
        this.CorrectAnswer = CorrectAnswer;
    }

    public int getLevelId() {
        return LevelId;
    }

    public void setLevelId(int LevelId) {
        this.LevelId = LevelId;
    }

    public String getLevelName() {
        return LevelName;
    }

    public void setLevelName(String LevelName) {
        this.LevelName = LevelName;
    }

    public int getMarks() {
        return Marks;
    }

    public void setMarks(int Marks) {
        this.Marks = Marks;
    }

    public String getOptionA() {
        return OptionA;
    }

    public void setOptionA(String OptionA) {
        this.OptionA = OptionA;
    }

    public String getOptionB() {
        return OptionB;
    }

    public void setOptionB(String OptionB) {
        this.OptionB = OptionB;
    }

    public String getOptionC() {
        return OptionC;
    }

    public void setOptionC(String OptionC) {
        this.OptionC = OptionC;
    }

    public String getOptionD() {
        return OptionD;
    }

    public void setOptionD(String OptionD) {
        this.OptionD = OptionD;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public int getQuestionId() {
        return QuestionId;
    }

    public void setQuestionId(int QuestionId) {
        this.QuestionId = QuestionId;
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.CategoryId);
        dest.writeString(this.CategoryName);
        dest.writeString(this.CorrectAnswer);
        dest.writeInt(this.LevelId);
        dest.writeString(this.LevelName);
        dest.writeInt(this.Marks);
        dest.writeString(this.OptionA);
        dest.writeString(this.OptionB);
        dest.writeString(this.OptionC);
        dest.writeString(this.OptionD);
        dest.writeString(this.Question);
        dest.writeInt(this.QuestionId);
        dest.writeInt(this.QuestionSetId);
        dest.writeString(this.UniqueQuestionSetId);
    }

    public QuestionEntity() {
    }

    protected QuestionEntity(Parcel in) {
        this.CategoryId = in.readInt();
        this.CategoryName = in.readString();
        this.CorrectAnswer = in.readString();
        this.LevelId = in.readInt();
        this.LevelName = in.readString();
        this.Marks = in.readInt();
        this.OptionA = in.readString();
        this.OptionB = in.readString();
        this.OptionC = in.readString();
        this.OptionD = in.readString();
        this.Question = in.readString();
        this.QuestionId = in.readInt();
        this.QuestionSetId = in.readInt();
        this.UniqueQuestionSetId = in.readString();
    }

    public static final Creator<QuestionEntity> CREATOR = new Creator<QuestionEntity>() {
        @Override
        public QuestionEntity createFromParcel(Parcel source) {
            return new QuestionEntity(source);
        }

        @Override
        public QuestionEntity[] newArray(int size) {
            return new QuestionEntity[size];
        }
    };
}

package magicfinmart.datacomp.com.finmartserviceapi.pospapp.models;

/**
 * Created by Rajeev Ranjan on 18/04/2017.
 */

public class PracticeModuleEntity {
    public int getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(int selectedOption) {
        this.selectedOption = selectedOption;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    /**
     * CategoryId : 2147483647
     * CategoryName : String content
     * CorrectAnswer : String content
     * Marks : 2147483647
     * OptionA : String content
     * OptionB : String content
     * OptionC : String content
     * OptionD : String content
     * Question : String content
     * QuestionId : 2147483647
     */
    private int selectedOption;
    private String userInput;
    private int CategoryId;
    private String CategoryName;
    private String CorrectAnswer;
    private int Marks;
    private String OptionA;
    private String OptionB;
    private String OptionC;
    private String OptionD;
    private String Question;
    private int QuestionId;

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
}

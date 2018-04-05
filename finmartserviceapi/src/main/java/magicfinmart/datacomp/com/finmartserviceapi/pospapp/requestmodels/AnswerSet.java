package magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels;

public class AnswerSet {
    public AnswerSet() {
        this.selectedOption = 0;
        CategoryId = 0;
        CategoryName = "";
        CorrectAnswer = "";
        LevelId = 0;
        LevelName = "";
        Marks = 0;
        OptionA = "";
        OptionB = "";
        OptionC = "";
        OptionD = "";
        Question = "";
        QuestionId = 0;
        QuestionSetId = 0;
        UniqueQuestionSetId = "";
        this.userInput = "";
    }

    /**
     * CategoryId : 2147483647
     * CategoryName : String content
     * CorrectAnswer : String content
     * LevelId : 2147483647
     * LevelName : String content
     * <p>
     * Marks : 2147483647
     * OptionA : String content
     * OptionB : String content
     * OptionC : String content
     * OptionD : String content
     * Question : String content
     * QuestionId : 2147483647
     * QuestionSetId : 2147483647
     * UniqueQuestionSetId : String content
     * userInput : String content
     */
    private int selectedOption;
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
    private String userInput;


    public int getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(int selectedOption) {
        this.selectedOption = selectedOption;
    }

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

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }
}
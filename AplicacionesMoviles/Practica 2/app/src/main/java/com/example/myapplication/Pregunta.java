package com.example.myapplication;

@Entity(tableName = "quizQuestion")
public class Pregunta {

    //Clave primaria
    @PrimaryKey
    @NonNull
    private String questionID;

    //Columnas
    @ColumnInfo(name = "question")
    private String question;
    @ColumnInfo(name = "ans0")
    private String answer0;
    @ColumnInfo(name = "ans1")
    private String answer1;
    @ColumnInfo(name = "ans2")
    private String answer2;
    @ColumnInfo(name = "ans3")
    private String answer3;

    public Pregunta(String questID, String quest, String ans0, String ans1, String ans2, String ans3) {
        questionID = questID;
        question = quest;
        answer0 = ans0;
        answer1 = ans1;
        answer2 = ans2;
        answer3 = ans3;
    }

    public String getQuestionID() {
        return questionID;
    }
    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getAnswer0() {
        return answer0;
    }
    public void setAnswer0(String answer0) {
        this.answer0 = answer0;
    }
    public String getAnswer1() {
        return answer1;
    }
    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }
    public String getAnswer2() {
        return answer2;
    }
    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }
    public String getAnswer3() {
        return answer3;
    }
    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }
}
package crabster.rudakov.quiz;

public class Question {

    private int question;
    private boolean answer;
    private int image;

    public Question(int question, boolean answer, int image) {
        this.question = question;
        this.answer = answer;
        this.image = image;
    }

    public int getQuestion() {
        return question;
    }

    public boolean isAnswer() {
        return answer;
    }

    public int getImage() {
        return image;
    }

}

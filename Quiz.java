public class Quiz {

    private String question;
    private boolean answer;

    public Quiz(String question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return this.question;
    }

    public boolean getAnswer() {
        return this.answer;
    }

}
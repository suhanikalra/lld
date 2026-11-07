package stackoverflow.entities;

import java.util.ArrayList;
import java.util.List;

public class StackOverFlow {
    private List<stackoverflow.entities.User> users = new ArrayList<>();
    private List<stackoverflow.entities.Question> questions = new ArrayList<>();

    public StackOverFlow() {

    }
    public void addQuestion(stackoverflow.entities.Question question){
        this.questions.add(question);
        question.getAuthor().addQuestion(question);
    }
    public List<stackoverflow.entities.Question> getQuestions() {
        return questions;
    }
    public void addAnswer(stackoverflow.entities.Question question, stackoverflow.entities.Answer answer, stackoverflow.entities.User user) {
        question.addAnswer(answer);
        user.addAnswer(answer);
    }

}
package stackoverflow.entities;

import stackoverflow.observer.Observer;

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
    public void addAnswer(Question question, Answer answer, User user) {
        question.addAnswer(answer);
        user.addAnswer(answer);

        for (Observer observer : observers) {
            observer.onAnswerPosted(question, answer);
        }
    }
    private List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

}
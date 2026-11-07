package stackoverflow.observer;

import stackoverflow.entities.Answer;
import stackoverflow.entities.Question;

public interface Observer {
    void onAnswerPosted(Question question, Answer answer);
}
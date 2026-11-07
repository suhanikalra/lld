package stackoverflow.observer;

import stackoverflow.entities.Answer;
import stackoverflow.entities.Question;
import stackoverflow.entities.User;

public class NotificationService implements Observer{

    @Override
    public void onAnswerPosted(Question question, Answer answer) {
        User questionAuthor = question.getAuthor();

        System.out.println(
                "Notification for " + questionAuthor.getUserName()
                        + ": Your question received a new answer!"
        );

    }
}

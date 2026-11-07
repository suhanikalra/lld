package stackoverflow;

import stackoverflow.entities.*;
import stackoverflow.observer.NotificationService;
import stackoverflow.service.VotingService;

public class Main {

    public static void main(String[] args) {

        StackOverFlow stackOverFlow = new StackOverFlow();

        // Create users
        User suhani = new User("Suhani");
        User vipul = new User("Vipul");

        // Register observer
        NotificationService notificationService = new NotificationService();
        stackOverFlow.registerObserver(notificationService);

        // Create question
        Question question = new Question(
                "What is Java?",
                "Can someone explain Java?",
                suhani
        );

        stackOverFlow.addQuestion(question);

        // Create answer
        Answer answer = new Answer(
                "Java is an object-oriented programming language.",
                vipul
        );

        // Post answer - should trigger notification
        stackOverFlow.addAnswer(question, answer, vipul);

        // Test voting
        VotingService votingService = new VotingService();
        votingService.vote(answer, suhani);

        // Print results
        System.out.println("Question count: " + stackOverFlow.getQuestions().size());
        System.out.println("Answer count: " + question.getAnswers().size());
        System.out.println("Answer author: " + answer.getAuthor().getUserName());
        System.out.println("Vipul's reputation: " + vipul.getReputation());
    }
}
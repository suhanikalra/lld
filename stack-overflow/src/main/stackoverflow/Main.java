package stackoverflow;

import stackoverflow.entities.*;
import stackoverflow.entities.Answer;
import stackoverflow.entities.Question;
import stackoverflow.entities.StackOverFlow;
import stackoverflow.entities.User;

public class Main {
    public static void main(String[] args) {

        StackOverFlow stackOverFlow = new StackOverFlow();

        // Create users
        User suhani = new User("Suhani");
        User vipul = new User("Vipul");

        // Create a question
        Question question = new Question(
                "What is Java?",
                "Can someone explain Java and its main features?",
                suhani
        );

        // Add question
        stackOverFlow.addQuestion(question);

        // Create an answer
        Answer answer = new Answer(
                "Java is an object-oriented programming language.",
                vipul
        );

        // Add answer
        stackOverFlow.addAnswer(question, answer, vipul);

        // Display question
        for (Question q : stackOverFlow.getQuestions()) {
            System.out.println("Question: " + q.getTitle());
            System.out.println("Asked by: " + q.getAuthor().getUserName());

            for (Answer a : q.getAnswers()) {
                System.out.println("Answer: " + a.getContent());
                System.out.println("Answered by: " + a.getAuthor().getUserName());
            }
        }
    }
}
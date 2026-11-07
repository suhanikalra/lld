package stackoverflow.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private String userId;
    private String userName;
    private int reputation;
    private List<stackoverflow.entities.Question> questions;
    private List<stackoverflow.entities.Answer> answers;
    private List<stackoverflow.entities.Vote> votes;

    public int getReputation() {
        int total = 0;

        for (int i = 0; i < this.votes.size(); i++) {
            total += this.votes.get(i).getValue();
        }

        return total;
    }
    public void addVote(stackoverflow.entities.Vote vote) {
        this.votes.add(vote);
    }

    public String getUserName() {
        return userName;
    }

    public List<stackoverflow.entities.Answer> getAnswers() {
        return answers;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<stackoverflow.entities.Question> getQuestions() {
        return questions;
    }

    public User( String userName) {
        this.userId = String.valueOf(UUID.randomUUID());
        this.userName = userName;
        this.reputation = 0;
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.votes = new ArrayList<>();
    }

    public void addQuestion(stackoverflow.entities.Question question){
        this.questions.add(question);
    }
    public void addAnswer(stackoverflow.entities.Answer answer){
        this.answers.add(answer);
    }
    public String getUserId() {
        return userId;
    }


}
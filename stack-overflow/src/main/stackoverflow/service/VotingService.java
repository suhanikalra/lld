package stackoverflow.service;

import stackoverflow.entities.Answer;
import stackoverflow.entities.Question;
import stackoverflow.entities.User;
import stackoverflow.entities.Vote;

public class VotingService implements Voting {

    @Override
    public void vote(Answer answer, User user) {
        Vote vote = new Vote(1, user);

        answer.addVote(vote);
        answer.getAuthor().addVote(vote);
    }


}
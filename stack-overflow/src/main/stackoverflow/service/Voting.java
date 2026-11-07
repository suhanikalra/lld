package stackoverflow.service;

import stackoverflow.entities.User;

public interface Voting {
    public void vote(stackoverflow.entities.Answer answer, User user);


}


package stackoverflow.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Comment {
    private UUID id;
    private String content;
    private stackoverflow.entities.User author;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public stackoverflow.entities.User getAuthor() {
        return author;
    }

    public List<stackoverflow.entities.Vote> getVote() {
        return vote;
    }

    public UUID getId() {
        return id;
    }

    public void setAuthor(stackoverflow.entities.User author) {
        this.author = author;
    }
    public void addVote(stackoverflow.entities.Vote vote){
        this.vote.add(vote);
    }
    public void removeVote(stackoverflow.entities.Vote vote){
        if(vote==null){
            throw new IllegalArgumentException();
        }
        if(!this.vote.contains(vote)){throw new IllegalArgumentException(); }
        this.vote.remove(vote);
    }

    private LocalDateTime dateCreated;
    private List<stackoverflow.entities.Vote> vote;

    public Comment( String content, stackoverflow.entities.User author) {
        if(content==null || author==null){
            throw new IllegalArgumentException();
        }
        this.content = content;
        this.author = author;
        this.dateCreated = LocalDateTime.now();
        this.id = UUID.randomUUID();
        this.vote = new ArrayList<>();

    }
}

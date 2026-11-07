package stackoverflow.entities;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Answer {

    private String content;
    private String id;
    private stackoverflow.entities.User author;
    private List<stackoverflow.entities.Comment> comment;
    private LocalDateTime dateCreated;
    private List<stackoverflow.entities.Vote> vote;

    public void addComment(stackoverflow.entities.Comment comment){
        this.comment.add(comment);
    }
    public void removeComment(stackoverflow.entities.Comment comment){
        if(comment==null){
            throw new NullPointerException("Comment is null");
        }
        if(!this.comment.contains(comment))throw new IllegalArgumentException("Comment does not exist");
        this.comment.remove(comment);
    }
    public void addVote(stackoverflow.entities.Vote vote){
        this.vote.add(vote);
    }
    public void removeVote(stackoverflow.entities.Vote vote){
        if(vote==null){
            throw new NullPointerException("vote is null");
        }
        if(!this.vote.contains(vote))throw new IllegalArgumentException("vote does not exist");
        this.vote.remove(vote);
    }

    public stackoverflow.entities.User getAuthor() {
        return author;
    }

    public void setAuthor(stackoverflow.entities.User author) {
        this.author = author;
    }


    public List<stackoverflow.entities.Comment> getComment() {
        return comment;
    }

    public List<stackoverflow.entities.Vote> getVote() {
        return vote;
    }

    public String getId() {
        return id;
    }

    public void setVote(List<stackoverflow.entities.Vote> vote) {
        this.vote = vote;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Answer(String content, stackoverflow.entities.User author) {
        if(author==null || content==null){
            throw new NullPointerException("author or content is null");
        }
        this.content = content;
        this.author = author;
        this.dateCreated = LocalDateTime.now();
        this.id = UUID.randomUUID().toString();
        this.comment = new ArrayList<>();
        this.vote = new ArrayList<>();
    }

    public String getContent() {
        return content;
    }




}
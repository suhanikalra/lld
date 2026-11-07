package stackoverflow.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Question {
    private int id;
    private String title;
    private String content;
    private stackoverflow.entities.User author;
    private List<stackoverflow.entities.Answer> answers;
    private LocalDateTime createdAt;
    private List<stackoverflow.entities.Comment> comments;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public stackoverflow.entities.User getAuthor() {
        return author;
    }

    public void setAuthor(stackoverflow.entities.User author) {
        this.author = author;
    }

    public List<stackoverflow.entities.Answer> getAnswers() {
        return answers;
    }
    public void addAnswer(stackoverflow.entities.Answer answer) {
        this.answers.add(answer);
    }

    public void setAnswers(List<stackoverflow.entities.Answer> answers) {
        this.answers = answers;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<stackoverflow.entities.Comment> getComments() {
        return comments;
    }

    public void setComments(List<stackoverflow.entities.Comment> comments) {
        this.comments = comments;
    }

    public Question( String title, String content, stackoverflow.entities.User author) {
        if(title==null || content==null || author==null){
            throw new IllegalArgumentException();
        }
        this.id = UUID.randomUUID().hashCode();
        this.title = title;
        this.content = content;
        this.author = author;
        this.answers = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
        this.comments = new ArrayList<>();
    }
}
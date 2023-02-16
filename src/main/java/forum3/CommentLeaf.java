package main.java.forum3;

import java.time.LocalDateTime;

public class CommentLeaf implements ForumComment {
    private String author;
    private String text;
    private LocalDateTime date;

    public CommentLeaf(String author, String text) {
        this.author = author;
        this.text = text;
        this.date = LocalDateTime.now();
    }

    public void display() {
        System.out.println("Comment by " + author + " on " + date + ": " + text);
    }
}

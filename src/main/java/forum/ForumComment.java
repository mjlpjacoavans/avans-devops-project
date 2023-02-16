package main.java.forum;

import java.time.LocalDateTime;

// Leaf
public class ForumComment implements ForumComponent {
    private String author;
    private String text;
    private LocalDateTime date;

    public ForumComment(String author, String text) {
        this.author = author;
        this.text = text;
        this.date = LocalDateTime.now();
    }

    public void display() {
        System.out.println("Comment by " + author + " on " + date + ": " + text);
    }
}

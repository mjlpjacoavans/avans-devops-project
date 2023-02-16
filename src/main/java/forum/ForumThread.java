package main.java.forum;

import java.util.ArrayList;
import java.util.List;

// Composite
public class ForumThread implements ForumComponent {
    private String subject;
    private List<ForumComponent> comments = new ArrayList<>();

    public ForumThread(String subject) {
        this.subject = subject;
    }

    public void addComment(ForumComponent comment) {
        comments.add(comment);
    }

    public void display() {
        System.out.println("Thread: " + subject);
        for (ForumComponent comment : comments) {
            comment.display();
        }
    }
}

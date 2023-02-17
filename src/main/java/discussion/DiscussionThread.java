package main.java.discussion;

import java.util.ArrayList;
import java.util.List;

// This is the composite
public class DiscussionThread implements DiscussionComponent {
    private String text;
    private List<DiscussionComponent> posts;
    private Integer depth;

    public DiscussionThread(String text) {
        this.text = text;
        posts = new ArrayList<>();
    }

    public void addPost(DiscussionComponent post) {
        post.setDepth(this.getDepth()+1);
        posts.add(post);
    }

    @Override
    public void display() {
        System.out.println(" ".repeat(this.getDepth()) + (posts.isEmpty() ? " - " : "Thread: ") + text);
        for (DiscussionComponent post : posts) {
            post.display();
        }
    }

    @Override
    public DiscussionComponent getPost(int i) {
        return this.posts.get(i);
    }

    @Override
    public Integer getDepth() {
        return depth;
    }

    @Override
    public void setDepth(Integer depth) {
        this.depth = depth;
    }
}



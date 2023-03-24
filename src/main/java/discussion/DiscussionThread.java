package discussion;

import java.util.ArrayList;
import java.util.List;

// This is the composite
public class DiscussionThread implements DiscussionComponent {
    private final String text;
    private final List<DiscussionComponent> posts;
    private Integer DEPTH = 0;

    public DiscussionThread(String text) {
        this.text = text;
        posts = new ArrayList<>();
    }

    public void addPost(DiscussionComponent post) {
        // TODO: Check if the case mandates this
        // TODO: Michel Send a notification here
        post.setDepth(this.getDepth()+1);
        posts.add(post);
    }

    @Override
    public void display() {
        System.out.println("".repeat(this.getDepth()) + (posts.isEmpty() ? " - " : "Thread: ") + text);
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
        return this.DEPTH;
    }

    @Override
    public void setDepth(Integer depth) {
        this.DEPTH = depth;
    }
}



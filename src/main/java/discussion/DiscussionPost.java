package main.java.discussion;

// This is the leaf
public class DiscussionPost implements DiscussionComponent {
    private String text;

    public DiscussionPost(String text) {
        this.text = text;
    }

    @Override
    public void display() {
        System.out.println(" - " + text);
    }

    @Override
    public DiscussionComponent getPost(int i) {
        if(i > 0){
            throw new IndexOutOfBoundsException("Can only get self for post");
        }
        return this;
    }

}

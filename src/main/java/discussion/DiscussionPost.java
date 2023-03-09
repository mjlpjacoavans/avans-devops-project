package main.java.discussion;

// This is the leaf
public class DiscussionPost implements DiscussionComponent {
    private final String text;
    private Integer DEPTH;

    public DiscussionPost(String text) {
        this.text = text;
    }

    @Override
    public void display() {
        System.out.println("".repeat(this.getDepth()) + " - " + text);
    }

    @Override
    public DiscussionComponent getPost(int i) {
        if(i > 0){
            throw new IndexOutOfBoundsException("Can only get self for post");
        }
        return this;
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

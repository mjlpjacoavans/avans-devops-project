package main.java.discussion;

// This is the leaf
public class DiscussionPost implements DiscussionComponent {
    private String text;
    private Integer depth;

    public DiscussionPost(String text) {
        this.text = text;
    }

    @Override
    public void display() {
        System.out.println(" ".repeat(this.getDepth()) + " - " + text);
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
        return depth;
    }

    @Override
    public void setDepth(Integer depth) {
        this.depth = depth;
    }
}

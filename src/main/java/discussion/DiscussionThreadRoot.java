package main.java.discussion;

// TODO: There should be a fix that makes it so that this
//  type IS a DiscussionThread but does not have that
//  "super-type" (because a root should not be added to a sub-item)
public class DiscussionThreadRoot extends DiscussionThread{
    private String subject;
    private final Integer DEPTH = 0;

    public DiscussionThreadRoot(String text) {
        super("New forum thread started: " + text);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

package main.java.discussion;

import main.java.discussion.DiscussionThread;


// TODO: There should be a fix that makes it so that this
//  type IS a DiscussionThread but does not have that
//  "super-type" (because a root should not be added to a sub-item)
public class DiscussionThreadRoot extends DiscussionThread{
    private String subject;
    private Integer depth = 0;

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

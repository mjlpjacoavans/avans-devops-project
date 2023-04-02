package discussion;

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

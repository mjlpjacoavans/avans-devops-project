package main.java.forumcomment;

import java.util.Date;

public class ForumCommentThread extends ForumCommentLeafComposite{
    public ForumCommentThread(Integer id, String commentText, Date commentDate) {
        super(id, "New thread with subject: " + commentText, commentDate);
    }
}

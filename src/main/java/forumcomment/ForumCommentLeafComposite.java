package main.java.forumcomment;

import java.util.ArrayList;
import java.util.Date;

public class ForumCommentLeafComposite extends IForumComment{

    private ArrayList<IForumComment> childComments = new ArrayList();
    private String subject;
    public ForumCommentLeafComposite(String commentText, Date commentDate) {
        super(0, "",new Date());
    }



    public Integer addComment(IForumComment comment){
        Integer commentId = this.childComments.size() + 1;
        comment.setId(commentId);
        this.childComments.add(comment);
        return commentId;
    }

    public IForumComment getCommentById(Integer id){
        return this.childComments.get(id);
    }
}

package main.java.forumcomment;

import java.util.Date;

public abstract class IForumComment {

    private Integer id;
    private String commentText;
    private Date commentDate;

    public IForumComment(Integer id, String commentText, Date commentDate) {
        this.id = id;
        this.commentText = commentText;
        this.commentDate = commentDate;
    }

    public IForumComment(String commentText, Date commentDate) {
        this.commentText = commentText;
        this.commentDate = commentDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
}

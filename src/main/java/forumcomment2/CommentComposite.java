package main.java.forumcomment2;

import java.util.ArrayList;
import java.util.List;

public class CommentComposite implements IComment {
    private Integer id;
    private String commentText;

    private List<IComment> childComments;


    public CommentComposite(IComment comment){
        comment.setId();

    }

    public CommentComposite(Integer id, String commentText) {
        this.id = id;
        this.commentText = commentText;
        this.childComments = new ArrayList<>();
    }

    public void printComment() {
        childComments.forEach(IComment::printComment);
    }

    public void addDepartment(IComment department) {
        childComments.add(department);
    }

    public void removeDepartment(IComment department) {
        childComments.remove(department);
    }
}

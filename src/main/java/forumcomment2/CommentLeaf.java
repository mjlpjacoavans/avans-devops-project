package main.java.forumcomment2;

public class CommentLeaf implements IComment {

    private Integer id;
    private String commentText;

    public void printComment() {
        System.out.println(getClass().getSimpleName());
    }

    // standard constructor, getters, setters
}
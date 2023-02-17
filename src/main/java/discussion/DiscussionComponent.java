package main.java.discussion;

interface DiscussionComponent {
    Integer depth = 0;
    void display();
    DiscussionComponent getPost(int i);

    Integer getDepth();
    void setDepth(Integer depth);
}

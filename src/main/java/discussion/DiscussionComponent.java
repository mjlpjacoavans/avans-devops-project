package discussion;

interface DiscussionComponent {
//    Integer DEPTH = 0;
    void display();
    DiscussionComponent getPost(int i);

    Integer getDepth();
    void setDepth(Integer depth);
}

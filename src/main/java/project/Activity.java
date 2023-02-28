package main.java.project;

import main.java.user.DeveloperUser;
import main.java.user.TesterUser;

public class Activity {
    BacklogItem backlogItem;
    DeveloperUser developer;
    String text;

    public Activity(BacklogItem backlogItem, String text) throws Exception {
        this.backlogItem = backlogItem;
        this.text = text;
        this.developer = null;

        backlogItem.addActivity(this);
    }

    public void addDeveloper(DeveloperUser developer){
        this.developer =developer;
    }

    public DeveloperUser getDeveloper() {
        return developer;
    }
}

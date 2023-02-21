package main.java.project;

import main.java.user.DeveloperUser;
import main.java.user.TesterUser;

public class Activity {
    BacklogItem backlogItem;
    DeveloperUser developer;
    TesterUser tester;
    String text;

    public Activity(BacklogItem backlogItem, String text){
        this.backlogItem = backlogItem;
        this.text = text;
        this.developer = null;
        this.tester = null;

        backlogItem.addActivity(this);
    }

    public void addDeveloper(DeveloperUser developer){
        this.developer =developer;
    }

    public void addTester(TesterUser tester){
        this.tester = tester;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Activity{");
        sb.append("developer=").append(developer);
        sb.append(", tester=").append(tester);
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

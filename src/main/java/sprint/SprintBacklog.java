package main.java.sprint;

import main.java.project.BacklogItem;

import java.util.List;

public class SprintBacklog {
    List<BacklogItem> backlogItems;
    Sprint sprint;

    public SprintBacklog(List<BacklogItem> backlogItems){
        this.backlogItems = backlogItems;
        this.sprint = null;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SprintBacklog{");
        sb.append("backlogItems=").append(backlogItems);
        sb.append(", sprint=").append(sprint);
        sb.append('}');
        return sb.toString();
    }
}

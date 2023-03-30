package sprint;

import project.BacklogItem;

import java.util.List;

public class SprintBacklog {
    List<BacklogItem> backlogItems;
    Sprint sprint;

    public SprintBacklog(List<BacklogItem> backlogItems){
        this.backlogItems = backlogItems;
        this.sprint = sprint;


//        this.addSpritToBacklogItems(this.sprint);
//        this.addNotificationTypeToBacklogItems();

        // SUGGESTION: NOT SURE IF THIS IS GOOD PRACTICE, BUT SEEMS LIKE IT'S FINE HERE
//        sprint.addSprintBacklog(this);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SprintBacklog{");
        sb.append("backlogItems=").append(backlogItems);
        sb.append(", sprint=").append(sprint);
        sb.append('}');
        return sb.toString();
    }

    public Sprint getSprint() {
        return sprint;
    }

    public List<BacklogItem> getBacklogItems() {
        return backlogItems;
    }

    private void addSpritToBacklogItems(Sprint sprint){
        for(BacklogItem backlogItem : this.backlogItems){
            backlogItem.setSprint(sprint);
        }
    }

    private void addNotificationTypeToBacklogItems(){
        for(BacklogItem backlogItem : this.backlogItems){
            backlogItem.setNotificationBehaviourType(
              this.sprint.getNotificationBehaviourType());
        }
    }
}

package main.java.project;

import main.java.project.states.*;
import main.java.sprint.SprintBacklog;
import main.java.user.DeveloperUser;
import main.java.user.TesterUser;

import java.util.ArrayList;
import java.util.List;

public class BacklogItem {
    List<Activity> activities;
    ProductBacklog productBacklog;
    SprintBacklog sprintBacklog;
    DeveloperUser developer;
    TesterUser tester;
    DefinitionOfDone definitionOfDone;
    String text;

    BacklogItemState state;
    BacklogItemState backlogItemToDoState;
    BacklogItemState backlogItemDoingState;
    BacklogItemState backlogItemReadyForTestingState;
    BacklogItemState backlogItemTestingState;
    BacklogItemState backlogItemTestedState;
    BacklogItemState backlogItemDoneState;



    public BacklogItem(ProductBacklog productBacklog, String text){
        this.activities = new ArrayList<Activity>();
        this.productBacklog = productBacklog;
        this.definitionOfDone = null;
        this.text = text;

        this.productBacklog.addBacklogItem(this);

        this.backlogItemToDoState = new BacklogItemToDoState(this);
        this.backlogItemDoingState = new BacklogItemDoingState(this);
        this.backlogItemReadyForTestingState = new BacklogItemReadyForTestingState(this);
        this.backlogItemTestingState = new BacklogItemTestingState(this);
        this.backlogItemTestedState = new BacklogItemTestedState(this);
        this.backlogItemDoneState = new BacklogItemDoneState(this);

        this.state = backlogItemToDoState;
    }

    public List<Activity> SplitInActivities(List<Activity> activities){
        this.activities = activities;
        this.developer = null;
        this.tester = null;

        return this.activities;
    }

    public List<Activity> addActivity(Activity activity){
        this.activities.add(activity);
        this.developer = null;
        this.tester = null;
        return activities;
    }

    public void addDefinitionOfDone(DefinitionOfDone definitionOfDone){
        this.definitionOfDone = definitionOfDone;
    }

    public String addDeveloper(DeveloperUser developer){
        if(this.activities != null){
            return "Cannot add a developer to a backlog item with activities. Please add the developer to the activity itself";
        }
        this.developer = developer;
        return "Developer added!";
    }

    public String addTester(TesterUser tester){
        if(this.activities != null){
            return "Cannot add a tester to a backlog item with activities. Please add the tester to the activity itself";
        }
        this.tester = tester;
        return "tester added!";
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BacklogItem{");
        sb.append("activities=").append(activities);
        sb.append(", developer=").append(developer);
        sb.append(", tester=").append(tester);
        sb.append(", definitionOfDone=").append(definitionOfDone);
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }
}


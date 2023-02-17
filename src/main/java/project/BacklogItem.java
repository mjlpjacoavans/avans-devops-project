package main.java.project;

import main.java.project.states.*;
import main.java.sprint.SprintBacklog;
import main.java.user.DeveloperUser;
import main.java.user.TesterUser;

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

    public BacklogItem(List<Activity> activities, ProductBacklog productBacklog, DefinitionOfDone definitionOfDone, String text){
        this.activities = activities;
        this.productBacklog = productBacklog;
        this.definitionOfDone = definitionOfDone;
        this.text = text;

        this.backlogItemToDoState = new BacklogItemToDoState(this);
        this.backlogItemDoingState = new BacklogItemDoingState(this);
        this.backlogItemReadyForTestingState = new BacklogItemReadyForTestingState(this);
        this.backlogItemTestingState = new BacklogItemTestingState(this);
        this.backlogItemTestedState = new BacklogItemTestedState(this);
        this.backlogItemDoneState = new BacklogItemDoneState(this);

        this.state = backlogItemToDoState;
    }
}


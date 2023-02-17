package main.java.project.states;

import main.java.project.BacklogItem;

public class BacklogItemReadyForTestingState implements BacklogItemState{
    BacklogItem backlogItem;

    public BacklogItemReadyForTestingState(BacklogItem backlogItem){
        this.backlogItem = backlogItem;
    }
}

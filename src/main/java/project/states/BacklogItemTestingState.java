package main.java.project.states;

import main.java.project.BacklogItem;

public class BacklogItemTestingState implements BacklogItemState{

    BacklogItem backlogItem;

    public BacklogItemTestingState(BacklogItem backlogItem){
        this.backlogItem = backlogItem;
    }
}

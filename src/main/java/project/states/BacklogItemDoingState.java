package main.java.project.states;

import main.java.project.BacklogItem;

public class BacklogItemDoingState implements BacklogItemState{

    BacklogItem backlogItem;

    public BacklogItemDoingState(BacklogItem backlogItem) {
        this.backlogItem = backlogItem;
    }
}

package main.java.project.states;

import main.java.project.BacklogItem;

public class BacklogItemDoneState implements BacklogItemState{

    BacklogItem backlogItem;

    public BacklogItemDoneState(BacklogItem backlogItem){
        this.backlogItem = backlogItem;
    }
}

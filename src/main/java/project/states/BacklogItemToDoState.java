package main.java.project.states;

import main.java.project.BacklogItem;

public class BacklogItemToDoState implements BacklogItemState{

    BacklogItem backlogItem;

    public BacklogItemToDoState(BacklogItem backlogItem){
        this.backlogItem = backlogItem;
    }
}

package main.java.project.states;

import main.java.project.BacklogItem;

public class BacklogItemTestedState implements BacklogItemState{

    BacklogItem backlogItem;

    public BacklogItemTestedState(BacklogItem backlogItem){
        this.backlogItem = backlogItem;
    }
}

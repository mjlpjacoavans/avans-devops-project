package main.java.project.states;

import main.java.project.Activity;
import main.java.project.BacklogItem;

import java.util.List;

public class BacklogItemReadyForTestingState implements BacklogItemState{
    BacklogItem backlogItem;

    public BacklogItemReadyForTestingState(BacklogItem backlogItem){
        this.backlogItem = backlogItem;
    }

    @Override
    public void notifyScrumMaster(String message) {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void splitInActivities(List<Activity> activities) {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void addActiviy(Activity activity) {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void setDeveloped() {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void notifyTesters(String message) {
        //TODO: michel observer pattern
    }

    @Override
    public void setTested() {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void setDefinitionMet() {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void setStateToTODO() {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void setStateToDOING() {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void setStateToREADYFORTESTING() {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void setStateToTESTING() {
        this.backlogItem.setState(this.backlogItem.getBacklogItemTestingState());
    }

    @Override
    public void setStateTOTESTED() {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void setStateToDONE() {
        System.out.println("Cannont perform this action in this state");
    }
}

package main.java.project.states;

import main.java.project.Activity;
import main.java.project.BacklogItem;
import main.java.user.DeveloperUser;
import main.java.user.TesterUser;

import java.util.List;

public class BacklogItemTestingState implements BacklogItemState{

    BacklogItem backlogItem;

    public BacklogItemTestingState(BacklogItem backlogItem){
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
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void setTested() {
        this.backlogItem.setTestedStateOverride();
        this.setStateTOTESTED();
    }

    @Override
    public void setDefinitionMet() {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void addDeveloper(DeveloperUser developer) throws Exception {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void addDeveloperToActivity(DeveloperUser developer, Activity activity) throws Exception {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void addTester(TesterUser tester) {
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
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void setStateTOTESTED() {
        this.backlogItem.setState(this.backlogItem.getBacklogItemDoneState());
    }

    @Override
    public void setStateToDONE() {
        System.out.println("Cannont perform this action in this state");
    }
}

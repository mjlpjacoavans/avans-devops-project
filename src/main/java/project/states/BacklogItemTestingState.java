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
        System.out.println(stateBaseMessage);
    }

    @Override
    public void splitInActivities(List<Activity> activities) {
        System.out.println(stateBaseMessage);
    }

    @Override
    public void addActiviy(Activity activity) {
        System.out.println(stateBaseMessage);
    }

    @Override
    public void setDeveloped() {
        System.out.println(stateBaseMessage);
    }

    @Override
    public void notifyTesters(String message) {
        System.out.println(stateBaseMessage);
    }

    @Override
    public void setTested() {
        this.backlogItem.setTestedStateOverride();
        this.setStateTOTESTED();
    }

    @Override
    public void setDefinitionMet() {
        System.out.println(stateBaseMessage);
    }

    @Override
    public void addDeveloper(DeveloperUser developer) throws Exception {
        System.out.println(stateBaseMessage);
    }

    @Override
    public void addDeveloperToActivity(DeveloperUser developer, Activity activity) throws Exception {
        System.out.println(stateBaseMessage);
    }

    @Override
    public void addTester(TesterUser tester) {
        System.out.println(stateBaseMessage);
    }

    @Override
    public void setStateToTODO() {
        System.out.println(stateBaseMessage);
    }

    @Override
    public void setStateToDOING() {
        System.out.println(stateBaseMessage);
    }

    @Override
    public void setStateToREADYFORTESTING() {
        System.out.println(stateBaseMessage);
    }

    @Override
    public void setStateToTESTING() {
        System.out.println(stateBaseMessage);
    }

    @Override
    public void setStateTOTESTED() {
        this.backlogItem.setState(this.backlogItem.getBacklogItemDoneState());
    }

    @Override
    public void setStateToDONE() {
        System.out.println(stateBaseMessage);
    }
}

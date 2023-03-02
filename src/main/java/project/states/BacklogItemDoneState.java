package main.java.project.states;

import main.java.project.Activity;
import main.java.project.BacklogItem;
import main.java.user.DeveloperUser;
import main.java.user.TesterUser;

import java.util.List;

public class BacklogItemDoneState implements BacklogItemState{

    BacklogItem backlogItem;

    public BacklogItemDoneState(BacklogItem backlogItem){
        this.backlogItem = backlogItem;
    }

    @Override
    public void notifyScrumMaster(String message) {
        throw new IllegalStateException(stateBaseMessage);
    }

    @Override
    public void splitInActivities(List<Activity> activities) {
        throw new IllegalStateException(stateBaseMessage);
    }

    @Override
    public void addActiviy(Activity activity) {
        throw new IllegalStateException(stateBaseMessage);
    }

    @Override
    public void setDeveloped() {
        throw new IllegalStateException(stateBaseMessage);
    }

    @Override
    public void notifyTesters(String message) {
        throw new IllegalStateException(stateBaseMessage);
    }

    @Override
    public void setTested() {
        throw new IllegalStateException(stateBaseMessage);
    }

    @Override
    public void setDefinitionMet() {
        throw new IllegalStateException(stateBaseMessage);
    }

    @Override
    public void addDeveloper(DeveloperUser developer) throws Exception {
        throw new IllegalStateException(stateBaseMessage);
    }

    @Override
    public void addDeveloperToActivity(DeveloperUser developer, Activity activity) throws Exception {
        throw new IllegalStateException(stateBaseMessage);
    }

    @Override
    public void addTester(TesterUser tester) {
        throw new IllegalStateException(stateBaseMessage);
    }

    @Override
    public void setStateToTODO() {
        this.backlogItem.setState(this.backlogItem.getBacklogItemToDoState());
    }

    @Override
    public void setStateToDOING() {
        throw new IllegalStateException(stateBaseMessage);
    }

    @Override
    public void setStateToREADYFORTESTING() {
        throw new IllegalStateException(stateBaseMessage);
    }

    @Override
    public void setStateToTESTING() {
        throw new IllegalStateException(stateBaseMessage);
    }

    @Override
    public void setStateTOTESTED() {
        throw new IllegalStateException(stateBaseMessage);
    }

    @Override
    public void setStateToDONE() {
        throw new IllegalStateException(stateBaseMessage);
    }
}

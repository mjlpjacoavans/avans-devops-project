package main.java.project.states;

import main.java.project.Activity;
import main.java.project.BacklogItem;
import main.java.user.DeveloperUser;
import main.java.user.TesterUser;

import java.util.List;

public class BacklogItemTestedState implements BacklogItemState{

    BacklogItem backlogItem;

    public BacklogItemTestedState(BacklogItem backlogItem){
        this.backlogItem = backlogItem;
    }

    @Override
    public void notifyScrumMaster(String message) {
        throw new IllegalStateException("Can not perform this action in this state");
    }

    @Override
    public void splitInActivities(List<Activity> activities) {
        throw new IllegalStateException("Can not perform this action in this state");
    }

    @Override
    public void addActiviy(Activity activity) {
        throw new IllegalStateException("Can not perform this action in this state");
    }

    @Override
    public void setDeveloped() {
        throw new IllegalStateException("Can not perform this action in this state");
    }

    @Override
    public void notifyTesters(String message) {
        throw new IllegalStateException("Can not perform this action in this state");
    }

    @Override
    public void setTested() {
        throw new IllegalStateException("Can not perform this action in this state");
    }

    @Override
    public void setDefinitionMet() {
        //TODO: kijk of alleen lead dev dit kan
        this.backlogItem.setDefinitionMetStateOverride();
        this.setStateToDONE();
    }

    @Override
    public void addDeveloper(DeveloperUser developer) throws Exception {
        throw new IllegalStateException("Can not perform this action in this state");
    }

    @Override
    public void addDeveloperToActivity(DeveloperUser developer, Activity activity) throws Exception {
        throw new IllegalStateException("Can not perform this action in this state");
    }

    @Override
    public void addTester(TesterUser tester) {
        throw new IllegalStateException("Can not perform this action in this state");
    }

    @Override
    public void setStateToTODO() {
        throw new IllegalStateException("Can not perform this action in this state");
    }

    @Override
    public void setStateToDOING() {
        throw new IllegalStateException("Can not perform this action in this state");
    }

    @Override
    public void setStateToREADYFORTESTING() {
        this.backlogItem.setState(this.backlogItem.getBacklogItemReadyForTestingState());
    }

    @Override
    public void setStateToTESTING() {
        throw new IllegalStateException("Can not perform this action in this state");
    }

    @Override
    public void setStateTOTESTED() {
        throw new IllegalStateException("Can not perform this action in this state");
    }

    @Override
    public void setStateToDONE() {
        this.backlogItem.setState(this.backlogItem.getBacklogItemDoneState());
    }
}

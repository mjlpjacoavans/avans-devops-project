package project.states;

import project.Activity;
import project.BacklogItem;
import user.DeveloperUser;
import user.TesterUser;

import java.util.List;

public class BacklogItemDoneState implements BacklogItemState{

    BacklogItem backlogItem;

    public BacklogItemDoneState(BacklogItem backlogItem){
        this.backlogItem = backlogItem;
    }

    @Override
    public void notifyScrumMaster(String message) {
        throw new IllegalStateException(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void splitInActivities(List<Activity> activities) {
        throw new IllegalStateException(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void addActiviy(Activity activity) {
        throw new IllegalStateException(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setDeveloped() {
        throw new IllegalStateException(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void notifyTesters(String message) {
        throw new IllegalStateException(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setTested() {
        throw new IllegalStateException(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setDefinitionMet() {
        throw new IllegalStateException(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void addDeveloper(DeveloperUser developer) throws Exception {
        throw new IllegalStateException(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void addDeveloperToActivity(DeveloperUser developer, Activity activity) throws Exception {
        throw new IllegalStateException(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void addTester(TesterUser tester) {
        throw new IllegalStateException(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setStateToTODO() {
        this.backlogItem.setState(this.backlogItem.getBacklogItemToDoState());
    }

    @Override
    public void setStateToDOING() {
        throw new IllegalStateException(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setStateToREADYFORTESTING() {
        throw new IllegalStateException(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setStateToTESTING() {
        throw new IllegalStateException(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setStateTOTESTED() {
        throw new IllegalStateException(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setStateToDONE() {
        throw new IllegalStateException(STATE_BASE_MESSAGE); // NOSONAR
    }
}

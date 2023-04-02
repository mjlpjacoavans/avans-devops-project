package project.states;

import project.Activity;
import project.BacklogItem;
import user.DeveloperUser;
import user.TesterUser;

import java.util.List;

public class BacklogItemTestedState implements BacklogItemState{

    BacklogItem backlogItem;

    public BacklogItemTestedState(BacklogItem backlogItem){
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
    public void setDefinitionMet(String email) throws Exception {
        //Check if email is lead dev
        if(email.equals(this.backlogItem.getSprintBacklog().getSprint().getLeadDeveloper().getEmail())){
            this.backlogItem.setDefinitionMetStateOverride();
            this.setStateToDONE();
        }
        else {
            throw new Exception("Email '" + email + "' does not match lead developers email");
        }
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
        throw new IllegalStateException(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setStateToDOING() {
        throw new IllegalStateException(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setStateToREADYFORTESTING() {
        this.backlogItem.setState(this.backlogItem.getBacklogItemReadyForTestingState());
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
        this.backlogItem.setState(this.backlogItem.getBacklogItemDoneState());
    }
}

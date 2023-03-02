package main.java.project.states;

import main.java.notification.BaseNotificationSubscriber;
import main.java.project.Activity;
import main.java.project.BacklogItem;
import main.java.user.DeveloperUser;
import main.java.user.TesterUser;

import java.util.List;

public class BacklogItemReadyForTestingState extends BaseNotificationSubscriber implements BacklogItemState{
    BacklogItem backlogItem;

    public BacklogItemReadyForTestingState(BacklogItem backlogItem){
        this.backlogItem = backlogItem;
        this.setNotificationBehaviour(this.backlogItem.getNotificationBehaviour());
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
        //DONE?: michel observer pattern


        // Get all tester emails
        TesterUser[] testers =  this.backlogItem
                        .getSprintBacklog()
                        .getSprint()
                        .getTesters();

        for (TesterUser testerUser : testers) {
            this.getNotificationBehaviour()
                    .setIdentifier(testerUser.getEmail());
            this.update(message);
        }


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
        this.backlogItem.addTester(tester);
        this.setStateToTESTING();
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
        this.backlogItem.setState(this.backlogItem.getBacklogItemTestingState());
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

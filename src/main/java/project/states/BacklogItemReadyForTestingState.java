package project.states;

import notification.behaviours.DynamicNotificationBehaviour;
import notification.behaviours.INotificationBehaviour;
import notification.observer.ISubscriber;
import notification.observer.NotificationSubscriber;
import notification.observer.Publisher;
import project.Activity;
import project.BacklogItem;
import user.DeveloperUser;
import user.TesterUser;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BacklogItemReadyForTestingState extends Publisher implements BacklogItemState{
    BacklogItem backlogItem;

    public BacklogItemReadyForTestingState(BacklogItem backlogItem){
        this.backlogItem = backlogItem;

        // Automatically add a subscriber for the tester
        String testerIdentifier = this.backlogItem.getTester()
                        .getIdentifierForNotificationBehaviourType(this.backlogItem.getNotificationBehaviourType());

        INotificationBehaviour testerNotificationBehaviour = new DynamicNotificationBehaviour(
                this.backlogItem.getNotificationBehaviourType(), testerIdentifier);

        ISubscriber testerSubscriber = new NotificationSubscriber(testerNotificationBehaviour);
        this.subscribe(testerSubscriber);
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
        //DONE?: michel observer pattern

        // Get all tester emails
        TesterUser[] testers =  this.backlogItem
                        .getSprintBacklog()
                        .getSprint()
                        .getTesters();

        for (TesterUser testerUser : testers) {
            String testerUserIdentifier = testerUser.getEmail();
            this.notifySubscribers(message, Collections.singletonList(testerUserIdentifier).toArray(new String[0]));
        }
    }

    @Override
    public void setTested() {
        throw new IllegalStateException(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setDefinitionMet(String email) {
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
        this.backlogItem.addTester(tester);
        this.setStateToTESTING();
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
        this.backlogItem.setState(this.backlogItem.getBacklogItemTestingState());
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

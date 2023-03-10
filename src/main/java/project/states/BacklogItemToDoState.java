package main.java.project.states;

import main.java.notification.behaviours.DynamicNotificationBehaviour;
import main.java.notification.behaviours.INotificationBehaviour;
import main.java.notification.observer.ISubscriber;
import main.java.notification.observer.NotificationSubscriber;
import main.java.notification.observer.Publisher;
import main.java.project.Activity;
import main.java.project.BacklogItem;
import main.java.user.DeveloperUser;
import main.java.user.TesterUser;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BacklogItemToDoState extends Publisher implements BacklogItemState {

    BacklogItem backlogItem;

    public BacklogItemToDoState(BacklogItem backlogItem){
        this.backlogItem = backlogItem;

        // Automatically add a subscriber for the scrum master
        String scrumMasterIdentifier = this.backlogItem
                .getSprintBacklog()
                .getSprint()
                .getScrumMaster()
                .getIdentifierForNotificationBehaviourType(this.backlogItem.getNotificationBehaviourType());

        INotificationBehaviour scrumMasterNotificationBehaviour = new DynamicNotificationBehaviour(
                this.backlogItem.getNotificationBehaviourType(), scrumMasterIdentifier);

        ISubscriber scrumMasterSubscriber = new NotificationSubscriber(scrumMasterNotificationBehaviour);
        this.subscribe(scrumMasterSubscriber);

    }

    @Override
    public void notifyScrumMaster(String message) {
        //DONE?: michel observer pattern
        this.notifySubscribers(message);

        String scrumMasterEmail = this.backlogItem
                        .getSprintBacklog()
                        .getSprint()
                        .getScrumMaster()
                        .getEmail();

        this.notifySubscribers(message, Collections.singletonList(scrumMasterEmail).toArray(new String[0]));
    }

    @Override
    public void splitInActivities(List<Activity> activities) throws Exception {
        this.backlogItem.setActivities(activities);
        this.backlogItem.setDeveloper(null);
        this.backlogItem.setTester(null);
    }

    @Override
    public void addActiviy(Activity activity) throws Exception {
        List<Activity> activities;
        activities = this.backlogItem.getActivities();
        activities.add(activity);
        backlogItem.setActivities(activities);
        backlogItem.setDeveloper(null);
        backlogItem.setTester(null);
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
        if(this.backlogItem.getDeveloper() != null){
            //DONE?: observer pattern voor michel
            String message = "New developer has been added to backlog: "+ developer;
            this.notifyScrumMaster(message);
        }
        this.backlogItem.addDeveloper(developer);
        this.setStateToDOING();
    }

    @Override
    public void addDeveloperToActivity(DeveloperUser developer, Activity activity) throws Exception {

        for(int i = 0; i< this.backlogItem.getActivities().size()-1; i++){
            if(this.backlogItem.getActivities().get(i) == activity && this.backlogItem.getActivities().get(i).getDeveloper() != null){
                //DONE?: observer pattern voor michel
                String message = "Developer for activity " + activity +
                        "  has been added " + developer;
                this.notifyScrumMaster(message);
            }
        }

        this.backlogItem.addDeveloperToActivity(developer, activity);
        this.setStateToDOING();
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
        //TODO: Kan alleen wanneer er een dev aan is toegewezen.
        this.backlogItem.setState(this.backlogItem.getBacklogItemDoingState());
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

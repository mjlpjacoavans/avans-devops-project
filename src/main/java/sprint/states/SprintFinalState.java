package sprint.states;

import notification.NotificationBehaviourFactory;
import notification.behaviours.INotificationBehaviour;
import notification.observer.ISubscriber;
import notification.observer.NotificationSubscriber;
import notification.observer.Publisher;
import sprint.Sprint;
import sprint.SprintBacklog;

import java.util.Collections;
import java.util.Date;

public class SprintFinalState extends Publisher implements SprintState {

    Sprint sprint;
    INotificationBehaviour scrumMasterNotificationBehaviour;

    public SprintFinalState(Sprint sprint){
        this.sprint = sprint;
        this.setSubscribers();
    }

    public void setSubscribers(){
        scrumMasterNotificationBehaviour = NotificationBehaviourFactory.create(this.sprint.getNotificationBehaviourType());
        ISubscriber scrumMasterSubscriber = new NotificationSubscriber(scrumMasterNotificationBehaviour);
        this.subscribe(scrumMasterSubscriber);
    }


    @Override
    public String changeName(String name) {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }

    @Override
    public String changeStartDate(Date date) {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }

    @Override
    public String changeEndDate(Date date) {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }

    @Override
    public String addSprintBacklog(SprintBacklog sprintBacklog) {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }

    @Override
    public String addReviewSummary(String summary) {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }

    @Override
    public String executeRelease() {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }

    @Override // SUGGESTION: Maybe fix return type
    public String notifyScrummaster(String message) {
        String scrumMasterIdentifier = this.sprint
                .getScrumMaster()
                .getIdentifierForNotificationBehaviourType(this.sprint.getNotificationBehaviourType());
        scrumMasterNotificationBehaviour.setIdentifier(scrumMasterIdentifier);

        this.notifySubscribers(message);

        String scrumMasterEmail = this.sprint
                .getScrumMaster()
                .getEmail();

        this.notifySubscribers(message, Collections.singletonList(scrumMasterEmail).toArray(new String[0]));
        return null;
    }

    @Override
    public String notifyProductOwner(String message) {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }

    @Override
    public String executePipeline() {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }

    @Override
    public String cancelRelease() {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }
}

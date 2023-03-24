package main.java.sprint.rystates;

import main.java.notification.behaviours.DynamicNotificationBehaviour;
import main.java.notification.behaviours.INotificationBehaviour;
import main.java.notification.observer.ISubscriber;
import main.java.notification.observer.NotificationSubscriber;
import main.java.notification.observer.Publisher;
import main.java.sprint.Sprint;
import main.java.sprint.SprintBacklog;
import main.java.sprint.states.SprintState;

import java.util.Collections;
import java.util.Date;

public class SprintFinalState extends Publisher implements SprintState {

    Sprint sprint;

    public SprintFinalState(Sprint sprint){
        this.sprint = sprint;

        String scrumMasterIdentifier = this.sprint
                .getScrumMaster()
                .getIdentifierForNotificationBehaviourType(this.sprint.getNotificationBehaviourType());

        INotificationBehaviour scrumMasterNotificationBehaviour = new DynamicNotificationBehaviour(
                this.sprint.getNotificationBehaviourType(), scrumMasterIdentifier);

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

    @Override // TODO: Maybe fix return type
    public String notifyScrummaster(String message) {
        //DONE?: Michel observer pattern

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

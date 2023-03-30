package sprint.states;

import notification.behaviours.DynamicNotificationBehaviour;
import notification.behaviours.INotificationBehaviour;
import notification.observer.ISubscriber;
import notification.observer.NotificationSubscriber;
import notification.observer.Publisher;
import sprint.Sprint;
import sprint.SprintBacklog;
import sprint.states.SprintState;

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

    @Override
    public String setInProgress() {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }

    @Override
    public String setFinished() {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }

    @Override
    public String setStateToSprintFinal() {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }

    @Override
    public String setStateToSprintReleaseDoing() {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }

    @Override
    public String setStateToSprintReleaseFinished() {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }

    @Override
    public String setStateToSprintReleasedError() {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }

    @Override
    public String setStateToSprintReleaseCancelled() {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }
}

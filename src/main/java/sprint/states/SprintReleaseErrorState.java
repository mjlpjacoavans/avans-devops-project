package sprint.states;

import notification.behaviours.DynamicNotificationBehaviour;
import notification.behaviours.INotificationBehaviour;
import notification.observer.ISubscriber;
import notification.observer.NotificationSubscriber;
import notification.observer.Publisher;
import sprint.Sprint;
import sprint.SprintBacklog;
import user.ProductOwnerUser;
import user.ScrumMasterUser;

import java.util.Collections;
import java.util.Date;

public class SprintReleaseErrorState extends Publisher implements SprintState{

    Sprint sprint;
    ProductOwnerUser productOwner;
    ScrumMasterUser scrumMaster;

    public SprintReleaseErrorState(Sprint sprint){
        this.sprint = sprint;

        this.productOwner = this.sprint
                .getSprintBacklog()
                .getBacklogItems()
                .get(0) // TODO: This is a bit strange and hacky, should find a different way to reference
                .getProductBacklog()
                .getProject()
                .getProductOwner();

        this.scrumMaster = this.sprint.getScrumMaster();


        // subscribe for scrum master
        String scrumMasterIdentifier =
                this.scrumMaster.getIdentifierForNotificationBehaviourType(this.sprint.getNotificationBehaviourType());

        INotificationBehaviour scrumMasterNotificationBehaviour = new DynamicNotificationBehaviour(
                this.sprint.getNotificationBehaviourType(), scrumMasterIdentifier);

        ISubscriber scrumMasterSubscriber = new NotificationSubscriber(scrumMasterNotificationBehaviour);
        this.subscribe(scrumMasterSubscriber);


        // subscribe for product owner
        String productOwnerIdentifier =
                this.productOwner.getIdentifierForNotificationBehaviourType(this.sprint.getNotificationBehaviourType());

        INotificationBehaviour productOwnerNotificationBehaviour = new DynamicNotificationBehaviour(
                this.sprint.getNotificationBehaviourType(), productOwnerIdentifier);

        ISubscriber productOwnerSubscriber = new NotificationSubscriber(productOwnerNotificationBehaviour);
        this.subscribe(productOwnerSubscriber);
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
        //TODO: Klopt dit?
        this.sprint.setState(this.sprint.getSprintReleaseDoingState());
        return null;
    }

    @Override
    public String notifyScrummaster(String message) {
        //DONE?: Michel observer pattern
        String scrumMasterIdentifier = this.scrumMaster.getIdentifierForNotificationBehaviourType(this.sprint.getNotificationBehaviourType());
        this.notifySubscribers(message, Collections.singletonList(scrumMasterIdentifier).toArray(new String[0]));
        return null;
    }

    @Override
    public String notifyProductOwner(String message) {
        //DONE?: Michel observer pattern
        String productOwnerIdentifier = this.productOwner.getIdentifierForNotificationBehaviourType(this.sprint.getNotificationBehaviourType());
        this.notifySubscribers(message, Collections.singletonList(productOwnerIdentifier).toArray(new String[0]));
        return null;
    }

    @Override
    public String executePipeline() {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }

    @Override
    public String cancelRelease() {
        //TODO: Klopt dit?
        this.sprint.setState(this.sprint.getSprintReleaseCancelledState());
        return null;
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
        this.sprint.setState(this.sprint.getSprintReleaseDoingState());
        return "Set state to sprint release doing!";
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
        this.sprint.setState(this.sprint.getSprintReleaseCancelledState());
        return "Set state to sprint release cancelled!";
    }
}

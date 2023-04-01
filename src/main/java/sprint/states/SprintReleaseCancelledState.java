package sprint.states;

import notification.NotificationBehaviourFactory;
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

public class SprintReleaseCancelledState extends Publisher implements SprintState{
    Sprint sprint;

    ProductOwnerUser productOwner;
    ScrumMasterUser scrumMaster;

    INotificationBehaviour scrumMasterNotificationBehaviour;
    INotificationBehaviour productOwnerNotificationBehaviour;

    public SprintReleaseCancelledState(Sprint sprint){
        this.sprint = sprint;
        this.setSubscribers();
    }

    public void setSubscribers(){
        scrumMasterNotificationBehaviour = NotificationBehaviourFactory.create(this.sprint.getNotificationBehaviourType());
        ISubscriber scrumMasterSubscriber = new NotificationSubscriber(scrumMasterNotificationBehaviour);
        this.subscribe(scrumMasterSubscriber);

        productOwnerNotificationBehaviour = NotificationBehaviourFactory.create(this.sprint.getNotificationBehaviourType());

        ISubscriber productOwnerSubscriber = new NotificationSubscriber(productOwnerNotificationBehaviour);
        this.subscribe(productOwnerSubscriber);
    }

    @Override
    public void changeName(String name) throws Exception {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public void changeStartDate(Date date) throws Exception {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public void changeEndDate(Date date) throws Exception {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public void addSprintBacklog(SprintBacklog sprintBacklog) throws Exception {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String addReviewSummary(String summary) throws Exception {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String executeRelease()  throws Exception {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String notifyScrummaster(String message) {
        //DONE?: Michel observer pattern
        String scrumMasterIdentifier = this.scrumMaster.getIdentifierForNotificationBehaviourType(this.sprint.getNotificationBehaviourType());
        this.notifySubscribers(message, Collections.singletonList(scrumMasterIdentifier).toArray(new String[0]));
        return null;
    }

    @Override
    public String notifyProductOwner(String message) throws Exception  {
        // SUGGESTION: This is very duplicated, put this in an abstract class later or something

        this.productOwner = this.sprint
                .getSprintBacklog()
                .getBacklogItems()
                .get(0) // SUGGESTION: This is a bit strange and hacky, should find a different way to reference
                .getProductBacklog()
                .getProject()
                .getProductOwner();

        this.scrumMaster = this.sprint.getScrumMaster();


        // subscribe for scrum master
        String scrumMasterIdentifier =
                this.scrumMaster.getIdentifierForNotificationBehaviourType(this.sprint.getNotificationBehaviourType());
        scrumMasterNotificationBehaviour.setIdentifier(scrumMasterIdentifier);




        // subscribe for product owner

        String productOwnerIdentifier = this.productOwner.getIdentifierForNotificationBehaviourType(this.sprint.getNotificationBehaviourType());
        productOwnerNotificationBehaviour.setIdentifier(productOwnerIdentifier);

        this.notifySubscribers(message, Collections.singletonList(productOwnerIdentifier).toArray(new String[0]));
        return null;
    }

    @Override
    public String executePipeline() throws Exception  {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String cancelRelease() throws Exception  {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String setInProgress() throws Exception  {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public void setFinished() throws Exception  {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public void setStateToSprintFinal() throws Exception  {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public void setStateToSprintReleaseDoing() throws Exception  {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public void setStateToSprintReleaseFinished() throws Exception  {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public void setStateToSprintReleasedError() throws Exception  {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public void setStateToSprintReleaseCancelled() throws Exception  {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }
}

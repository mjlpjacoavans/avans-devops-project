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

public class SprintReleaseFinishedState extends Publisher implements SprintState{
    Sprint sprint;
    ProductOwnerUser productOwner;
    ScrumMasterUser scrumMaster;
    INotificationBehaviour scrumMasterNotificationBehaviour;
    INotificationBehaviour productOwnerNotificationBehaviour;

    public SprintReleaseFinishedState(Sprint sprint){
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
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void changeStartDate(Date date) throws Exception {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void changeEndDate(Date date) throws Exception {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void addSprintBacklog(SprintBacklog sprintBacklog) throws Exception {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public String addReviewSummary(String summary) throws Exception {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public String executeRelease()  throws Exception {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public String notifyScrummaster(String message) {
        this.scrumMaster = this.sprint.getScrumMaster();
        String scrumMasterIdentifier = this.scrumMaster.getIdentifierForNotificationBehaviourType(this.sprint.getNotificationBehaviourType());
        scrumMasterNotificationBehaviour.setIdentifier(scrumMasterIdentifier);
        this.notifySubscribers(message, Collections.singletonList(scrumMasterIdentifier).toArray(new String[0]));
        return null;
    }

    @Override
    public String notifyProductOwner(String message) throws Exception  {
        // subscribe for product owner
        this.productOwner = this.sprint
                .getSprintBacklog()
                .getBacklogItems()
                .get(0) // SUGGESTION: This is a bit strange and hacky of a path, should find a different way to reference
                .getProductBacklog()
                .getProject()
                .getProductOwner();
        String productOwnerIdentifier = this.productOwner.getIdentifierForNotificationBehaviourType(this.sprint.getNotificationBehaviourType());
        productOwnerNotificationBehaviour.setIdentifier(productOwnerIdentifier);
        this.notifySubscribers(message, Collections.singletonList(productOwnerIdentifier).toArray(new String[0]));
        return null;
    }

    @Override
    public String executePipeline() throws Exception  {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public String cancelRelease() throws Exception  {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public String setInProgress() throws Exception  {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setFinished() throws Exception  {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setStateToSprintFinal() throws Exception  {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setStateToSprintReleaseDoing() throws Exception  {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setStateToSprintReleaseFinished() throws Exception  {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setStateToSprintReleasedError() throws Exception  {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setStateToSprintReleaseCancelled() throws Exception  {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }
}

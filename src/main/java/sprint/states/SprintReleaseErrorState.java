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

public class SprintReleaseErrorState extends Publisher implements SprintState{

    Sprint sprint;
    ProductOwnerUser productOwner;
    ScrumMasterUser scrumMaster;
    INotificationBehaviour scrumMasterNotificationBehaviour;
    INotificationBehaviour productOwnerNotificationBehaviour;

    public SprintReleaseErrorState(Sprint sprint){
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
        //TODO: Klopt dit?
        this.sprint.setState(this.sprint.getSprintReleaseDoingState());
        return null;
    }

    @Override
    public String notifyScrummaster(String message) {
        //DONE?: Michel observer pattern
        String scrumMasterIdentifier = this.scrumMaster.getIdentifierForNotificationBehaviourType(this.sprint.getNotificationBehaviourType());
        scrumMasterNotificationBehaviour.setIdentifier(scrumMasterIdentifier);
        this.notifySubscribers(message, Collections.singletonList(scrumMasterIdentifier).toArray(new String[0]));
        return null;
    }

    @Override
    public String notifyProductOwner(String message) throws Exception  {
        this.productOwner = this.sprint
                .getSprintBacklog()
                .getBacklogItems()
                .get(0) // SUGGESTION: This is a bit strange and hacky, should find a different way to reference
                .getProductBacklog()
                .getProject()
                .getProductOwner();

        String productOwnerIdentifier =
                this.productOwner.getIdentifierForNotificationBehaviourType(this.sprint.getNotificationBehaviourType());
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
        //TODO: Klopt dit?
        this.sprint.setState(this.sprint.getSprintReleaseCancelledState());
        return null;
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
        this.sprint.setState(this.sprint.getSprintReleaseDoingState());
        System.out.println("Set state to sprint release doing!");
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
        this.sprint.setState(this.sprint.getSprintReleaseCancelledState());
        System.out.println("Set state to sprint release cancelled!");
    }
}

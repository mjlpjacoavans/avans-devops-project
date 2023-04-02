package sprint.states;

import notification.NotificationBehaviourFactory;
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
    public String notifyProductOwner(String message) throws Exception  {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
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

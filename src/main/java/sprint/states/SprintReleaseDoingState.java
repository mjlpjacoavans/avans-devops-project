package sprint.states;

import sprint.Sprint;
import sprint.SprintBacklog;

import java.util.Date;

public class SprintReleaseDoingState implements SprintState{
    Sprint sprint;

    public SprintReleaseDoingState(Sprint sprint){
        this.sprint = sprint;
    }

    @Override
    public String changeName(String name) throws Exception {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String changeStartDate(Date date) throws Exception {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String changeEndDate(Date date) throws Exception {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String addSprintBacklog(SprintBacklog sprintBacklog) throws Exception {
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
    public String notifyScrummaster(String message) throws Exception {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String notifyProductOwner(String message) throws Exception  {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String executePipeline() throws Exception  {
        //TODO: execute this.sprint.getPipeline().startPipeline();
        return null;
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
    public String setFinished() throws Exception  {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String setStateToSprintFinal() throws Exception  {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String setStateToSprintReleaseDoing() throws Exception  {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String setStateToSprintReleaseFinished() throws Exception  {
        this.sprint.setState(this.sprint.getSprintReleaseFinishedState());
        return "Set state to release finished!";
    }

    @Override
    public String setStateToSprintReleasedError() throws Exception  {
        this.sprint.setState(this.sprint.getSprintReleaseErrorState());
        return "Set state to release error!";
    }

    @Override
    public String setStateToSprintReleaseCancelled() throws Exception  {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }
}

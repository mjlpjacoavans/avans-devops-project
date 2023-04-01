package sprint.states;

import sprint.Sprint;
import sprint.SprintBacklog;

import java.time.LocalDate;
import java.util.Date;

public class SprintInProgressState implements SprintState {

    Sprint sprint;

    public SprintInProgressState(Sprint sprint){
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
    public String setFinished() throws Exception  {
        LocalDate today = LocalDate.now();
        if(today.isAfter(this.sprint.getEndDate()) || today.isEqual(this.sprint.getStartDate())){
            this.sprint.setState(this.sprint.getSprintFinishedState());
            return "State changed to Finished";
        }else{
            return "enddate has not happend yet!";
        }
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
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String setStateToSprintReleasedError() throws Exception  {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String setStateToSprintReleaseCancelled() throws Exception  {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }
}

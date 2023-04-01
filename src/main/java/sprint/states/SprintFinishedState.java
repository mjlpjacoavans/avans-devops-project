package sprint.states;

import sprint.Sprint;
import sprint.SprintBacklog;
import sprint.enums.Goal;

import java.util.Date;

public class SprintFinishedState implements SprintState{

    Sprint sprint;

    public SprintFinishedState(Sprint sprint){
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
        if(this.sprint.getGoal().equals(Goal.REVIEW)){
            sprint.addReviewSummaryStateOverride(summary);
            this.sprint.setState(this.sprint.getSprintFinalState());
            return "added!";
        }
        return "Cannot change perform this action with this sprint goal";
    }

    @Override
    public String executeRelease()  throws Exception {
        //TODO: Eerst checken of de results goed zijn en dan naar cancelled als fout en doing als goed (michel)
        if(this.sprint.getGoal().equals(Goal.RELEASE)){
            this.sprint.setState(this.sprint.getSprintReleaseDoingState());
            return null;
        }
        return "Cannot change perform this action with this sprint goal";
    }

    @Override
    public String notifyScrummaster(String message) throws Exception {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String notifyProductOwner(String message) throws Exception {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String executePipeline() throws Exception {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String cancelRelease() throws Exception {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String setInProgress() throws Exception {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String setFinished() throws Exception {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String setStateToSprintFinal() throws Exception  {
        this.sprint.setState(this.sprint.getSprintFinalState());
        return "Set state to Final!";
    }

    @Override
    public String setStateToSprintReleaseDoing() throws Exception  {
        this.sprint.setState(this.sprint.getSprintReleaseDoingState());
        return "Set state to release doing";
    }

    @Override
    public String setStateToSprintReleaseFinished() throws Exception {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String setStateToSprintReleasedError() throws Exception {
        throw new Exception("Cannot change perform this action in this state!"); // NOSONAR
    }

    @Override
    public String setStateToSprintReleaseCancelled() throws Exception  {
        this.sprint.setState(this.sprint.getSprintReleaseCancelledState());
        return "Set state to release cancelled!";
    }
}

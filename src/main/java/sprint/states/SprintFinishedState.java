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
        if(this.sprint.getGoal().equals(Goal.REVIEW)){
            sprint.addReviewSummaryStateOverride(summary);
            this.sprint.setState(this.sprint.getSprintFinalState());
            System.out.println("added!");
            return null;
        }
        throw new Exception("Cannot change perform this action with this sprint goal");
    }

    @Override
    public String executeRelease()  throws Exception {
        //TODO: Eerst checken of de results goed zijn en dan naar cancelled als fout en doing als goed (michel)
        if(!this.sprint.getGoal().equals(Goal.RELEASE)){
            throw new Exception("Cannot change perform this action with this sprint goal");
        }
        this.sprint.setState(this.sprint.getSprintReleaseDoingState());
        return null;
    }

    @Override
    public String notifyScrummaster(String message) throws Exception {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public String notifyProductOwner(String message) throws Exception {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public String executePipeline() throws Exception {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public String cancelRelease() throws Exception {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public String setInProgress() throws Exception {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setFinished() throws Exception {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setStateToSprintFinal() throws Exception  {
        this.sprint.setState(this.sprint.getSprintFinalState());
        System.out.println("Set state to Final!");
    }

    @Override
    public void setStateToSprintReleaseDoing() throws Exception  {
        this.sprint.setState(this.sprint.getSprintReleaseDoingState());
        System.out.println("Set state to release doing");
    }

    @Override
    public void setStateToSprintReleaseFinished() throws Exception {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setStateToSprintReleasedError() throws Exception {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setStateToSprintReleaseCancelled() throws Exception  {
        this.sprint.setState(this.sprint.getSprintReleaseCancelledState());
        System.out.println("Set state to release cancelled!");
    }
}

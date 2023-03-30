package sprint.states;

import enums.Goal;
import sprint.Sprint;
import sprint.SprintBacklog;

import java.util.Date;

public class SprintFinishedState implements SprintState{

    Sprint sprint;

    public SprintFinishedState(Sprint sprint){
        this.sprint = sprint;
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
        if(this.sprint.getGoal().equals(Goal.REVIEW)){
            sprint.addReviewSummaryStateOverride(summary);
            this.sprint.setState(this.sprint.getSprintFinalState());
            return "added!";
        }
        return "Cannot change perform this action with this sprint goal";
    }

    @Override
    public String executeRelease() {
        //TODO: Eerst checken of de results goed zijn en dan naar cancelled als fout en doing als goed (michel)
        if(this.sprint.getGoal().equals(Goal.RELEASE)){
            this.sprint.setState(this.sprint.getSprintReleaseDoingState());
            return null;
        }
        return "Cannot change perform this action with this sprint goal";
    }

    @Override
    public String notifyScrummaster(String message) {
        return "Cannot change perform this action in this state!"; // NOSONAR
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
        this.sprint.setState(this.sprint.getSprintFinalState());
        return "Set state to Final!";
    }

    @Override
    public String setStateToSprintReleaseDoing() {
        this.sprint.setState(this.sprint.getSprintReleaseDoingState());
        return "Set state to release doing";
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
        return "Set state to release cancelled!";
    }
}

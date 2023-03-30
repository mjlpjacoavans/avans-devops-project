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
        return "Cannot change perform this action in this state!"; // NOSONAR
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
        //TODO: execute
        return null;
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
        return "Cannot change perform this action in this state!"; // NOSONAR
    }

    @Override
    public String setStateToSprintReleaseDoing() {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }

    @Override
    public String setStateToSprintReleaseFinished() {
        this.sprint.setState(this.sprint.getSprintReleaseFinishedState());
        return "Set state to release finished!";
    }

    @Override
    public String setStateToSprintReleasedError() {
        this.sprint.setState(this.sprint.getSprintReleaseErrorState());
        return "Set state to release error!";
    }

    @Override
    public String setStateToSprintReleaseCancelled() {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }
}

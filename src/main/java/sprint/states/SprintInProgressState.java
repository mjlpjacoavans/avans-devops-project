package main.java.sprint.states;

import main.java.sprint.Sprint;
import main.java.sprint.SprintBacklog;

import java.time.LocalDate;
import java.util.Date;

public class SprintInProgressState implements SprintState {

    Sprint sprint;

    public SprintInProgressState(Sprint sprint){
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
        LocalDate today = LocalDate.now();
        if(today.isAfter(this.sprint.getEndDate()) || today.isEqual(this.sprint.getStartDate())){
            this.sprint.setState(this.sprint.getSprintFinishedState());
            return "State changed to Finished";
        }else{
            return "enddate has not happend yet!";
        }
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
        return "Cannot change perform this action in this state!"; // NOSONAR
    }

    @Override
    public String setStateToSprintReleasedError() {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }

    @Override
    public String setStateToSprintReleaseCancelled() {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }
}

package main.java.sprint.states;

import main.java.sprint.Sprint;
import main.java.sprint.SprintBacklog;

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
        sprint.addReviewSummaryStateOverride(summary);
        this.sprint.setState(this.sprint.getSprintFinalState());
        return "added!";
    }

    @Override
    public String executeRelease() {
        //TODO: Eerst checken of de results goed zijn en dan naar cancelled als fout en doing als goed (michel)
        this.sprint.setState(this.sprint.getSprintReleaseDoingState());
        return null;
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
}

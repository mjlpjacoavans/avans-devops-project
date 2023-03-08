package main.java.sprint.states;

import main.java.sprint.Sprint;
import main.java.sprint.SprintBacklog;

import java.util.Date;

public class SprintReleaseCancelledState implements SprintState{
    Sprint sprint;

    public SprintReleaseCancelledState(Sprint sprint){
        this.sprint = sprint;
    }

    @Override
    public String changeName(String name) {
        return "Cannot change perform this action in this state!";
    }

    @Override
    public String changeStartDate(Date date) {
        return "Cannot change perform this action in this state!";
    }

    @Override
    public String changeEndDate(Date date) {
        return "Cannot change perform this action in this state!";
    }

    @Override
    public String addSprintBacklog(SprintBacklog sprintBacklog) {
        return "Cannot change perform this action in this state!";
    }

    @Override
    public String addReviewSummary(String summary) {
        return "Cannot change perform this action in this state!";
    }

    @Override
    public String executeRelease() {
        return "Cannot change perform this action in this state!";
    }

    @Override
    public String notifyScrummaster(String message) {
        //TODO: Michel observer pattern
        return null;
    }

    @Override
    public String notifyProductOwner(String message) {
        //TODO: Michel observer pattern
        return null;
    }

    @Override
    public String executePipeline() {
        return "Cannot change perform this action in this state!";
    }

    @Override
    public String cancelRelease() {
        return "Cannot change perform this action in this state!";
    }
}

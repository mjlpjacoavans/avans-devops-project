package main.java.sprint.states;

import main.java.sprint.Sprint;
import main.java.sprint.SprintBacklog;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class SprintInitializedState implements SprintState{
    Sprint sprint;

    public SprintInitializedState(Sprint sprint){
        this.sprint = sprint;
    }

    //TODO: Is set name state override method niet beetje cheesy. setname roept state aan. als je setname is state doet roep je weer state aan dus infinite loop.

    @Override
    public String changeName(String name) {
        this.sprint.setNameOverrideState(name);

        return "name changed to: " + name;
    }

    @Override
    public String changeStartDate(Date date) {
        this.sprint.setStartDateOverrideState(date);

        return "Start date changed to: " + date;
    }

    @Override
    public String changeEndDate(Date date) {
        this.sprint.setEndDateOverrideState(date);

        return "End date changed to: " + date;
    }

    @Override
    public String addSprintBacklog(SprintBacklog sprintBacklog) {
        this.sprint.addSprintBacklogOverrideState(sprintBacklog);

        return "Sprint backlog changed to: " + sprintBacklog;
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
        LocalDate today = LocalDate.now();
        if(today.isAfter(this.sprint.getStartDate()) || today.isEqual(this.sprint.getStartDate())){
            this.sprint.setState(this.sprint.getSprintInProgressState());
            return "State changed to Inprogress";
        }else{
            return "Startdate has not happend yet!";
        }
    }

    @Override
    public String setFinished() {
        return "Cannot change perform this action in this state!"; // NOSONAR
    }
}

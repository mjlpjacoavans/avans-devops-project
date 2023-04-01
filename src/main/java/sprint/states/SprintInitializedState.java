package sprint.states;

import sprint.Sprint;
import sprint.SprintBacklog;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class SprintInitializedState implements SprintState{
    Sprint sprint;

    public SprintInitializedState(Sprint sprint){
        this.sprint = sprint;
    }

    //SUGGESTION: Is set name state override method niet beetje cheesy. setname roept state aan. als je setname is state doet roep je weer state aan dus infinite loop.

    @Override
    public String changeName(String name) throws Exception {
        this.sprint.setNameOverrideState(name);

        return "name changed to: " + name;
    }

    @Override
    public String changeStartDate(Date date) throws Exception {
        this.sprint.setStartDateOverrideState(date);

        return "Start date changed to: " + date;
    }

    @Override
    public String changeEndDate(Date date) throws Exception {
        this.sprint.setEndDateOverrideState(date);

        return "End date changed to: " + date;
    }

    @Override
    public String addSprintBacklog(SprintBacklog sprintBacklog) throws Exception {
        this.sprint.addSprintBacklogOverrideState(sprintBacklog);

        return "Sprint backlog changed to: " + sprintBacklog;
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
    public String setInProgress() throws Exception {
        LocalDate today = LocalDate.now();
        if(today.isAfter(this.sprint.getStartDate()) || today.isEqual(this.sprint.getStartDate())){
            this.sprint.setState(this.sprint.getSprintInProgressState());
            System.out.println("State changed to Inprogress");
            return null;
        }else{
            throw new Exception("Startdate has not happend yet!");
        }
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

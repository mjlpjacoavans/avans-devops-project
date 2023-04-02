package sprint.states;

import utils.DateUtil;
import sprint.Sprint;
import sprint.SprintBacklog;

import java.util.Date;

public class SprintInitializedState implements SprintState{
    Sprint sprint;

    public SprintInitializedState(Sprint sprint){
        this.sprint = sprint;
    }

    //SUGGESTION: Is set name state override method niet beetje cheesy. setname roept state aan. als je setname is state doet roep je weer state aan dus infinite loop.

    @Override
    public void changeName(String name) throws Exception {
        this.sprint.setNameOverrideState(name);
        System.out.println("name changed to: " + name);
    }

    @Override
    public void changeStartDate(Date date) throws Exception {
        this.sprint.setStartDateOverrideState(date);
        System.out.println("Start date changed to: " + date);
    }

    @Override
    public void changeEndDate(Date date) throws Exception {
        this.sprint.setEndDateOverrideState(date);
        System.out.println("End date changed to: " + date);
    }

    @Override
    public void addSprintBacklog(SprintBacklog sprintBacklog) throws Exception {
        this.sprint.addSprintBacklogOverrideState(sprintBacklog);
        System.out.println("Sprint backlog changed to: " + sprintBacklog);
    }

    @Override
    public String addReviewSummary(String summary) throws Exception {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public String executeRelease()  throws Exception {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public String notifyScrummaster(String message) throws Exception {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public String notifyProductOwner(String message) throws Exception  {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public String executePipeline() throws Exception  {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public String cancelRelease() throws Exception  {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public String setInProgress() throws Exception {
        Date startDate = this.sprint.getStartDate();
        if(DateUtil.dateIsAfterToday(startDate)){
            this.sprint.setState(this.sprint.getSprintInProgressState());
            System.out.println("State changed to Inprogress");
            return null;
        }else{
            throw new Exception("Startdate has not happend yet!");
        }
    }

    @Override
    public void setFinished() throws Exception  {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setStateToSprintFinal() throws Exception  {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setStateToSprintReleaseDoing() throws Exception  {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setStateToSprintReleaseFinished() throws Exception  {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setStateToSprintReleasedError() throws Exception  {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }

    @Override
    public void setStateToSprintReleaseCancelled() throws Exception  {
        throw new Exception(STATE_BASE_MESSAGE); // NOSONAR
    }
}

package sprint.states;

import sprint.SprintBacklog;

import java.util.Date;

public interface SprintState {

    void changeName(String name) throws Exception;
    void changeStartDate(Date date) throws Exception;
    void changeEndDate(Date date) throws Exception;
    void addSprintBacklog(SprintBacklog sprintBacklog) throws Exception;
    String addReviewSummary(String summary) throws Exception;
    String executeRelease() throws Exception;
    String notifyScrummaster(String message) throws Exception;
    String notifyProductOwner(String message) throws Exception;
    String executePipeline() throws Exception;
    String cancelRelease() throws Exception;
    String setInProgress() throws Exception;
    void setFinished() throws Exception;

    void setStateToSprintFinal() throws Exception;
    void setStateToSprintReleaseDoing() throws Exception;
    void setStateToSprintReleaseFinished() throws Exception;
    void setStateToSprintReleasedError() throws Exception;
    void setStateToSprintReleaseCancelled() throws Exception;
}

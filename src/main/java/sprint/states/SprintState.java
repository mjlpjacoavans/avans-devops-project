package sprint.states;

import sprint.SprintBacklog;

import java.util.Date;

public interface SprintState {

    String changeName(String name) throws Exception;
    String changeStartDate(Date date) throws Exception;
    String changeEndDate(Date date) throws Exception;
    String addSprintBacklog(SprintBacklog sprintBacklog) throws Exception;
    String addReviewSummary(String summary) throws Exception;
    String executeRelease() throws Exception;
    String notifyScrummaster(String message) throws Exception;
    String notifyProductOwner(String message) throws Exception;
    String executePipeline() throws Exception;
    String cancelRelease() throws Exception;
    String setInProgress() throws Exception;
    String setFinished() throws Exception;

    String setStateToSprintFinal() throws Exception;
    String setStateToSprintReleaseDoing() throws Exception;
    String setStateToSprintReleaseFinished() throws Exception;
    String setStateToSprintReleasedError() throws Exception;
    String setStateToSprintReleaseCancelled() throws Exception;
}

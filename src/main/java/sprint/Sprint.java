package sprint;

import notification.behaviours.NotificationBehaviourTypes;
import pipeline.IPipeline;
import sprint.enums.Goal;
import notification.behaviours.NotificationBehaviourTypes;
import sprint.states.*;
import sprintreport.ISprintReportBuilder;
import sprintreport.domain.ISprintReport;
import user.DeveloperUser;
import user.LeadDeveloperUser;
import user.ScrumMasterUser;
import user.TesterUser;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;

//TODO: Auto state switch van ini naar inprogress en inprogress naar finished

public class Sprint {
    SprintBacklog sprintBacklog;
    Goal goal;
    String name;
    Date startDate;
    Date endDate;
    boolean resultsGood;
    ISprintReport sprintReport;
    ISprintReportBuilder reportBuilder;
    DeveloperUser[] developers;
    TesterUser[] testers;
    LeadDeveloperUser leadDeveloper;
    ScrumMasterUser scrumMaster;
    String reviewSummary;

    LocalDate currentDate;
    LocalDate yesterdayDate;

    //states
    SprintState state;
    SprintState sprintInitialisedState;
    SprintState sprintInProgressState;
    SprintState sprintFinishedState;
    SprintState sprintFinalState;
    SprintState sprintReleaseDoingState;
    SprintState sprintReleaseFinishedState;
    SprintState sprintReleaseCancelledState;
    SprintState sprintReleaseErrorState;

    IPipeline pipeline; // TODO: Initialize this appropriately


    // SUGGESTION: Decided to make this email by default
    NotificationBehaviourTypes notificationBehaviourType; // = NotificationBehaviourTypes.EMAIL;

    public Sprint(Goal goal, String name, Date startDate, Date endDate, DeveloperUser[] developers, TesterUser[] testers,
                  LeadDeveloperUser leadDeveloper, ScrumMasterUser scrumMaster, NotificationBehaviourTypes notificationBehaviourType){

        this.notificationBehaviourType = notificationBehaviourType;
        this.goal = goal;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.resultsGood = false;
        this.developers = developers;
        this.testers = testers;
        this.leadDeveloper = leadDeveloper;
        this.scrumMaster = scrumMaster;

        this.sprintInitialisedState = new SprintInitializedState(this);
        this.sprintInProgressState = new SprintInProgressState(this);
        this.sprintFinishedState = new SprintFinishedState(this);
        this.sprintFinalState = new SprintFinalState(this);
        this.sprintReleaseDoingState = new SprintReleaseDoingState(this);


        this.sprintReleaseFinishedState = new SprintReleaseFinishedState(this);
        this.sprintReleaseCancelledState = new SprintReleaseCancelledState(this);
        this.sprintReleaseErrorState = new SprintReleaseErrorState(this);

        this.state = sprintInitialisedState;
        currentDate = LocalDate.now();
        yesterdayDate = LocalDate.now().minusDays(1);

        this.reviewSummary = null;

        // TODO: fix het wanneer een sprint wordt aangemaakt met een enddate in verleden
        // if(currentDate.isAfter(this.endDate)){}
    }


//    THIS CAN NOT BE DONE BECAUSE JAVA FOR SOME DUMB REASON DOES NOT ALLOW ANY CODE BEFORE CALLING OVERLOADED CONSTRUCTOR MAKING ITS USAGE COMPLETELEY WORTHLESS.
//    SUPER ANOYING, GIVES A LOT MORE CODE COMPLEXITY
//    public Sprint(Goal goal, String name, Date startDate, Date endDate, DeveloperUser[] developers, TesterUser[] testers,
//                  LeadDeveloperUser leadDeveloper, ScrumMasterUser scrumMaster, NotificationBehaviourTypes notificationBehaviourType){
//        this.notificationBehaviourType = notificationBehaviourType;
//
//        this(goal, name, startDate, endDate, developers, testers, leadDeveloper, scrumMaster);
//    }






        public String setState(SprintState stateParameter){
            if(this.state != stateParameter){
                return "Sprint state not changed. Try again!";
            }
            this.state = stateParameter;
            return "Sprint state set to: " + this.state;
    }

    public NotificationBehaviourTypes getNotificationBehaviourType() {
        return notificationBehaviourType;
    }

    public void setNotificationBehaviourType(NotificationBehaviourTypes notificationBehaviourType) {
        this.notificationBehaviourType = notificationBehaviourType;
    }

    public String getName() {
        return name;
    }

    public String getReviewSummary() {
        return reviewSummary;
    }

    public SprintState getState() {
        return state;
    }

    public SprintState getStateInProgress(){
        return this.sprintInProgressState;
    }

    public void setName(String name){
        state.changeName(name);
    }

    public void setNameOverrideState(String name){
        this.name = name;
    }

    public void setStartDate(Date date){
        state.changeStartDate(date);
    }

    public void setStartDateOverrideState(Date date){
        this.startDate = date;
    }

    public void setEndDate(Date date){
        state.changeEndDate(date);
    }

    public void setEndDateOverrideState(Date date){
        this.endDate = date;
    }

    public void addSprintBacklog(SprintBacklog sprintBacklog){
        state.addSprintBacklog(sprintBacklog);
    }

    public void addSprintBacklogOverrideState(SprintBacklog sprintBacklog){
        this.sprintBacklog = sprintBacklog;
    }

    public SprintBacklog getSprintBacklog() {
        return sprintBacklog;
    }

    public ScrumMasterUser getScrumMaster() {
        return scrumMaster;
    }

    public LeadDeveloperUser getLeadDeveloper() {
        return leadDeveloper;
    }

    public TesterUser[] getTesters() {
        return testers;
    }

    public IPipeline getPipeline() { return pipeline; }

    public void addReviewSummary(String summary){
        this.state.addReviewSummary(summary);
    }

    public String addReviewSummaryStateOverride(String summary){
        this.reviewSummary = summary;
        return summary;
    }

//    public Sprint(DeveloperUser[] developers) {
//        this.developers = developers;
//    }

    public void setStateToSprintInProgress(){
        this.state.setInProgress();
    }

    public void setStateToSprintFinished(){
        this.state.setFinished();
    }

    public void setStateToSprintFinal(){

    }

    public void setStateToSprintReleaseDoing(){

    }

    public void setStateToSprintReleaseFinished(){

    }

    public void setStateToSprintReleaseCancelled(){

    }

    public void setStateToSprintReleaseError(){

    }


    public SprintState getSprintInitialisedState() {
        return sprintInitialisedState;
    }

    public SprintState getSprintInProgressState() {
        return sprintInProgressState;
    }

    public SprintState getSprintFinishedState() {
        return sprintFinishedState;
    }

    public SprintState getSprintFinalState() {
        return sprintFinalState;
    }

    public SprintState getSprintReleaseDoingState() {
        return sprintReleaseDoingState;
    }

    public SprintState getSprintReleaseFinishedState() {
        return sprintReleaseFinishedState;
    }

    public SprintState getSprintReleaseCancelledState() {
        return sprintReleaseCancelledState;
    }

    public SprintState getSprintReleaseErrorState() {
        return sprintReleaseErrorState;
    }

    public ChronoLocalDate getStartDate() {
        return startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public ChronoLocalDate getEndDate() {
        return endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public Goal getGoal() {
        return goal;
    }
}

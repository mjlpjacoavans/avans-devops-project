package main.java.sprint;

import main.java.enums.Goal;
import main.java.sprint.states.*;
import main.java.sprintreport.ISprintReportBuilder;
import main.java.sprintreport.SprintReportBuilder;
import main.java.sprintreport.domain.ISprintReport;
import main.java.user.DeveloperUser;
import main.java.user.LeadDeveloperUser;
import main.java.user.ScrumMasterUser;
import main.java.user.TesterUser;

import java.util.Date;

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

    //states
    SprintState state;
    SprintState sprintInitialisedState;
    SprintState sprintInProgressState;
    SprintState sprintFinishedState;
    SprintState sprintFinalState;

    public Sprint(Goal goal, String name, Date startDate, Date endDate, DeveloperUser[] developers, TesterUser[] testers, LeadDeveloperUser leadDeveloper, ScrumMasterUser scrumMaster){
        this.goal = goal;
        //this.state = SprintInitializedState;
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

        this.state = sprintInitialisedState;
    }

    public String setState(SprintState state){
        this.state = state;

        if(this.state != state){
            return "Sprint state not changed. Try again!";
        }

        return "Sprint state set to: " + this.state;
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
        this.sprintBacklog =sprintBacklog;

    }
}

package main.java.sprint;

import main.java.enums.Goal;
import main.java.sprint.states.SprintState;
import main.java.sprintreport.ISprintReportBuilder;
import main.java.sprintreport.domain.ISprintReport;
import main.java.user.DeveloperUser;
import main.java.user.LeadDeveloperUser;
import main.java.user.ScrumMasterUser;
import main.java.user.TesterUser;

import java.util.Date;

public class Sprint {
    SprintBacklog sprintBacklog;
    Goal goal;
    SprintState state;
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
}

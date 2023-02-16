package main.java.sprint.states;

import main.java.sprint.SprintBacklog;

import java.util.Date;

public interface SprintState {

    String changeName(String name);
    String changeStartDate(Date date);
    String changeEndDate(Date date);
    String addSprintBacklog(SprintBacklog sprintBacklog);
}

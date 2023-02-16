package main.java.sprint.states;

import main.java.sprint.Sprint;
import main.java.sprint.SprintBacklog;

import java.util.Date;

public class SprintFinishedState implements SprintState{

    Sprint sprint;

    public SprintFinishedState(Sprint sprint){
        this.sprint = sprint;
    }


    @Override
    public String changeName(String name) {
        return "Can not change name. This can only be changed in the initialised state!";
    }

    @Override
    public String changeStartDate(Date date) {
        return "Can not change start date. This can only be changed in the initialised state!";
    }

    @Override
    public String changeEndDate(Date date) {
        return "Can not change end date. This can only be changed in the initialised state!";
    }

    @Override
    public String addSprintBacklog(SprintBacklog sprintBacklog) {
        return "Can not change sprint backlog. This can only be changed in the initialised state!";
    }
}

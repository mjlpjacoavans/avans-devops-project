package main.java.project.states;

import main.java.project.Activity;

import java.util.List;

public interface BacklogItemState {

    void notifyScrumMaster(String message);

    void splitInActivities(List<Activity> activities);

    void addActiviy(Activity activity);

    void setDeveloped();

    void notifyTesters(String message);

    void setTested();

    void setDefinitionMet();

    void setStateToTODO();

    void setStateToDOING();

    void setStateToREADYFORTESTING();

    void setStateToTESTING();

    void setStateTOTESTED();

    void setStateToDONE();

}

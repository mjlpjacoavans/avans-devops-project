package main.java.project.states;

import main.java.project.Activity;
import main.java.user.DeveloperUser;
import main.java.user.TesterUser;

import java.util.List;

public interface BacklogItemState {
    String stateBaseMessage = "Can't perform this action in this state.";

    void notifyScrumMaster(String message);

    void splitInActivities(List<Activity> activities) throws Exception;

    void addActiviy(Activity activity) throws Exception;

    void setDeveloped() throws Exception;

    void notifyTesters(String message);

    void setTested();

    void setDefinitionMet();

    void addDeveloper(DeveloperUser developer) throws Exception;

    void addDeveloperToActivity(DeveloperUser developer, Activity activity) throws Exception;

    void addTester(TesterUser tester);

    void setStateToTODO();

    void setStateToDOING();

    void setStateToREADYFORTESTING();

    void setStateToTESTING();

    void setStateTOTESTED();

    void setStateToDONE();

}

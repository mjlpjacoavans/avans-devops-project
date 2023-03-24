package project.states;

import project.Activity;
import user.DeveloperUser;
import user.TesterUser;

import java.util.List;

public interface BacklogItemState {
    String STATE_BASE_MESSAGE = "Can't perform this action in this state.";

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

package main.java.project.states;

import main.java.notification.BaseNotificationSubscriber;
import main.java.project.Activity;
import main.java.project.BacklogItem;
import main.java.user.DeveloperUser;
import main.java.user.TesterUser;

import java.util.List;

public class BacklogItemReadyForTestingState extends BaseNotificationSubscriber implements BacklogItemState{
    BacklogItem backlogItem;

    public BacklogItemReadyForTestingState(BacklogItem backlogItem){
        this.backlogItem = backlogItem;
    }

    @Override
    public void notifyScrumMaster(String message) {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void splitInActivities(List<Activity> activities) {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void addActiviy(Activity activity) {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void setDeveloped() {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void notifyTesters(String message) {
        //DONE?: michel observer pattern
        this.update(message);
    }

    @Override
    public void setTested() {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void setDefinitionMet() {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void addDeveloper(DeveloperUser developer) throws Exception {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void addDeveloperToActivity(DeveloperUser developer, Activity activity) throws Exception {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void addTester(TesterUser tester) {
        this.backlogItem.addTester(tester);
        this.setStateToTESTING();
    }

    @Override
    public void setStateToTODO() {
        this.backlogItem.setState(this.backlogItem.getBacklogItemToDoState());
    }

    @Override
    public void setStateToDOING() {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void setStateToREADYFORTESTING() {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void setStateToTESTING() {
        this.backlogItem.setState(this.backlogItem.getBacklogItemTestingState());
    }

    @Override
    public void setStateTOTESTED() {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void setStateToDONE() {
        System.out.println("Cannont perform this action in this state");
    }
}

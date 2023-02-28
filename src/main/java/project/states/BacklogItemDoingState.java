package main.java.project.states;

import main.java.notification.BaseNotificationSubscriber;
import main.java.notification.behaviours.INotificationBehaviour;
import main.java.notification.behaviours.StdOutNotificationBehaviour;
import main.java.project.Activity;
import main.java.project.BacklogItem;
import main.java.user.DeveloperUser;
import main.java.user.TesterUser;

import java.util.List;

public class BacklogItemDoingState extends BaseNotificationSubscriber implements BacklogItemState{

    BacklogItem backlogItem;

    public BacklogItemDoingState(BacklogItem backlogItem) {
        this.backlogItem = backlogItem;
        this.setNotificationBehaviour(this.backlogItem.getNotificationBehaviour());
    }

    @Override
    public void notifyScrumMaster(String message) {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void splitInActivities(List<Activity> activities) {
        System.out.println("Cannot perform this action in this state");
    }

    @Override
    public void addActiviy(Activity activity) {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void setDeveloped() throws Exception {
        this.backlogItem.setDevelopedStateHelper();
        this.setStateToREADYFORTESTING();
    }

    @Override
    public void notifyTesters(String message) {
        System.out.println("Cannont perform this action in this state");
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
        if(this.backlogItem.getDeveloper() != null){
            //DONE?: observer pattern voor michel
            String message = "Developer for backlogitem has been changed from "
                                + this.backlogItem.getDeveloper() + " to " + developer;

           this.notifyScrumMaster(message);
        }
        this.backlogItem.addDeveloper(developer);
        this.setStateToDOING();
    }

    @Override
    public void addDeveloperToActivity(DeveloperUser developer, Activity activity) throws Exception {

        for(int i = 0; i< this.backlogItem.getActivities().size()-1; i++){
            if(this.backlogItem.getActivities().get(i) == activity && this.backlogItem.getActivities().get(i).getDeveloper() != null){
                //DONE?: observer pattern voor michel
                String message = "Developer for activity " + activity +
                                    "  has been changed from " + this.backlogItem.getDeveloper() +
                                    " to " + developer;
                this.notifyScrumMaster(message);
            }
        }

        this.backlogItem.addDeveloperToActivity(developer, activity);
        this.setStateToDOING();
    }

    @Override
    public void addTester(TesterUser tester) {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void setStateToTODO() {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void setStateToDOING() {
        System.out.println("Cannont perform this action in this state");
    }

    @Override
    public void setStateToREADYFORTESTING() {
        this.backlogItem.setState(this.backlogItem.getBacklogItemReadyForTestingState());
    }

    @Override
    public void setStateToTESTING() {
        System.out.println("Cannont perform this action in this state");
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

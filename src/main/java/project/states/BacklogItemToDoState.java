package main.java.project.states;

import main.java.notification.BaseNotificationSubscriber;
import main.java.notification.behaviours.INotificationBehaviour;
import main.java.notification.behaviours.StdOutNotificationBehaviour;
import main.java.project.Activity;
import main.java.project.BacklogItem;
import main.java.user.DeveloperUser;
import main.java.user.TesterUser;

import java.util.List;

public class BacklogItemToDoState extends BaseNotificationSubscriber implements BacklogItemState {

    BacklogItem backlogItem;

    public BacklogItemToDoState(BacklogItem backlogItem){
        this.backlogItem = backlogItem;
    }

    @Override
    public void notifyScrumMaster(String message) {
        //DONE?: michel observer pattern
        this.update(message);
    }

    @Override
    public void splitInActivities(List<Activity> activities) throws Exception {
        this.backlogItem.setActivities(activities);
        this.backlogItem.setDeveloper(null);
        this.backlogItem.setTester(null);
    }

    @Override
    public void addActiviy(Activity activity) throws Exception {
        List<Activity> activities;
        activities = this.backlogItem.getActivities();
        activities.add(activity);
        backlogItem.setActivities(activities);
        backlogItem.setDeveloper(null);
        backlogItem.setTester(null);
    }

    @Override
    public void setDeveloped() {
        System.out.println("Cannont perform this action in this state");
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
            String message = "New developer has been added to backlog: "+ developer;
            this.update(message);
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
                        "  has been added " + developer;
                this.update(message);
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
        //TODO: Kan alleen wanneer er een dev aan is toegewezen.
        this.backlogItem.setState(this.backlogItem.getBacklogItemDoingState());
    }

    @Override
    public void setStateToREADYFORTESTING() {
        System.out.println("Cannont perform this action in this state");
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

package main.java.project.states;

import main.java.project.Activity;
import main.java.project.BacklogItem;
import main.java.user.DeveloperUser;
import main.java.user.TesterUser;

import java.util.List;

public class BacklogItemToDoState implements BacklogItemState{

    BacklogItem backlogItem;

    public BacklogItemToDoState(BacklogItem backlogItem){
        this.backlogItem = backlogItem;
    }

    @Override
    public void notifyScrumMaster(String message) {
        //TODO: michel observer pattern
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
            //TODO: observer pattern voor michel
        }
        this.backlogItem.addDeveloper(developer);
        this.setStateToDOING();
    }

    @Override
    public void addDeveloperToActivity(DeveloperUser developer, Activity activity) throws Exception {

        for(int i = 0; i< this.backlogItem.getActivities().size()-1; i++){
            if(this.backlogItem.getActivities().get(i) == activity && this.backlogItem.getActivities().get(i).getDeveloper() != null){
                //TODO: observer pattern voor michel
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

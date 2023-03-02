package main.java.project.states;

import main.java.notification.BaseNotificationSubscriber;
import main.java.project.Activity;
import main.java.project.BacklogItem;
import main.java.user.DeveloperUser;
import main.java.user.TesterUser;

import java.util.List;

public class BacklogItemToDoState extends BaseNotificationSubscriber implements BacklogItemState {

    BacklogItem backlogItem;

    public BacklogItemToDoState(BacklogItem backlogItem){
        this.backlogItem = backlogItem;
        this.setNotificationBehaviour(this.backlogItem.getNotificationBehaviour());
    }

    @Override
    public void notifyScrumMaster(String message) {
        //DONE?: michel observer pattern

        this.getNotificationBehaviour()
                .setIdentifier(this.backlogItem
                        .getSprintBacklog()
                        .getSprint()
                        .getScrumMaster()
                        .getEmail());

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
        System.out.println();
    }

    @Override
    public void notifyTesters(String message) {
        System.out.println(stateBaseMessage);
    }

    @Override
    public void setTested() {
        System.out.println(stateBaseMessage);
    }

    @Override
    public void setDefinitionMet() {
        System.out.println(stateBaseMessage);
    }

    @Override
    public void addDeveloper(DeveloperUser developer) throws Exception {
        if(this.backlogItem.getDeveloper() != null){
            //DONE?: observer pattern voor michel
            String message = "New developer has been added to backlog: "+ developer;
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
                        "  has been added " + developer;
                this.notifyScrumMaster(message);
            }
        }

        this.backlogItem.addDeveloperToActivity(developer, activity);
        this.setStateToDOING();
    }

    @Override
    public void addTester(TesterUser tester) {
        System.out.println(stateBaseMessage);
    }

    @Override
    public void setStateToTODO() {
        System.out.println(stateBaseMessage);
    }

    @Override
    public void setStateToDOING() {
        //TODO: Kan alleen wanneer er een dev aan is toegewezen.
        this.backlogItem.setState(this.backlogItem.getBacklogItemDoingState());
    }

    @Override
    public void setStateToREADYFORTESTING() {
        System.out.println(stateBaseMessage);
    }

    @Override
    public void setStateToTESTING() {
        System.out.println(stateBaseMessage);
    }

    @Override
    public void setStateTOTESTED() {
        System.out.println(stateBaseMessage);
    }

    @Override
    public void setStateToDONE() {
        System.out.println(stateBaseMessage);
    }
}

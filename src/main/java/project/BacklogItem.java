package main.java.project;

import main.java.project.states.*;
import main.java.sprint.SprintBacklog;
import main.java.user.DeveloperUser;
import main.java.user.TesterUser;

import java.util.ArrayList;
import java.util.List;

public class BacklogItem {
    List<Activity> activities;
    ProductBacklog productBacklog;
    SprintBacklog sprintBacklog;
    DeveloperUser developer;
    TesterUser tester;
    DefinitionOfDone definitionOfDone;
    String text;
    boolean defitionMet;

    BacklogItemState state;
    BacklogItemState backlogItemToDoState;
    BacklogItemState backlogItemDoingState;
    BacklogItemState backlogItemReadyForTestingState;
    BacklogItemState backlogItemTestingState;
    BacklogItemState backlogItemTestedState;
    BacklogItemState backlogItemDoneState;

    boolean developed;
    boolean tested;

    public BacklogItem(ProductBacklog productBacklog, String text){
        this.activities = new ArrayList<Activity>();
        this.productBacklog = productBacklog;
        this.definitionOfDone = null;
        this.text = text;
        this.defitionMet = false;

        this.productBacklog.addBacklogItem(this);

        this.backlogItemToDoState = new BacklogItemToDoState(this);
        this.backlogItemDoingState = new BacklogItemDoingState(this);
        this.backlogItemReadyForTestingState = new BacklogItemReadyForTestingState(this);
        this.backlogItemTestingState = new BacklogItemTestingState(this);
        this.backlogItemTestedState = new BacklogItemTestedState(this);
        this.backlogItemDoneState = new BacklogItemDoneState(this);

        this.state = backlogItemToDoState;

        this.developed = false;
        this.tested = false;
    }

    public BacklogItemState getBacklogItemToDoState() {
        return backlogItemToDoState;
    }

    public BacklogItemState getBacklogItemDoingState() {
        return backlogItemDoingState;
    }

    public BacklogItemState getBacklogItemReadyForTestingState() {
        return backlogItemReadyForTestingState;
    }

    public BacklogItemState getBacklogItemTestingState() {
        return backlogItemTestingState;
    }

    public BacklogItemState getBacklogItemTestedState() {
        return backlogItemTestedState;
    }

    public BacklogItemState getBacklogItemDoneState() {
        return backlogItemDoneState;
    }

    public List<Activity> getActivities(){
        return this.activities;
    }

    public void setState(BacklogItemState state){
        this.state = state;
    }

    public void setStateToTODO(){
        this.state.setStateToTODO();
    }

    void setStateToDOING(){
        this.state.setStateToDOING();
    }

    void setStateToREADYFORTESTING(){
        this.state.setStateToREADYFORTESTING();
    }

    void setStateToTESTING(){
        this.state.setStateToTESTING();
    }

    void setStateTOTESTED(){
        this.state.setStateTOTESTED();
    }

    void setStateToDONE(){
        this.state.setStateToDONE();
    }

    public List<Activity> SplitInActivities(List<Activity> activities){
        this.state.splitInActivities(activities);
        return this.activities;
    }

    public List<Activity> addActivity(Activity activity){
        this.state.addActiviy(activity);
        return this.activities;
    }

    public void setActivities(List<Activity> activities){
        this.activities = activities;
    }

    public void setDeveloper(DeveloperUser developer){
        this.developer = developer;
    }

    public void setTester(TesterUser tester){
        this.tester = tester;
    }

    public void notifyScrumMaster(String message){
        this.state.notifyScrumMaster(message);
    }

    public void notifyTesters(String message){
        this.state.notifyTesters(message);
    }

    public void setDeveloped(){
        this.state.setDeveloped();
    }

    public void setTested(){
        this.state.setTested();
    }

    public void setDefinitionMet(){
        this.state.setDefinitionMet();
    }

    public void addDefinitionOfDone(DefinitionOfDone definitionOfDone){
        this.definitionOfDone = definitionOfDone;
    }

    //TODO: check if developer already is assigned
    public String addDeveloper(DeveloperUser developer){
        if(this.activities.size() == 1){
            this.activities.get(0).addDeveloper(developer);
            return "Developer added to activity of this backlog item!";
        }
        else if(this.activities.size() > 1){
            return "Developer not added. backlog item contains more than 1 activity";
        }
        else {
            this.developer = developer;
            return "Developer added!";
        }
    }

    public String addTester(TesterUser tester){
        if(this.activities.size() == 1){
            this.activities.get(0).addTester(tester);
            return "Tester added to activity of this backlog item!";
        }
        else if(this.activities.size() > 1){
            return "Developer not added. backlog item contains more than 1 activity";
        }
        else {
            this.tester = tester;
            return "tester added!";
        }
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BacklogItem{");
        sb.append("activities=").append(activities);
        sb.append(", developer=").append(developer);
        sb.append(", tester=").append(tester);
        sb.append(", definitionOfDone=").append(definitionOfDone);
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }
}


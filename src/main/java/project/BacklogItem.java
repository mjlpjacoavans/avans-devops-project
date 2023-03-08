package main.java.project;

import main.java.notification.behaviours.*;
import main.java.project.states.*;
import main.java.sprint.SprintBacklog;
import main.java.sprint.states.SprintInProgressState;
import main.java.sprint.states.SprintState;
import main.java.user.DeveloperUser;
import main.java.user.TesterUser;

import java.util.ArrayList;
import java.util.List;

public class BacklogItem implements Comparable{
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
    INotificationBehaviour notificationBehaviour;

    boolean developed;
    boolean tested;

    Integer priority;

    public DeveloperUser getDeveloper() {
        return developer;
    }

    public BacklogItem(ProductBacklog productBacklog, String text, Integer priority){
        this.activities = new ArrayList<>();
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

        this.priority = priority;
    }

    public BacklogItem(ProductBacklog productBacklog, String text, Integer priority, NotificationBehaviourTypes notificationBehaviourType){
        // TODO: TEST IF THIS ACTUALLY WORKS SINCE IT REALLY USED TO NAG ABOUT THIS
        this(productBacklog, text, priority);

        INotificationBehaviour notificationBehaviour;

        if(notificationBehaviourType == NotificationBehaviourTypes.EMAIL){
            notificationBehaviour = new EmailNotificaionBehaviour();
        }
        else if(notificationBehaviourType == NotificationBehaviourTypes.SLACK){
            notificationBehaviour = new SlackNotificaionBehaviour();
        } else if (notificationBehaviourType == NotificationBehaviourTypes.STDOUT) {
            notificationBehaviour = new StdOutNotificationBehaviour();
        }
        else{
            throw new IllegalArgumentException("Notification behaviour type not supported");
        }
        this.setNotificationBehaviour(notificationBehaviour);
    }

    public SprintBacklog getSprintBacklog() {
        return sprintBacklog;
    }

    public TesterUser getTester() {
        return tester;
    }

    public INotificationBehaviour getNotificationBehaviour() {
        return notificationBehaviour;
    }

    public void setNotificationBehaviour(INotificationBehaviour notificationBehaviour) {
        this.notificationBehaviour = notificationBehaviour;
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
        //Check if sprint state is doing. else you cant change state
        if(this.sprintBacklog.getSprint().getState() == this.sprintBacklog.getSprint().getStateInProgress()){
            this.state = state;
        }
    }

    public void setStateToTODO(){
        if(this.sprintBacklog.getSprint().getState() == this.sprintBacklog.getSprint().getStateInProgress()) {
            this.state.setStateToTODO();
        }
    }

    void setStateToDOING(){
        if(this.sprintBacklog.getSprint().getState() == this.sprintBacklog.getSprint().getStateInProgress()) {
            this.state.setStateToDOING();
        }
    }

    void setStateToREADYFORTESTING(){
        if(this.sprintBacklog.getSprint().getState() == this.sprintBacklog.getSprint().getStateInProgress()) {
            this.state.setStateToREADYFORTESTING();
        }
    }

    void setStateToTESTING(){
        if(this.sprintBacklog.getSprint().getState() == this.sprintBacklog.getSprint().getStateInProgress()) {
            this.state.setStateToTESTING();
        }
    }

    void setStateTOTESTED(){
        if(this.sprintBacklog.getSprint().getState() == this.sprintBacklog.getSprint().getStateInProgress()) {
            this.state.setStateTOTESTED();
        }
    }

    void setStateToDONE(){
//        SprintState sprintBacklogSprintState  = this.getSprintBacklog().getSprint().getState();
//        if(sprintBacklogSprintState instanceof SprintInProgressState) {
//        }
        if(this.sprintBacklog.getSprint().getState() == this.sprintBacklog.getSprint().getStateInProgress()) {
            this.state.setStateToDONE();
        }

    }

    public List<Activity> splitInActivities(List<Activity> activities) throws Exception {
        this.state.splitInActivities(activities);
        return this.activities;
    }

    public List<Activity> addActivity(Activity activity) throws Exception {
        this.state.addActiviy(activity);
        return this.activities;
    }

    public void setActivities(List<Activity> activities){
        this.activities = activities;
    }

    public void setDeveloper(DeveloperUser developer) throws Exception {
        this.state.addDeveloper(developer);
    }

    public void addDeveloper(DeveloperUser developer) throws Exception {
        if(this.activities == null) {
            this.developer = developer;
        }else{
            throw new Exception("this item has activities. please add to activity");
        }
    }

    public void addDeveloperToActivity(DeveloperUser developer, Activity activity) throws Exception {
        if(this.activities == null){
            //TODO: throw specific execption
            throw new Exception("No activities in backlogitem");
        }else{
            for (int i = 0; i<this.activities.size()-1; i++){
                Activity thisActivity = this.activities.get(i);
                if(thisActivity == activity){
                    thisActivity.addDeveloper(developer);
                    return;
                }
            }
            throw new Exception("Activity not present in backlogitem");
        }
    }

    public void setTester(TesterUser tester){
        this.state.addTester(tester);
    }

    public void addTester(TesterUser tester){
        this.tester = tester;
    }

    public void notifyScrumMaster(String message){
        this.state.notifyScrumMaster(message);
    }

    public void notifyTesters(String message){
        this.state.notifyTesters(message);
    }

    public void setDeveloped() throws Exception {
        this.state.setDeveloped();
    }

    public void setTested(){
        this.state.setTested();
    }

    public void setDefinitionMet(){
        this.state.setDefinitionMet();
    }

    public void setDevelopedStateHelper() throws Exception {
        for(int i = 0; i<this.activities.size()-1; i++){
            if(this.activities.get(i).getDeveloper() == null){
                throw new Exception("Cant set to developed. not every activity is assigned a developer");
            }
        }
        this.developed = true;
    }

    public void setTestedStateOverride(){
        this.tested = true;
    }

    public void setDefinitionMetStateOverride(){
        this.defitionMet = true;
    }

    public void addDefinitionOfDone(DefinitionOfDone definitionOfDone){
        this.definitionOfDone = definitionOfDone;
    }

//    //TODO: check if developer already is assigned
//    public String addDeveloper(DeveloperUser developer){
//        if(this.activities.size() == 1){
//            this.activities.get(0).addDeveloper(developer);
//            return "Developer added to activity of this backlog item!";
//        }
//        else if(this.activities.size() > 1){
//            return "Developer not added. backlog item contains more than 1 activity";
//        }
//        else {
//            this.developer = developer;
//            return "Developer added!";
//        }
//    }
//
//    public String addTester(TesterUser tester){
//        if(this.activities.size() == 1){
//            this.activities.get(0).addTester(tester);
//            return "Tester added to activity of this backlog item!";
//        }
//        else if(this.activities.size() > 1){
//            return "Developer not added. backlog item contains more than 1 activity";
//        }
//        else {
//            this.tester = tester;
//            return "tester added!";
//        }
//    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BacklogItem{");
        sb.append("activities=").append(activities);
        sb.append(", developer=").append(developer);
        sb.append(", tester=").append(tester);
        sb.append(", definitionOfDone=").append(definitionOfDone);
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        // TODO: Test if this is the correct order and should not be swapped
        return Integer.compare(this.priority, (Integer)o);
    }
}


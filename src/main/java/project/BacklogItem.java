package project;

import notification.behaviours.NotificationBehaviourTypes;
import project.states.*;
import sprint.Sprint;
import sprint.SprintBacklog;
import user.DeveloperUser;
import user.TesterUser;

import java.util.ArrayList;
import java.util.List;

public class BacklogItem implements Comparable<BacklogItem>{
    List<Activity> activities = new ArrayList<>();
    ProductBacklog productBacklog;
    SprintBacklog sprintBacklog;
    DeveloperUser developer;
    TesterUser tester;
    String text;
    boolean defitionMet;

    NotificationBehaviourTypes notificationBehaviourType; // = NotificationBehaviourTypes.EMAIL;
    BacklogItemState state;
    BacklogItemState backlogItemToDoState;
    BacklogItemState backlogItemDoingState;
    BacklogItemState backlogItemReadyForTestingState;
    BacklogItemState backlogItemTestingState;
    BacklogItemState backlogItemTestedState;
    BacklogItemState backlogItemDoneState;
    boolean developed;
    boolean tested;

    Integer priority;

    Sprint sprint;

    public DeveloperUser getDeveloper() {
        return developer;
    }

    public BacklogItem(ProductBacklog productBacklog,String text, Integer priority, NotificationBehaviourTypes notificationBehaviourType){
        this.notificationBehaviourType = notificationBehaviourType;

        this.productBacklog = productBacklog;
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


//    //    THIS CAN NOT BE DONE BECAUSE JAVA FOR SOME DUMB REASON DOES NOT ALLOW ANY CODE BEFORE CALLING OVERLOADED CONSTRUCTOR MAKING ITS USAGE COMPLETELEY WORTHLESS.
//    //    SUPER ANOYING, GIVES A LOT MORE CODE COMPLEXITY
//    public BacklogItem(ProductBacklog productBacklog,String text, Integer priority, NotificationBehaviourTypes notificationBehaviourType){
//        this(productBacklog, text, priority);
//
//        this.notificationBehaviourType = notificationBehaviourType;
//
////        this.setNotificationBehaviour(notificationBehaviour);
//    }

    public SprintBacklog getSprintBacklog() {
        return sprintBacklog;
    }

    public void setSprintBacklog(SprintBacklog sprintBacklog){
        this.sprintBacklog = sprintBacklog;
    }

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public TesterUser getTester() {
        return tester;
    }

    public NotificationBehaviourTypes getNotificationBehaviourType() {
        return notificationBehaviourType;
    }

    public void setNotificationBehaviourType(NotificationBehaviourTypes notificationBehaviourType) {
        this.notificationBehaviourType = notificationBehaviourType;
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

    public void setStateToDOING(){
        if(this.sprintBacklog.getSprint().getState() == this.sprintBacklog.getSprint().getStateInProgress()) {
            this.state.setStateToDOING();
        }
    }

    public void setStateToREADYFORTESTING(){
        if(this.sprintBacklog.getSprint().getState() == this.sprintBacklog.getSprint().getStateInProgress()) {
            this.state.setStateToREADYFORTESTING();
        }
    }

    public void setStateToTESTING(){
        if(this.sprintBacklog.getSprint().getState() == this.sprintBacklog.getSprint().getStateInProgress()) {
            this.state.setStateToTESTING();
        }
    }

    public void setStateTOTESTED(){
        if(this.sprintBacklog.getSprint().getState() == this.sprintBacklog.getSprint().getStateInProgress()) {
            this.state.setStateTOTESTED();
        }
    }

    public void setStateToDONE(){
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
        if(this.activities.isEmpty()) {
            this.developer = developer;
        }else{
            throw new Exception("this item has activities. please add to activity");
        }
    }

    public void addDeveloperToActivity(DeveloperUser developer, Activity activity) throws Exception {
        if(this.activities.isEmpty()){
            //SUGGESTION: throw specific execption
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

    public void setDefinitionMet(String email) throws Exception {
        this.state.setDefinitionMet(email);
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
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(BacklogItem o) {
        return Integer.compare(this.priority, o.priority);
    }

    public ProductBacklog getProductBacklog() {
        return productBacklog;
    }

    public BacklogItemState getState() {
        return state;
    }


    public boolean isDefitionMet() {
        return defitionMet;
    }

    public boolean isDeveloped() {
        return developed;
    }

    public boolean isTested() {
        return tested;
    }
}


package BacklogItem;

import notification.behaviours.NotificationBehaviourTypes;
import project.Activity;
import project.BacklogItem;
import project.ProductBacklog;
import project.Project;
import sprint.Sprint;
import sprint.SprintBacklog;
import sprint.enums.Goal;
import user.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class BacklogItemTests {
    //Backlogitem split in activities in to do pass
    @Test
    public void BACKLOGITEM_TEST_1_SplitInActivitiesSucces() throws Exception {
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("Test", "test@test.nl", "testid");
        Project project = new Project("TestProject", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test1", 1, NotificationBehaviourTypes.EMAIL);
        List<Activity> activities = new ArrayList<>();
        Activity activity1 = new Activity(backlogItem1, "testa1");
        Activity activity2 = new Activity(backlogItem1, "testa2");
        activities.add(activity1);
        activities.add(activity2);

        //Act
        backlogItem1.setActivities(activities);

        //Assert
        Assertions.assertEquals(activities, backlogItem1.getActivities());
        Assertions.assertEquals(backlogItem1.getBacklogItemToDoState(),backlogItem1.getState());
    }

    //Backlogitem split in activities doing fail
    @Test
    public void BACKLOGITEM_TEST_2_SplitInActivitiesFail() throws Exception {
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("Test", "test@test.nl", "testid");
        Project project = new Project("TestProject", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test1", 1, NotificationBehaviourTypes.EMAIL);
        List<BacklogItem> backlogItems = new ArrayList<>();
        backlogItems.add(backlogItem1);

        SprintBacklog sprintBacklog = new SprintBacklog(backlogItems);

        Date start = new Date(2022,12,30);
        Date end = new Date(2022,12,30);
        DeveloperUser dev1 = new DeveloperUser("test", "test@test.nl", "0651908789", "testid2");
        DeveloperUser[] developerUsers = new DeveloperUser[1];
        developerUsers[0] = dev1;
        TesterUser testerUser = new TesterUser("test", "test@test.nl", "0645789865", "testid3");
        TesterUser[] testerUsers = new TesterUser[1];
        testerUsers[0] = testerUser;
        LeadDeveloperUser leadDev = new LeadDeveloperUser("test", "test@test.nl", "0678906543", "testid4");
        ScrumMasterUser scrumMasterUser = new ScrumMasterUser("test", "test@test.nl", "0698765432", "testid5");
        Sprint sprint = new Sprint(Goal.REVIEW, "test", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser, NotificationBehaviourTypes.EMAIL);

        sprint.setStateToSprintInProgress();

        List<Activity> activities = new ArrayList<>();
        Activity activity1 = new Activity(backlogItem1, "testa1");
        Activity activity2 = new Activity(backlogItem1, "testa2");
        activities.add(activity1);
        activities.add(activity2);

        //Act
        backlogItem1.setActivities(activities);

        //Assert
        Assertions.assertEquals(null, backlogItem1.getActivities());
        Assertions.assertEquals(backlogItem1.getBacklogItemToDoState(),backlogItem1.getState());
    }

//    //Backlogitem addactivity in to do pass
//    @Test
//    public void BACKLOGITEM_TEST_3_AddActivitySucces(){
//
//    }
//
//    //Backlogitem addActivity in done fail
//    @Test
//    public void BACKLOGITEM_TEST_4_AddActivityFail(){
//
//    }

    //Backlogitem adddeveloper in to do pass
    @Test
    public void BACKLOGITEM_TEST_3_AddDeveloperSucces() throws Exception {
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("Test", "test@test.nl", "testid");
        Project project = new Project("TestProject", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test1", 1, NotificationBehaviourTypes.EMAIL);
        List<BacklogItem> backlogItems = new ArrayList<>();
        backlogItems.add(backlogItem1);

        SprintBacklog sprintBacklog = new SprintBacklog(backlogItems);

        Date start = new Date(2022,12,30);
        Date end = new Date(2022,12,30);
        DeveloperUser dev1 = new DeveloperUser("test", "test@test.nl", "0651908789", "testid2");
        DeveloperUser[] developerUsers = new DeveloperUser[1];
        developerUsers[0] = dev1;
        TesterUser testerUser = new TesterUser("test", "test@test.nl", "0645789865", "testid3");
        TesterUser[] testerUsers = new TesterUser[1];
        testerUsers[0] = testerUser;
        LeadDeveloperUser leadDev = new LeadDeveloperUser("test", "test@test.nl", "0678906543", "testid4");
        ScrumMasterUser scrumMasterUser = new ScrumMasterUser("test", "test@test.nl", "0698765432", "testid5");
        Sprint sprint = new Sprint(Goal.REVIEW, "test", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser, NotificationBehaviourTypes.EMAIL);

        //Act
        backlogItem1.setDeveloper(dev1);

        //Assert
        Assertions.assertEquals(dev1, backlogItem1.getDeveloper());
        Assertions.assertEquals(backlogItem1.getBacklogItemDoingState(),backlogItem1.getState());
    }

    //Backlogitem add developer in ready for testing fail
    @Test
    public void BACKLOGITEM_TEST_4_AddDeveloperFail() throws Exception {
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("Test", "test@test.nl", "testid");
        Project project = new Project("TestProject", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test1", 1, NotificationBehaviourTypes.EMAIL);
        List<BacklogItem> backlogItems = new ArrayList<>();
        backlogItems.add(backlogItem1);

        SprintBacklog sprintBacklog = new SprintBacklog(backlogItems);

        Date start = new Date(2022,12,30);
        Date end = new Date(2022,12,30);
        DeveloperUser dev1 = new DeveloperUser("test", "test@test.nl", "0651908789", "testid2");
        DeveloperUser[] developerUsers = new DeveloperUser[2];
        developerUsers[0] = dev1;
        TesterUser testerUser = new TesterUser("test", "test@test.nl", "0645789865", "testid3");
        TesterUser[] testerUsers = new TesterUser[1];
        testerUsers[0] = testerUser;
        LeadDeveloperUser leadDev = new LeadDeveloperUser("test", "test@test.nl", "0678906543", "testid4");
        ScrumMasterUser scrumMasterUser = new ScrumMasterUser("test", "test@test.nl", "0698765432", "testid5");
        Sprint sprint = new Sprint(Goal.REVIEW, "test", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser, NotificationBehaviourTypes.EMAIL);

        sprint.setStateToSprintInProgress();

        backlogItem1.setDeveloper(dev1);

        backlogItem1.setDeveloped();

        DeveloperUser dev2 = new DeveloperUser("test2", "test2@test.nl", "0651908780", "testid22");
        developerUsers[1] = dev2;

        //Act
        backlogItem1.setDeveloper(dev2);

        //Assert
        Assertions.assertEquals(dev1, backlogItem1.getDeveloper());
        Assertions.assertEquals(backlogItem1.getBacklogItemReadyForTestingState(),backlogItem1.getState());
        //Todo: Michel zou jij de exception ook kunnen toevoegen die wordt gethrowed? Weet niet hoe je die assert. Als je denkt dat die niet nodig is kun je deze comment negeren.

    }

//    //Backlogitem add dev to activity in to do pass
//    @Test
//    public void BACKLOGITEM_TEST_7_AddDeveloperToActivitySucces(){
//
//    }
//
//    //Backlogitem add dev to activity in done fail
//    @Test
//    public void BACKLOGITEM_TEST_8_AddDeveloperToActivityFail(){
//
//    }

//    //Backlog item set state to doing with dev assigned pass
//    @Test
//    public void BACKLOGITEM_TEST_5_SetStateToDoingWithDevAssignPass() throws Exception {
//        //Arrange
//        ProductOwnerUser productOwnerUser = new ProductOwnerUser("Test", "test@test.nl", "testid");
//        Project project = new Project("TestProject", productOwnerUser);
//        ProductBacklog productBacklog = new ProductBacklog(project);
//
//        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test1", 1, NotificationBehaviourTypes.EMAIL);
//        List<BacklogItem> backlogItems = new ArrayList<>();
//        backlogItems.add(backlogItem1);
//
//        SprintBacklog sprintBacklog = new SprintBacklog(backlogItems);
//
//        Date start = new Date(2022,12,30);
//        Date end = new Date(2022,12,30);
//        DeveloperUser dev1 = new DeveloperUser("test", "test@test.nl", "0651908789", "testid2");
//        DeveloperUser[] developerUsers = new DeveloperUser[1];
//        developerUsers[0] = dev1;
//        TesterUser testerUser = new TesterUser("test", "test@test.nl", "0645789865", "testid3");
//        TesterUser[] testerUsers = new TesterUser[1];
//        testerUsers[0] = testerUser;
//        LeadDeveloperUser leadDev = new LeadDeveloperUser("test", "test@test.nl", "0678906543", "testid4");
//        ScrumMasterUser scrumMasterUser = new ScrumMasterUser("test", "test@test.nl", "0698765432", "testid5");
//        Sprint sprint = new Sprint(Goal.REVIEW, "test", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser, NotificationBehaviourTypes.EMAIL);
//
//        sprint.setStateToSprintInProgress();
//
//        backlogItem1.setDeveloper(dev1);
//
//        //Act
//        backlogItem1.setStateToDOING();
//
//        //Assert
//    }
//
//    //BacklogItem set state to doing with no dev assigned fail
//    @Test
//    public void BACKLOGITEM_TEST_6_SetStateToDoingWithNoDevAssignFail(){
//        //Arrange
//        ProductOwnerUser productOwnerUser = new ProductOwnerUser("Test", "test@test.nl", "testid");
//        Project project = new Project("TestProject", productOwnerUser);
//        ProductBacklog productBacklog = new ProductBacklog(project);
//
//        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test1", 1, NotificationBehaviourTypes.EMAIL);
//        List<BacklogItem> backlogItems = new ArrayList<>();
//        backlogItems.add(backlogItem1);
//
//        SprintBacklog sprintBacklog = new SprintBacklog(backlogItems);
//
//        Date start = new Date(2022,12,30);
//        Date end = new Date(2022,12,30);
//        DeveloperUser dev1 = new DeveloperUser("test", "test@test.nl", "0651908789", "testid2");
//        DeveloperUser[] developerUsers = new DeveloperUser[1];
//        developerUsers[0] = dev1;
//        TesterUser testerUser = new TesterUser("test", "test@test.nl", "0645789865", "testid3");
//        TesterUser[] testerUsers = new TesterUser[1];
//        testerUsers[0] = testerUser;
//        LeadDeveloperUser leadDev = new LeadDeveloperUser("test", "test@test.nl", "0678906543", "testid4");
//        ScrumMasterUser scrumMasterUser = new ScrumMasterUser("test", "test@test.nl", "0698765432", "testid5");
//        Sprint sprint = new Sprint(Goal.REVIEW, "test", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser, NotificationBehaviourTypes.EMAIL);
//
//        sprint.setStateToSprintInProgress();
//
//        //Act
//        backlogItem1.setStateToDOING();
//
//        //Assert
//    }

//    //BacklogItem set developed in state doing pass
//    @Test
//    public void BACKLOGITEM_TEST_11_SetDevelopedPass(){
//
//    }
//
//    //BacklogItem set developed in state done fail
//    @Test
//    public void BACKLOGITEM_TEST_12_SetDevelopedFail(){
//
//    }

    //Backlogitem set state to ready for testing pass
    @Test
    public void BACKLOGITEM_TEST_5_SetStateToReadyForTestingPass() throws Exception {
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("Test", "test@test.nl", "testid");
        Project project = new Project("TestProject", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test1", 1, NotificationBehaviourTypes.EMAIL);
        List<BacklogItem> backlogItems = new ArrayList<>();
        backlogItems.add(backlogItem1);

        SprintBacklog sprintBacklog = new SprintBacklog(backlogItems);

        Date start = new Date(2022,12,30);
        Date end = new Date(2022,12,30);
        DeveloperUser dev1 = new DeveloperUser("test", "test@test.nl", "0651908789", "testid2");
        DeveloperUser[] developerUsers = new DeveloperUser[2];
        developerUsers[0] = dev1;
        TesterUser testerUser = new TesterUser("test", "test@test.nl", "0645789865", "testid3");
        TesterUser[] testerUsers = new TesterUser[1];
        testerUsers[0] = testerUser;
        LeadDeveloperUser leadDev = new LeadDeveloperUser("test", "test@test.nl", "0678906543", "testid4");
        ScrumMasterUser scrumMasterUser = new ScrumMasterUser("test", "test@test.nl", "0698765432", "testid5");
        Sprint sprint = new Sprint(Goal.REVIEW, "test", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser, NotificationBehaviourTypes.EMAIL);

        sprint.setStateToSprintInProgress();

        backlogItem1.setDeveloper(dev1);

        //Act
        backlogItem1.setDeveloped();

        //Assert
        Assertions.assertEquals(true, backlogItem1.isDeveloped());
        Assertions.assertEquals(backlogItem1.getBacklogItemReadyForTestingState(),backlogItem1.getState());
    }

    //Backlog item add tester in ready for testing pass
    @Test
    public void BACKLOGITEM_TEST_6_AddTesterPass() throws Exception {
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("Test", "test@test.nl", "testid");
        Project project = new Project("TestProject", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test1", 1, NotificationBehaviourTypes.EMAIL);
        List<BacklogItem> backlogItems = new ArrayList<>();
        backlogItems.add(backlogItem1);

        SprintBacklog sprintBacklog = new SprintBacklog(backlogItems);

        Date start = new Date(2022,12,30);
        Date end = new Date(2022,12,30);
        DeveloperUser dev1 = new DeveloperUser("test", "test@test.nl", "0651908789", "testid2");
        DeveloperUser[] developerUsers = new DeveloperUser[2];
        developerUsers[0] = dev1;
        TesterUser testerUser = new TesterUser("test", "test@test.nl", "0645789865", "testid3");
        TesterUser[] testerUsers = new TesterUser[1];
        testerUsers[0] = testerUser;
        LeadDeveloperUser leadDev = new LeadDeveloperUser("test", "test@test.nl", "0678906543", "testid4");
        ScrumMasterUser scrumMasterUser = new ScrumMasterUser("test", "test@test.nl", "0698765432", "testid5");
        Sprint sprint = new Sprint(Goal.REVIEW, "test", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser, NotificationBehaviourTypes.EMAIL);

        sprint.setStateToSprintInProgress();

        backlogItem1.setDeveloper(dev1);

        backlogItem1.setDeveloped();

        //Act
        backlogItem1.addTester(testerUser);

        //Assert
        Assertions.assertEquals(testerUser, backlogItem1.getTester());
        Assertions.assertEquals(backlogItem1.getBacklogItemTestingState(),backlogItem1.getState());
    }

    //BacklogItem add tester in done fail
    @Test
    public void BACKLOGITEM_TEST_7_AddTesterFail() throws Exception {
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("Test", "test@test.nl", "testid");
        Project project = new Project("TestProject", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test1", 1, NotificationBehaviourTypes.EMAIL);
        List<BacklogItem> backlogItems = new ArrayList<>();
        backlogItems.add(backlogItem1);

        SprintBacklog sprintBacklog = new SprintBacklog(backlogItems);

        Date start = new Date(2022,12,30);
        Date end = new Date(2022,12,30);
        DeveloperUser dev1 = new DeveloperUser("test", "test@test.nl", "0651908789", "testid2");
        DeveloperUser[] developerUsers = new DeveloperUser[2];
        developerUsers[0] = dev1;
        TesterUser testerUser = new TesterUser("test", "test@test.nl", "0645789865", "testid3");
        TesterUser[] testerUsers = new TesterUser[2];
        testerUsers[0] = testerUser;
        LeadDeveloperUser leadDev = new LeadDeveloperUser("test", "test@test.nl", "0678906543", "testid4");
        ScrumMasterUser scrumMasterUser = new ScrumMasterUser("test", "test@test.nl", "0698765432", "testid5");
        Sprint sprint = new Sprint(Goal.REVIEW, "test", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser, NotificationBehaviourTypes.EMAIL);

        sprint.setStateToSprintInProgress();

        backlogItem1.setDeveloper(dev1);

        backlogItem1.setDeveloped();

        backlogItem1.addTester(testerUser);

        TesterUser testerUser2 = new TesterUser("test2", "test2@test.nl", "0745789865", "testid32");
        testerUsers[1] = testerUser2;

        //Act
        backlogItem1.addTester(testerUser2);

        //Assert
        Assertions.assertEquals(testerUser, backlogItem1.getTester());
        Assertions.assertEquals(backlogItem1.getBacklogItemTestingState(),backlogItem1.getState());
    }

//    //backlogItem set state to testing in ready for testing pass
//    @Test
//    public void BACKLOGITEM_TEST_8_SetStateToTestingPass() throws Exception {
//        //Arrange
//        ProductOwnerUser productOwnerUser = new ProductOwnerUser("Test", "test@test.nl", "testid");
//        Project project = new Project("TestProject", productOwnerUser);
//        ProductBacklog productBacklog = new ProductBacklog(project);
//
//        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test1", 1, NotificationBehaviourTypes.EMAIL);
//        List<BacklogItem> backlogItems = new ArrayList<>();
//        backlogItems.add(backlogItem1);
//
//        SprintBacklog sprintBacklog = new SprintBacklog(backlogItems);
//
//        Date start = new Date(2022,12,30);
//        Date end = new Date(2022,12,30);
//        DeveloperUser dev1 = new DeveloperUser("test", "test@test.nl", "0651908789", "testid2");
//        DeveloperUser[] developerUsers = new DeveloperUser[2];
//        developerUsers[0] = dev1;
//        TesterUser testerUser = new TesterUser("test", "test@test.nl", "0645789865", "testid3");
//        TesterUser[] testerUsers = new TesterUser[1];
//        testerUsers[0] = testerUser;
//        LeadDeveloperUser leadDev = new LeadDeveloperUser("test", "test@test.nl", "0678906543", "testid4");
//        ScrumMasterUser scrumMasterUser = new ScrumMasterUser("test", "test@test.nl", "0698765432", "testid5");
//        Sprint sprint = new Sprint(Goal.REVIEW, "test", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser, NotificationBehaviourTypes.EMAIL);
//
//        sprint.setStateToSprintInProgress();
//
//        backlogItem1.setDeveloper(dev1);
//
//        backlogItem1.setStateToDOING();
//
//        backlogItem1.setDeveloped();
//
//        backlogItem1.setStateToREADYFORTESTING();
//
//        backlogItem1.addTester(testerUser);
//
//        //Act
//        backlogItem1.setStateToTESTING();
//
//        //Assert
//    }

    @Test
    public void BACKLOGITEM_TEST_8_SetStateToTestedPass() throws Exception {
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("Test", "test@test.nl", "testid");
        Project project = new Project("TestProject", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test1", 1, NotificationBehaviourTypes.EMAIL);
        List<BacklogItem> backlogItems = new ArrayList<>();
        backlogItems.add(backlogItem1);

        SprintBacklog sprintBacklog = new SprintBacklog(backlogItems);

        Date start = new Date(2022,12,30);
        Date end = new Date(2022,12,30);
        DeveloperUser dev1 = new DeveloperUser("test", "test@test.nl", "0651908789", "testid2");
        DeveloperUser[] developerUsers = new DeveloperUser[2];
        developerUsers[0] = dev1;
        TesterUser testerUser = new TesterUser("test", "test@test.nl", "0645789865", "testid3");
        TesterUser[] testerUsers = new TesterUser[1];
        testerUsers[0] = testerUser;
        LeadDeveloperUser leadDev = new LeadDeveloperUser("test", "test@test.nl", "0678906543", "testid4");
        ScrumMasterUser scrumMasterUser = new ScrumMasterUser("test", "test@test.nl", "0698765432", "testid5");
        Sprint sprint = new Sprint(Goal.REVIEW, "test", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser, NotificationBehaviourTypes.EMAIL);

        sprint.setStateToSprintInProgress();

        backlogItem1.setDeveloper(dev1);

        backlogItem1.setDeveloped();

        backlogItem1.addTester(testerUser);

        //Act
        backlogItem1.setTested();

        //Assert
        Assertions.assertEquals(true, backlogItem1.isTested());
        Assertions.assertEquals(backlogItem1.getBacklogItemTestedState(),backlogItem1.getState());
    }

//    //backlogitem set tested in testing pass
//    @Test
//    public void BACKLOGITEM_TEST_17_SetTestedPass(){
//
//    }
//
//    //Backlogitem set state to tested pass
//    @Test
//    public void BACKLOGITEM_TEST_18_SetStateToTestedPass(){
//
//    }

    //Backlogitem set definition met with lead dev pass
    @Test
    public void BACKLOGITEM_TEST_9_SetDefinitionPass() throws Exception {
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("Test", "test@test.nl", "testid");
        Project project = new Project("TestProject", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test1", 1, NotificationBehaviourTypes.EMAIL);
        List<BacklogItem> backlogItems = new ArrayList<>();
        backlogItems.add(backlogItem1);

        SprintBacklog sprintBacklog = new SprintBacklog(backlogItems);

        Date start = new Date(2022,12,30);
        Date end = new Date(2022,12,30);
        DeveloperUser dev1 = new DeveloperUser("test", "test@test.nl", "0651908789", "testid2");
        DeveloperUser[] developerUsers = new DeveloperUser[2];
        developerUsers[0] = dev1;
        TesterUser testerUser = new TesterUser("test", "test@test.nl", "0645789865", "testid3");
        TesterUser[] testerUsers = new TesterUser[1];
        testerUsers[0] = testerUser;
        LeadDeveloperUser leadDev = new LeadDeveloperUser("test", "testlead@test.nl", "0678906543", "testid4");
        ScrumMasterUser scrumMasterUser = new ScrumMasterUser("test", "test@test.nl", "0698765432", "testid5");
        Sprint sprint = new Sprint(Goal.REVIEW, "test", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser, NotificationBehaviourTypes.EMAIL);

        sprint.setStateToSprintInProgress();

        backlogItem1.setDeveloper(dev1);

        backlogItem1.setDeveloped();

        backlogItem1.addTester(testerUser);

        backlogItem1.setTested();

        //Act
        backlogItem1.setDefinitionMet(leadDev.getEmail());

        //Assert
        Assertions.assertEquals(true, backlogItem1.isDefitionMet());
        Assertions.assertEquals(backlogItem1.getBacklogItemDoneState(),backlogItem1.getState());
    }

    //BacklogItem set definitionmet met ongeldige lead dev fail
    @Test
    public void BACKLOGITEM_TEST_10_SetDefinitionFail() throws Exception {
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("Test", "test@test.nl", "testid");
        Project project = new Project("TestProject", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test1", 1, NotificationBehaviourTypes.EMAIL);
        List<BacklogItem> backlogItems = new ArrayList<>();
        backlogItems.add(backlogItem1);

        SprintBacklog sprintBacklog = new SprintBacklog(backlogItems);

        Date start = new Date(2022,12,30);
        Date end = new Date(2022,12,30);
        DeveloperUser dev1 = new DeveloperUser("test", "test@test.nl", "0651908789", "testid2");
        DeveloperUser[] developerUsers = new DeveloperUser[2];
        developerUsers[0] = dev1;
        TesterUser testerUser = new TesterUser("test", "test@test.nl", "0645789865", "testid3");
        TesterUser[] testerUsers = new TesterUser[1];
        testerUsers[0] = testerUser;
        LeadDeveloperUser leadDev = new LeadDeveloperUser("test", "testlead@test.nl", "0678906543", "testid4");
        ScrumMasterUser scrumMasterUser = new ScrumMasterUser("test", "test@test.nl", "0698765432", "testid5");
        Sprint sprint = new Sprint(Goal.REVIEW, "test", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser, NotificationBehaviourTypes.EMAIL);

        sprint.setStateToSprintInProgress();

        backlogItem1.setDeveloper(dev1);

        backlogItem1.setDeveloped();

        backlogItem1.addTester(testerUser);

        backlogItem1.setTested();

        String emailFalse = "FalseEmail@Email.nl";
        backlogItem1.setDefinitionMet(emailFalse);

        //Assert
        Assertions.assertEquals(false, backlogItem1.isDefitionMet());
        Assertions.assertEquals(backlogItem1.getBacklogItemTestedState(),backlogItem1.getState());
    }

//    //Backlogitem set state to done pass
//    @Test
//    public void BACKLOGITEM_TEST_11_SetStateToDonePass() throws Exception {
//        //Arrange
//        ProductOwnerUser productOwnerUser = new ProductOwnerUser("Test", "test@test.nl", "testid");
//        Project project = new Project("TestProject", productOwnerUser);
//        ProductBacklog productBacklog = new ProductBacklog(project);
//
//        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test1", 1, NotificationBehaviourTypes.EMAIL);
//        List<BacklogItem> backlogItems = new ArrayList<>();
//        backlogItems.add(backlogItem1);
//
//        SprintBacklog sprintBacklog = new SprintBacklog(backlogItems);
//
//        Date start = new Date(2022,12,30);
//        Date end = new Date(2022,12,30);
//        DeveloperUser dev1 = new DeveloperUser("test", "test@test.nl", "0651908789", "testid2");
//        DeveloperUser[] developerUsers = new DeveloperUser[2];
//        developerUsers[0] = dev1;
//        TesterUser testerUser = new TesterUser("test", "test@test.nl", "0645789865", "testid3");
//        TesterUser[] testerUsers = new TesterUser[1];
//        testerUsers[0] = testerUser;
//        LeadDeveloperUser leadDev = new LeadDeveloperUser("test", "testlead@test.nl", "0678906543", "testid4");
//        ScrumMasterUser scrumMasterUser = new ScrumMasterUser("test", "test@test.nl", "0698765432", "testid5");
//        Sprint sprint = new Sprint(Goal.REVIEW, "test", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser, NotificationBehaviourTypes.EMAIL);
//
//        sprint.setStateToSprintInProgress();
//
//        backlogItem1.setDeveloper(dev1);
//
//        backlogItem1.setStateToDOING();
//
//        backlogItem1.setDeveloped();
//
//        backlogItem1.setStateToREADYFORTESTING();
//
//        backlogItem1.addTester(testerUser);
//
//        backlogItem1.setStateToTESTING();
//
//        backlogItem1.setTested();
//
//        backlogItem1.setStateTOTESTED();
//
//        backlogItem1.setDefinitionMet(leadDev.getEmail());
//
//        //Act
//        backlogItem1.setStateToDONE();
//
//        //Assert
//    }
}

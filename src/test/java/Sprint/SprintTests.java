package Sprint;

import notification.behaviours.NotificationBehaviourTypes;
import org.junit.jupiter.api.Assertions;
import project.BacklogItem;
import project.ProductBacklog;
import project.Project;
import sprint.Sprint;
import sprint.SprintBacklog;
import sprint.enums.Goal;
import user.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SprintTests {

    @Test
    public void SPRINT_TEST_1_StateToInProgressSuccesfull() throws Exception {
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("TestPO", "testPo@email.com", "testId1");
        Project project = new Project("project", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test", 1, NotificationBehaviourTypes.EMAIL);
        List<BacklogItem>backlogItems = new ArrayList<>();
        backlogItems.add(backlogItem1);
        SprintBacklog sprintBacklog = new SprintBacklog(backlogItems);

        DeveloperUser dev1 = new DeveloperUser("dev1", "dev12email.com", "0612345678", "testId2");
        DeveloperUser[] developerUsers = new DeveloperUser[1];
        developerUsers[0] = dev1;

        TesterUser tester1 = new TesterUser("tester1", "tester1@email.com", "0623456789", "testId3");
        TesterUser[] testerUsers = new TesterUser[1];
        testerUsers[0] = tester1;

        LeadDeveloperUser leadDev = new LeadDeveloperUser("leaddev", "leaddev@email.com", "0634567890", "testId4");
        ScrumMasterUser scrumMasterUser = new ScrumMasterUser("scrum", "scrum@email.com", "0645678901", "testId5");

        Date start = new Date(2022,12,30);
        Date end = new Date(2022,12,30);

        Sprint sprint = new Sprint(Goal.REVIEW, "sprintName", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser, NotificationBehaviourTypes.EMAIL);
        sprint.addSprintBacklog(sprintBacklog);

        //Act
        sprint.setStateToSprintInProgress();

        //Assert
        Assertions.assertEquals(sprint.getSprintInProgressState(), sprint.getState());
        //todo: check miss of start date al geweest is

    }
    @Test
    public void SPRINT_TEST_2_StateToInProgressBeforeStartDateFail() throws Exception {
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("TestPO", "testPo@email.com", "testId1");
        Project project = new Project("project", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test", 1, NotificationBehaviourTypes.EMAIL);
        List<BacklogItem>backlogItems = new ArrayList<>();
        backlogItems.add(backlogItem1);
        SprintBacklog sprintBacklog = new SprintBacklog(backlogItems);

        DeveloperUser dev1 = new DeveloperUser("dev1", "dev12email.com", "0612345678", "testId2");
        DeveloperUser[] developerUsers = new DeveloperUser[1];
        developerUsers[0] = dev1;

        TesterUser tester1 = new TesterUser("tester1", "tester1@email.com", "0623456789", "testId3");
        TesterUser[] testerUsers = new TesterUser[1];
        testerUsers[0] = tester1;

        LeadDeveloperUser leadDev = new LeadDeveloperUser("leaddev", "leaddev@email.com", "0634567890", "testId4");
        ScrumMasterUser scrumMasterUser = new ScrumMasterUser("scrum", "scrum@email.com", "0645678901", "testId5");

        Date start = new Date(2023,12,30);
        Date end = new Date(2023,12,30);

        Sprint sprint = new Sprint(Goal.REVIEW, "sprintName", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser, NotificationBehaviourTypes.EMAIL);
        sprint.addSprintBacklog(sprintBacklog);

        //Act
        Assertions.assertThrows(Exception.class, () -> {
            sprint.setStateToSprintInProgress();
        });

        //Assert
        Assertions.assertEquals(sprint.getSprintInitialisedState(), sprint.getState());

    }

    @Test
    public void SPRINT_TEST_3_NameChangeSucces() throws Exception {
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("TestPO", "testPo@email.com", "testId1");
        Project project = new Project("project", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test", 1, NotificationBehaviourTypes.EMAIL);
        List<BacklogItem>backlogItems = new ArrayList<>();
        backlogItems.add(backlogItem1);
        SprintBacklog sprintBacklog = new SprintBacklog(backlogItems);

        DeveloperUser dev1 = new DeveloperUser("dev1", "dev12email.com", "0612345678", "testId2");
        DeveloperUser[] developerUsers = new DeveloperUser[1];
        developerUsers[0] = dev1;

        TesterUser tester1 = new TesterUser("tester1", "tester1@email.com", "0623456789", "testId3");
        TesterUser[] testerUsers = new TesterUser[1];
        testerUsers[0] = tester1;

        LeadDeveloperUser leadDev = new LeadDeveloperUser("leaddev", "leaddev@email.com", "0634567890", "testId4");
        ScrumMasterUser scrumMasterUser = new ScrumMasterUser("scrum", "scrum@email.com", "0645678901", "testId5");

        Date start = new Date(2022,12,30);
        Date end = new Date(2022,12,30);

        Sprint sprint = new Sprint(Goal.REVIEW, "sprintName", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser, NotificationBehaviourTypes.EMAIL);
        sprint.addSprintBacklog(sprintBacklog);

        //Act
        sprint.setName("SprintNameNew");

        //Assert
        Assertions.assertEquals(sprint.getSprintInitialisedState(), sprint.getState());
        Assertions.assertEquals("SprintNameNew", sprint.getName());
    }

    @Test
    public void SPRINT_TEST_4_NameChangeFail() throws Exception {
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("TestPO", "testPo@email.com", "testId1");
        Project project = new Project("project", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test", 1, NotificationBehaviourTypes.EMAIL);
        List<BacklogItem>backlogItems = new ArrayList<>();
        backlogItems.add(backlogItem1);
        SprintBacklog sprintBacklog = new SprintBacklog(backlogItems);

        DeveloperUser dev1 = new DeveloperUser("dev1", "dev12email.com", "0612345678", "testId2");
        DeveloperUser[] developerUsers = new DeveloperUser[1];
        developerUsers[0] = dev1;

        TesterUser tester1 = new TesterUser("tester1", "tester1@email.com", "0623456789", "testId3");
        TesterUser[] testerUsers = new TesterUser[1];
        testerUsers[0] = tester1;

        LeadDeveloperUser leadDev = new LeadDeveloperUser("leaddev", "leaddev@email.com", "0634567890", "testId4");
        ScrumMasterUser scrumMasterUser = new ScrumMasterUser("scrum", "scrum@email.com", "0645678901", "testId5");

        Date start = new Date(2022,12,30);
        Date end = new Date(2022,12,30);

        Sprint sprint = new Sprint(Goal.REVIEW, "sprintName", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser, NotificationBehaviourTypes.EMAIL);
        sprint.addSprintBacklog(sprintBacklog);

        sprint.setStateToSprintInProgress();

        //Act
        Assertions.assertThrows(Exception.class, () -> {
            sprint.setName("sprintNameNewShouldFail");
        });

        //Assert
        Assertions.assertEquals(sprint.getSprintInProgressState(), sprint.getState());
        Assertions.assertEquals("sprintName", sprint.getName());

    }

    @Test
    public void SPRINT_TEST_5_SetStateToFinishedSucces() throws Exception {
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("TestPO", "testPo@email.com", "testId1");
        Project project = new Project("project", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test", 1, NotificationBehaviourTypes.EMAIL);
        List<BacklogItem>backlogItems = new ArrayList<>();
        backlogItems.add(backlogItem1);
        SprintBacklog sprintBacklog = new SprintBacklog(backlogItems);

        DeveloperUser dev1 = new DeveloperUser("dev1", "dev12email.com", "0612345678", "testId2");
        DeveloperUser[] developerUsers = new DeveloperUser[1];
        developerUsers[0] = dev1;

        TesterUser tester1 = new TesterUser("tester1", "tester1@email.com", "0623456789", "testId3");
        TesterUser[] testerUsers = new TesterUser[1];
        testerUsers[0] = tester1;

        LeadDeveloperUser leadDev = new LeadDeveloperUser("leaddev", "leaddev@email.com", "0634567890", "testId4");
        ScrumMasterUser scrumMasterUser = new ScrumMasterUser("scrum", "scrum@email.com", "0645678901", "testId5");

        Date start = new Date(2022,12,30);
        Date end = new Date(2022,12,30);

        Sprint sprint = new Sprint(Goal.REVIEW, "sprintName", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser, NotificationBehaviourTypes.EMAIL);
        sprint.addSprintBacklog(sprintBacklog);

        sprint.setStateToSprintInProgress();

        //Act
        sprint.setStateToSprintFinished();

        //Assert
        Assertions.assertEquals(sprint.getSprintFinishedState(), sprint.getState());
    }

    @Test
    public void SPRINT_TEST_6_SetStateToFinishedFail() throws Exception {
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("TestPO", "testPo@email.com", "testId1");
        Project project = new Project("project", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test", 1, NotificationBehaviourTypes.EMAIL);
        List<BacklogItem>backlogItems = new ArrayList<>();
        backlogItems.add(backlogItem1);
        SprintBacklog sprintBacklog = new SprintBacklog(backlogItems);

        DeveloperUser dev1 = new DeveloperUser("dev1", "dev12email.com", "0612345678", "testId2");
        DeveloperUser[] developerUsers = new DeveloperUser[1];
        developerUsers[0] = dev1;

        TesterUser tester1 = new TesterUser("tester1", "tester1@email.com", "0623456789", "testId3");
        TesterUser[] testerUsers = new TesterUser[1];
        testerUsers[0] = tester1;

        LeadDeveloperUser leadDev = new LeadDeveloperUser("leaddev", "leaddev@email.com", "0634567890", "testId4");
        ScrumMasterUser scrumMasterUser = new ScrumMasterUser("scrum", "scrum@email.com", "0645678901", "testId5");

        Date start = new Date(2022,12,30);
        Date end = new Date(2023,12,30);

        Sprint sprint = new Sprint(Goal.REVIEW, "sprintName", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser, NotificationBehaviourTypes.EMAIL);
        sprint.addSprintBacklog(sprintBacklog);

        sprint.setStateToSprintInProgress();

        //Act
        Assertions.assertThrows(Exception.class, () -> {
            sprint.setStateToSprintFinished();
        });

        //Assert
        Assertions.assertEquals(sprint.getSprintInProgressState(), sprint.getState());
        //todo: check miss of end date al geweest is
    }

    @Test
    public void SPRINT_TEST_7_SetStateToFinalSucces() throws Exception {
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("TestPO", "testPo@email.com", "testId1");
        Project project = new Project("project", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test", 1, NotificationBehaviourTypes.EMAIL);
        List<BacklogItem>backlogItems = new ArrayList<>();
        backlogItems.add(backlogItem1);
        SprintBacklog sprintBacklog = new SprintBacklog(backlogItems);

        DeveloperUser dev1 = new DeveloperUser("dev1", "dev12email.com", "0612345678", "testId2");
        DeveloperUser[] developerUsers = new DeveloperUser[1];
        developerUsers[0] = dev1;

        TesterUser tester1 = new TesterUser("tester1", "tester1@email.com", "0623456789", "testId3");
        TesterUser[] testerUsers = new TesterUser[1];
        testerUsers[0] = tester1;

        LeadDeveloperUser leadDev = new LeadDeveloperUser("leaddev", "leaddev@email.com", "0634567890", "testId4");
        ScrumMasterUser scrumMasterUser = new ScrumMasterUser("scrum", "scrum@email.com", "0645678901", "testId5");

        Date start = new Date(2022,12,30);
        Date end = new Date(2022,12,30);

        Sprint sprint = new Sprint(Goal.REVIEW, "sprintName", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser, NotificationBehaviourTypes.EMAIL);
        sprint.addSprintBacklog(sprintBacklog);

        sprint.setStateToSprintInProgress();

        sprint.setStateToSprintFinished();

        //Act
        sprint.addReviewSummary("testSummary");

        //Assert
        Assertions.assertEquals(sprint.getSprintFinalState(), sprint.getState());
        Assertions.assertEquals("testSummary", sprint.getReviewSummary());
    }

    @Test //(expected = Exception.class)
    public void SPRINT_TEST_8_SetStateToFinalFail() throws Exception {
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("TestPO", "testPo@email.com", "testId1");
        Project project = new Project("project", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test", 1, NotificationBehaviourTypes.EMAIL);
        List<BacklogItem>backlogItems = new ArrayList<>();
        backlogItems.add(backlogItem1);
        SprintBacklog sprintBacklog = new SprintBacklog(backlogItems);

        DeveloperUser dev1 = new DeveloperUser("dev1", "dev12email.com", "0612345678", "testId2");
        DeveloperUser[] developerUsers = new DeveloperUser[1];
        developerUsers[0] = dev1;

        TesterUser tester1 = new TesterUser("tester1", "tester1@email.com", "0623456789", "testId3");
        TesterUser[] testerUsers = new TesterUser[1];
        testerUsers[0] = tester1;

        LeadDeveloperUser leadDev = new LeadDeveloperUser("leaddev", "leaddev@email.com", "0634567890", "testId4");
        ScrumMasterUser scrumMasterUser = new ScrumMasterUser("scrum", "scrum@email.com", "0645678901", "testId5");

        Date start = new Date(2022,12,30);
        Date end = new Date(2022,12,30);

        Sprint sprint = new Sprint(Goal.RELEASE, "sprintName", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser, NotificationBehaviourTypes.EMAIL);
        sprint.addSprintBacklog(sprintBacklog);

        System.out.println("1" + sprint.getState());

        sprint.setStateToSprintInProgress();

        System.out.println("2" + sprint.getState());

        sprint.setStateToSprintFinished();

        System.out.println("3" + sprint.getState());

        //Act
        Assertions.assertThrows(Exception.class, () -> {
            sprint.addReviewSummary("test");
        });



        //Assert
        Assertions.assertEquals(sprint.getSprintFinishedState(), sprint.getState());
        Assertions.assertEquals(null, sprint.getReviewSummary());
    }




    //todo: Notification tests (release cancelled, finished en error)

    //todo: execute pipeline test(release doing)
}

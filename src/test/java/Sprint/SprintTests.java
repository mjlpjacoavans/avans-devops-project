package Sprint;

import enums.Goal;
import project.BacklogItem;
import project.ProductBacklog;
import project.Project;
import sprint.Sprint;
import sprint.SprintBacklog;
import user.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SprintTests {

    @Test
    public void SPRINT_TEST_1_StateToInProgressSuccesfull(){
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("TestPO", "testPo@email.com", "testId1");
        Project project = new Project("project", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test", 1);
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

        Sprint sprint = new Sprint(Goal.REVIEW, "sprintName", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser);
        sprint.addSprintBacklog(sprintBacklog);

        //Act
        sprint.setStateToSprintInProgress();

        //Assert
    }
    @Test
    public void SPRINT_TEST_2_StateToInProgressBeforeStartDateFail(){
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("TestPO", "testPo@email.com", "testId1");
        Project project = new Project("project", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test", 1);
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

        Sprint sprint = new Sprint(Goal.REVIEW, "sprintName", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser);
        sprint.addSprintBacklog(sprintBacklog);

        //Act
        sprint.setStateToSprintInProgress();

        //Assert

    }

    @Test
    public void SPRINT_TEST_3_NameChangeSucces(){
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("TestPO", "testPo@email.com", "testId1");
        Project project = new Project("project", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test", 1);
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

        Sprint sprint = new Sprint(Goal.REVIEW, "sprintName", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser);
        sprint.addSprintBacklog(sprintBacklog);

        //Act
        sprint.setName("SprintNameNew");
    }

    @Test
    public void SPRINT_TEST_4_NameChangeFail(){
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("TestPO", "testPo@email.com", "testId1");
        Project project = new Project("project", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test", 1);
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

        Sprint sprint = new Sprint(Goal.REVIEW, "sprintName", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser);
        sprint.addSprintBacklog(sprintBacklog);

        sprint.setStateToSprintInProgress();

        //Act
        sprint.setName("sprintNameNewShouldFail");

        //Assert

    }

    @Test
    public void SPRINT_TEST_5_SetStateToFinishedSucces(){
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("TestPO", "testPo@email.com", "testId1");
        Project project = new Project("project", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test", 1);
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

        Sprint sprint = new Sprint(Goal.REVIEW, "sprintName", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser);
        sprint.addSprintBacklog(sprintBacklog);

        sprint.setStateToSprintInProgress();

        //Act
        sprint.setStateToSprintFinished();

        //Assert
    }

    @Test
    public void SPRINT_TEST_6_SetStateToFinishedFail(){
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("TestPO", "testPo@email.com", "testId1");
        Project project = new Project("project", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test", 1);
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

        Sprint sprint = new Sprint(Goal.REVIEW, "sprintName", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser);
        sprint.addSprintBacklog(sprintBacklog);

        sprint.setStateToSprintInProgress();

        //Act
        sprint.setStateToSprintFinished();

        //Assert
    }

    @Test
    public void SPRINT_TEST_7_SetStateToFinalSucces(){
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("TestPO", "testPo@email.com", "testId1");
        Project project = new Project("project", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test", 1);
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

        Sprint sprint = new Sprint(Goal.REVIEW, "sprintName", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser);
        sprint.addSprintBacklog(sprintBacklog);

        sprint.setStateToSprintInProgress();

        sprint.setStateToSprintFinished();

        //Act
        sprint.addReviewSummary("test");

        //Assert
    }

    @Test
    public void SPRINT_TEST_8_SetStateToFinalSucces(){
        //Arrange
        ProductOwnerUser productOwnerUser = new ProductOwnerUser("TestPO", "testPo@email.com", "testId1");
        Project project = new Project("project", productOwnerUser);
        ProductBacklog productBacklog = new ProductBacklog(project);

        BacklogItem backlogItem1 = new BacklogItem(productBacklog, "test", 1);
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

        Sprint sprint = new Sprint(Goal.RELEASE, "sprintName", start, end, developerUsers, testerUsers, leadDev, scrumMasterUser);
        sprint.addSprintBacklog(sprintBacklog);

        sprint.setStateToSprintInProgress();

        sprint.setStateToSprintFinished();

        //Act
        sprint.addReviewSummary("test");

        //Assert
    }




    //todo: Notification tests (release cancelled, finished en error)

    //todo: execute pipeline test(release doing)
}

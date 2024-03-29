import notification.behaviours.NotificationBehaviourTypes;
import project.BacklogItem;
import project.ProductBacklog;
import project.Project;
import sprint.Sprint;
import sprint.SprintBacklog;
import sprint.enums.Goal;
import user.*;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;



public class Main {
    public static void main(String[] args) throws Exception {
        //Create a product owner
        ProductOwnerUser productOwner1 = new ProductOwnerUser("Gerard", "Gerard@email.com","78453542346");

        //Create a scrum master user
        ScrumMasterUser scrumMaster1 = new ScrumMasterUser("S. Crum", "scrum@master.tld","823115675","8761131234415");

        //Create a lead developer user
        LeadDeveloperUser leadDeveloper1 = new LeadDeveloperUser("Lee D","lee@d.tld","73482561478951","47562145163451");


        //Create 5 developers
        DeveloperUser developer1 = new DeveloperUser("Mike", "Mike@email.com", "0612345678","837528956");
        DeveloperUser developer2 = new DeveloperUser("_", "_@email.com", "0623456789","947506592");
        DeveloperUser developer3 = new DeveloperUser("Kees", "Kees@email.com", "0634567890","0348257");
        DeveloperUser developer4 = new DeveloperUser("Klaas", "Klaas@email.com", "0645678901","6478957");
        DeveloperUser developer5 = new DeveloperUser("Alex", "Alex@email.com", "0656789012","572056245");

        //Create 5 testers
        TesterUser tester1 = new TesterUser("Youri", "Youri@email.com", "0667890123","867845534");
        TesterUser tester2 = new TesterUser("Mark", "Mark@email.com", "0678901234","654764576");
        TesterUser tester3 = new TesterUser("Ann", "Ann@email.com", "0689012345","321341512");
        TesterUser tester4 = new TesterUser("Jason", "Jason@email.com", "0690123456","78658926");
        TesterUser tester5 = new TesterUser("Bart", "Bart@email.com", "0601234567","09668956945");



        //Create a project
        Project project1 = new Project("Soa", productOwner1);

        //Create a sprint
        Sprint sprint1 = new Sprint(
                Goal.RELEASE,
                "Sprint one",
                new Date(2022,12,30),
                new Date(2022,12,30),
                new DeveloperUser[]{developer2, developer3, developer4, developer5},
                new TesterUser[]{tester1, tester2, tester3},
                leadDeveloper1,
                scrumMaster1,
                NotificationBehaviourTypes.EMAIL
        );

        //Create a project backlog
        ProductBacklog productBacklog1 = new ProductBacklog(project1);

        //Create 4 backlogitems
        BacklogItem backlogItem1 = new BacklogItem(productBacklog1, "Add auth", 3, NotificationBehaviourTypes.EMAIL);
        BacklogItem backlogItem2 = new BacklogItem(productBacklog1, "Add functionality", 1, NotificationBehaviourTypes.EMAIL);
        BacklogItem backlogItem3 = new BacklogItem(productBacklog1, "Add UI", 4, NotificationBehaviourTypes.EMAIL);
        BacklogItem backlogItem4 = new BacklogItem(productBacklog1, "Add funfactor", 2, NotificationBehaviourTypes.EMAIL);


        // Have to use a stupid tree set because java acts like it cannot sort an arraylist despite implementing comparable
        List<BacklogItem> backlogItems = Arrays.asList(
                backlogItem1, backlogItem2, backlogItem3, backlogItem4);
        Collections.sort(backlogItems);



        // Add sprint to all backlog items
        SprintBacklog sprintBacklog1 = new SprintBacklog(backlogItems);
        sprint1.addSprintBacklog(sprintBacklog1);

        sprint1.setName("Main sprint");


        // Open the sprint
        sprint1.setStateToSprintInProgress();



        // Go through the phases of a backlogitem


        backlogItem1.setDeveloper(developer1);

        backlogItem1.setDeveloped();

        backlogItem1.setTester(tester1);

        backlogItem1.setTested();

        backlogItem1.setDefinitionMet(leadDeveloper1.getEmail());

        // Go through the phases of the sprint

        sprint1.setStateToSprintFinished();
        sprint1.executeRelease();
        sprint1.executePipeline();

        sprint1.setStateToSprintFinal();
        System.out.println(sprint1.getState());

    }
}
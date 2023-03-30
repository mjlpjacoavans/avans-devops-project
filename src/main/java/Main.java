import java.time.temporal.ChronoUnit;
import java.util.*;
import notification.*;
import notification.behaviours.NotificationBehaviourTypes;
import project.*;
import sprint.*;
import sprint.enums.Goal;
import user.*;



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
                Goal.REVIEW,
                "Sprint one",
                new Date(),
                Date.from(new Date().toInstant().plus(14, ChronoUnit.DAYS)),
                new DeveloperUser[]{developer2, developer3, developer4, developer5},
                new TesterUser[]{tester1, tester2, tester3},
                leadDeveloper1,
                scrumMaster1,
                NotificationBehaviourTypes.EMAIL
        );

        //Create a project backlog
        ProductBacklog productBacklog1 = new ProductBacklog(project1);

        //Create 4 backlogitems
        BacklogItem backlogItem1 = new BacklogItem(productBacklog1, "Add auth", 3 );    //, NotificationBehaviourTypes.EMAIL);
        BacklogItem backlogItem2 = new BacklogItem(productBacklog1, "Add functionality", 1 );    //, NotificationBehaviourTypes.EMAIL);
        BacklogItem backlogItem3 = new BacklogItem(productBacklog1, "Add UI", 4 );    //, NotificationBehaviourTypes.EMAIL);
        BacklogItem backlogItem4 = new BacklogItem(productBacklog1, "Add funfactor", 2 );    //, NotificationBehaviourTypes.EMAIL);


        // Have to use a stupid tree set because java acts like it cannot sort an arraylist despite implementing comparable
        List<BacklogItem> backlogItems = Arrays.asList(
                backlogItem1, backlogItem2, backlogItem3, backlogItem4);
        Collections.sort(backlogItems);



        // add sprint to all backlog items
        SprintBacklog sprintBacklog1 = new SprintBacklog(backlogItems);
        sprint1.addSprintBacklog(sprintBacklog1);
   
    }
}
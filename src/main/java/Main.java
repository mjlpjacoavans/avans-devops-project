package main.java;

import main.java.project.*;
import main.java.user.ProductOwnerUser;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Create a product owner
        ProductOwnerUser productOwner1 = new ProductOwnerUser("Gerard", "Gerard@email.com");

        //Create a project
        Project project1 = new Project("Soa", productOwner1);

        //Create a project backlog
        ProductBacklog productBacklog1 = new ProductBacklog(project1);

        //Create 4 backlogitems
        BacklogItem backlogItem1 = new BacklogItem(productBacklog1, "Add auth");
        BacklogItem backlogItem2 = new BacklogItem(productBacklog1, "Add functionality");
        BacklogItem backlogItem3 = new BacklogItem(productBacklog1, "Add UI");
        BacklogItem backlogItem4 = new BacklogItem(productBacklog1, "Add funfactor");

        //Create 4 definitions of done
        DefinitionOfDone definitionOfDone1 = new DefinitionOfDone(backlogItem1, "Auth werkt");
        DefinitionOfDone definitionOfDone2 = new DefinitionOfDone(backlogItem2, "func inmplemented");
        DefinitionOfDone definitionOfDone3 = new DefinitionOfDone(backlogItem3, "UI zichtbaar");
        DefinitionOfDone definitionOfDone4 = new DefinitionOfDone(backlogItem4, "het is leuk");

        //Create 3 activities
        Activity activity1 = new Activity(backlogItem1, "maak login");
        Activity activity2 = new Activity(backlogItem1, "maak register");
        Activity activity3 = new Activity(backlogItem2, "removing items from list");


        //Printing tests
        System.out.println(productOwner1);
        System.out.println(project1);
        System.out.println(productBacklog1);

        System.out.println(backlogItem1);
        System.out.println(backlogItem2);
        System.out.println(backlogItem3);
        System.out.println(backlogItem4);

        System.out.println(definitionOfDone1);
        System.out.println(definitionOfDone2);
        System.out.println(definitionOfDone3);
        System.out.println(definitionOfDone4);

        System.out.println(activity1);
        System.out.println(activity2);
        System.out.println(activity3);
    }
}
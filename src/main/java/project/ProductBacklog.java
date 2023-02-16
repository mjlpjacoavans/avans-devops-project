package main.java.project;

import java.util.List;

public class ProductBacklog {
    List<BacklogItem> backlogItems;
    Project project;

    public ProductBacklog(Project project, List<BacklogItem> backlogItems){
        this.project = project;
        this.backlogItems = backlogItems;
    }

    public List<BacklogItem> getBacklogItems(){
        return this.backlogItems;
    }

    public String addToProjectBacklog(BacklogItem backlogItem){
        this.backlogItems.add(backlogItem);

        if(!this.backlogItems.contains(backlogItem)){
            return "Backlog item not added to produc backlog. Try again!";
        }

        return "Backlog item added!";
    }

    public List<BacklogItem> removeBacklogItem(BacklogItem backlogItem){
        this.backlogItems.remove(backlogItem);

        return this.backlogItems;
    }

    public Project getProject(){
        return this.project;
    }

}

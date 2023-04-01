package project;

import java.util.ArrayList;
import java.util.List;

public class ProductBacklog {
    List<BacklogItem> backlogItems;
    Project project;

    public ProductBacklog(Project project) throws Exception {
        this.project = project;
        this.backlogItems = new ArrayList<>();

        project.addProductBacklog(this);
    }

    public List<BacklogItem> getBacklogItems(){
        return this.backlogItems;
    }

    public String addToProjectBacklog(BacklogItem backlogItem) throws Exception {
        this.backlogItems.add(backlogItem);

        if(!this.backlogItems.contains(backlogItem)){
            throw new Exception("Backlog item not added to produc backlog. Try again!");
        }

        System.out.println("Backlog item added!");
        return null;
    }

    public List<BacklogItem> removeBacklogItem(BacklogItem backlogItem){
        this.backlogItems.remove(backlogItem);

        return this.backlogItems;
    }

    public List<BacklogItem> addBacklogItem(BacklogItem backlogItem){
        this.backlogItems.add(backlogItem);

        return this.backlogItems;
    }

    public Project getProject(){
        return this.project;
    }


    @Override
    public String toString() {
        String sb = "ProductBacklog{" + "backlogItems=" + backlogItems +
                '}';
        return sb;
    }
}

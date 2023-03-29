package project;

import user.ProductOwnerUser;

public class Project {
    ProductBacklog productBacklog;
    ProductOwnerUser productOwner;
    String projectName;

    public Project(String name, ProductOwnerUser productOwner){
        this.projectName = name;
        this.productOwner = productOwner;
        this.productBacklog = null;

        productOwner.addProjectToProductOwner(this);
    }

    public ProductBacklog getProductBacklog(){
        return this.productBacklog;
    }

    public String addProductBacklog(ProductBacklog productBacklogParameter){
        if(this.productBacklog != productBacklogParameter){
            return "Product backlog not added. Try again!";
        }
        this.productBacklog = productBacklogParameter;
        return "Product backlog added!";
    }

    public ProductOwnerUser getProductOwner(){
        return this.productOwner;
    }

    public String getProjectName(){
        return this.projectName;
    }

    public String setProjectName(String name){
        this.projectName = name;
        return "Project name set to: " + this.projectName;
    }


    @Override
    public String toString() {
        String sb = "Project{" + "productOwner=" + productOwner +
                ", projectName='" + projectName + '\'' +
                '}';
        return sb;
    }
}

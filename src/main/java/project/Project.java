package main.java.project;

import main.java.user.ProductOwnerUser;

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

    public String addProductBacklog(ProductBacklog productBacklog){
        this.productBacklog = productBacklog;

        if(this.productBacklog != productBacklog){
            return "Product backlog not added. Try again!";
        }

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
        final StringBuffer sb = new StringBuffer("Project{");
        sb.append("productOwner=").append(productOwner);
        sb.append(", projectName='").append(projectName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

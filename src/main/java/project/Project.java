package project;

import user.ProductOwnerUser;

public class Project {
    ProductBacklog productBacklog;
    ProductOwnerUser productOwner;
    String projectName;

    public Project(String name, ProductOwnerUser productOwner) throws Exception {
        this.projectName = name;
        this.productOwner = productOwner;
        this.productBacklog = null;

        productOwner.addProjectToProductOwner(this);
    }

    public ProductBacklog getProductBacklog(){
        return this.productBacklog;
    }

    public String addProductBacklog(ProductBacklog productBacklogParameter) throws Exception {
        //!this.productBacklog.equals(productBacklogParameter)
        //if(this.productBacklog != productBacklogParameter){
        // SUGGESTION: Evaluate if this check is really necessary
        // if(!productBacklogParameter.equals(this.productBacklog)){
        //     throw new Exception("Product backlog not added. Try again!");
        // }
        this.productBacklog = productBacklogParameter;
        System.out.println("Product backlog added!");
        return null;
    }

    public ProductOwnerUser getProductOwner(){
        return this.productOwner;
    }

    public String getProjectName(){
        return this.projectName;
    }

    public String setProjectName(String name){
        this.projectName = name;
        System.out.println("Project name set to: " + this.projectName);
        return null;
    }


    @Override
    public String toString() {
        String sb = "Project{" + "productOwner=" + productOwner +
                ", projectName='" + projectName + '\'' +
                '}';
        return sb;
    }
}

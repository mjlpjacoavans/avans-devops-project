package main.java.user;

import main.java.project.Project;

import java.util.ArrayList;
import java.util.List;

public class ProductOwnerUser {
    List<Project> projects;
    String name;
    String email;

    public ProductOwnerUser(String name, String email){
        this.name = name;
        this.email = email;
        this.projects = new ArrayList<Project>();
    }

    public List<Project> getProjects(){
        return this.projects;
    }

    public String addProjectToProductOwner(Project project){
        this.projects.add(project);

        if(!this.projects.contains(project)){
            return "Project not added. Try again!";
        }

        return "Project added!";
    }

    public String getName(){
        return this.name;
    }

    public String setName(String name){
        this.name = name;
        return "Name set to: " + this.name;
    }

    public  String getEmail(){
        return this.email;
    }

    public String setEmail(String email){
        this.email = email;
        return "Email set to: " + this.email;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ProductOwnerUser{");
        sb.append("name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
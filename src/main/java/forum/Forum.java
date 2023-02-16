package main.java.forum;

import java.util.ArrayList;
import java.util.List;

public class Forum implements ForumComponent {
    private String name;
    private List<ForumComponent> components = new ArrayList<>();

    public Forum(String name) {
        this.name = name;
    }

    public void addComponent(ForumComponent component) {
        components.add(component);
    }

    public void display() {
        System.out.println("Forum: " + name);
        for (ForumComponent component : components) {
            component.display();
        }
    }
}


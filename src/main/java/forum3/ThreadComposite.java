package main.java.forum3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ThreadComposite implements ForumComment {
    private String name;
    private List<ForumComment> components = new ArrayList<>();

    public ThreadComposite(String name) {
        this.name = name;
    }

    public void addComponent(ForumComment component) {
        components.add(component);
    }

    public void display() {
        System.out.println("Composite " + name);
        for (ForumComment component : components) {
            component.display();
        }
    }
}

package main.java.notification.observer;

public interface ISubscriber {
    Integer id = null;
    void update(String message);
}

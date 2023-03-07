package main.java.notification.observer;

import main.java.notification.behaviours.INotificationBehaviour;

public interface ISubscriber {
    void update(String message);
    INotificationBehaviour getNotificationBehaviour();
}

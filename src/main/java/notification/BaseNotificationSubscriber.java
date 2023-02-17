package main.java.notification;

import main.java.notification.behaviours.INotificationBehaviour;
import main.java.notification.observer.ISubscriber;

public class BaseNotificationSubscriber implements ISubscriber {

    private INotificationBehaviour notificationBehaviour;

    public BaseNotificationSubscriber(INotificationBehaviour notificationBehaviour) {
        this.notificationBehaviour = notificationBehaviour;
    }


    @Override
    public void update(String message) {
        this.notificationBehaviour.sendNotification(message);
    }
}

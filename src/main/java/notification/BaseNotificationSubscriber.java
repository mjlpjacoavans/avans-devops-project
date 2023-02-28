package main.java.notification;

import main.java.notification.behaviours.INotificationBehaviour;
import main.java.notification.behaviours.StdOutNotificationBehaviour;
import main.java.notification.observer.ISubscriber;

public class BaseNotificationSubscriber implements ISubscriber {

    private INotificationBehaviour notificationBehaviour;

    public BaseNotificationSubscriber(INotificationBehaviour notificationBehaviour) {
        this.notificationBehaviour = notificationBehaviour;
    }

    // This constructor has to be added because otherwise child classes are going to nag on super()
    public BaseNotificationSubscriber() {
        this.notificationBehaviour = new StdOutNotificationBehaviour();
    }

    public INotificationBehaviour getNotificationBehaviour() {
        return notificationBehaviour;
    }

    public void setNotificationBehaviour(INotificationBehaviour notificationBehaviour) {
        this.notificationBehaviour = notificationBehaviour;
    }

    @Override
    public void update(String message) {
        this.notificationBehaviour.sendNotification(message);
    }
}

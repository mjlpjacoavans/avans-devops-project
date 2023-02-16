package main.java.notification;

import main.java.notification.behaviours.EmailNotificaionBehaviour;
import main.java.notification.behaviours.INotificationBehaviour;
import main.java.notification.behaviours.NotificationBehaviourTypes;
import main.java.notification.observer.ISubscriber;

public class AbstractNotificationSubscriber implements ISubscriber {

    private INotificationBehaviour notificationBehaviour;

    public AbstractNotificationSubscriber(INotificationBehaviour notificationBehaviour) {
        this.notificationBehaviour = notificationBehaviour;
    }


    @Override
    public void update(String message) {
        this.notificationBehaviour.sendNotification(message);
    }
}

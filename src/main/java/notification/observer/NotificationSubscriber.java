package notification.observer;

import notification.behaviours.INotificationBehaviour;
import notification.behaviours.StdOutNotificationBehaviour;

public class NotificationSubscriber implements ISubscriber {

    private INotificationBehaviour notificationBehaviour;

    public NotificationSubscriber(INotificationBehaviour notificationBehaviour) {
        this.notificationBehaviour = notificationBehaviour;
    }

    // This constructor has to be added because otherwise child classes are going to nag on super()
    public NotificationSubscriber() {
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

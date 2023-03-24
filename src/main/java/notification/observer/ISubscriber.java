package notification.observer;

import notification.behaviours.INotificationBehaviour;

public interface ISubscriber {
    void update(String message);
    INotificationBehaviour getNotificationBehaviour();
}

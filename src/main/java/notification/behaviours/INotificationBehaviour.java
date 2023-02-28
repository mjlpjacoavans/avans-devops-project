package main.java.notification.behaviours;

public interface INotificationBehaviour {
    void sendNotification(String text);
    void setIdentifier(String text);
    String getIdentifier();
}

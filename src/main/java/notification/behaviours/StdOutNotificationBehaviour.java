package main.java.notification.behaviours;

public class StdOutNotificationBehaviour implements INotificationBehaviour{
    @Override
    public void sendNotification(String text) {
        // Stdout behaviour for testing purposes
        System.out.println("Sending notification to stdout: " + text);
    }
}

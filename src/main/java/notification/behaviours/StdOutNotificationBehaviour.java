package main.java.notification.behaviours;

public class StdOutNotificationBehaviour implements INotificationBehaviour{
    private String path = "/dev/fd/1";
    @Override
    public void sendNotification(String text) {
        // Stdout behaviour for testing purposes
        System.out.println("Sending notification to stdout: " + text);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void setIdentifier(String text) {
        this.setPath(text);
    }

    @Override
    public String getIdentifier() {
        return this.getPath();
    }
}

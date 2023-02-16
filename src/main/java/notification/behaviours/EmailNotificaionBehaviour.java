package main.java.notification.behaviours;

public class EmailNotificaionBehaviour implements INotificationBehaviour{
    private String email;

    private Object SMTPLib;

    public EmailNotificaionBehaviour(String email, Object SMTPLib) {
        this.email = email;
        this.SMTPLib = SMTPLib;
    }

    public EmailNotificaionBehaviour(String email) {
        this.email = email;
        this.SMTPLib = new Object();
    }

    @Override
    public void sendNotification(String text) {
        System.out.println("Sending email with " + this.SMTPLib + " to " + this.email);
    }
}

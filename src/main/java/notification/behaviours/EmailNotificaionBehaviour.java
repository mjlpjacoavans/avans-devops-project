package notification.behaviours;

public class EmailNotificaionBehaviour implements INotificationBehaviour{
    private String email;

    private Object SMTPLib; // NOSONAR



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getSMTPLib() {
        return SMTPLib;
    }

    public void setSMTPLib(Object SMTPLib) { // NOSONAR
        this.SMTPLib = SMTPLib;
    }

    public EmailNotificaionBehaviour(String email, Object SMTPLib) { // NOSONAR
        this.email = email;
        this.SMTPLib = SMTPLib;
    }

    public EmailNotificaionBehaviour(String email) {
        this.email = email;
        this.SMTPLib = new Object();
    }

    public EmailNotificaionBehaviour() {
    }

    @Override
    public void sendNotification(String text) {
        System.out.println("Sending email with " + this.SMTPLib + " to " + this.email);
    }

    @Override
    public void setIdentifier(String text) {
        this.setEmail(text);
    }

    @Override
    public String getIdentifier() {
        return this.getEmail();
    }
}

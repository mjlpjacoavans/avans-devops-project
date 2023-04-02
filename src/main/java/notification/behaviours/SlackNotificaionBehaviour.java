package notification.behaviours;

public class SlackNotificaionBehaviour implements INotificationBehaviour {
    private String slackId;
    private String slackEndpoint = "https://slack.tld/<ENDPOINT>/";
    private Object slackClient;

    public String getSlackId() {
        return slackId;
    }

    public void setSlackId(String slackId) {
        this.slackId = slackId;
    }

    public SlackNotificaionBehaviour(String slackId) {
        this.slackId = slackId;
    }

    public SlackNotificaionBehaviour(String slackId, String slackEndpoint) {
        this.slackId = slackId;
        this.slackEndpoint = slackEndpoint;
        this.slackClient = new Object();
    }

    public SlackNotificaionBehaviour(String slackId, Object slackClient) {
        this.slackId = slackId;
        this.slackClient = slackClient;
    }

    public SlackNotificaionBehaviour() {
    }

    @Override
    public void sendNotification(String text) {
        System.out.println("Sending Slack Message with client " + this.slackClient + " to endpoint " + this.slackEndpoint + this.slackId + " message: " + text);
    }

    @Override
    public void setIdentifier(String text) {
        this.setSlackId(text);
    }

    @Override
    public String getIdentifier() {
        return this.getSlackId();
    }
}

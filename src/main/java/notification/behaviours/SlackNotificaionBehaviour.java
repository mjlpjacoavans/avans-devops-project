package main.java.notification.behaviours;

public class SlackNotificaionBehaviour implements INotificationBehaviour {
    private String slackId;
    private String slackEndpoint = "https://slack.tld/<ENDPOINT>/";
    private Object slackClient;

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

    @Override
    public void sendNotification(String text) {
        System.out.println("Sending Slack Message with client " + this.slackClient + " to endpoint " + this.slackEndpoint + this.slackId);
    }
}

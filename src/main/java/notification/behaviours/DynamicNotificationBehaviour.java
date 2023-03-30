package notification.behaviours;


// Behaviour pattern inside of behaviour pattern.
// This is a wrapper around the different behaviour types
// but offers the convenience of having all of the logic around
// deciding which behaviour to choose based on the notification type
// in a central place instead of having it littered everywhere or having
// it in a static util class or something.

public class DynamicNotificationBehaviour implements INotificationBehaviour {

    NotificationBehaviourTypes notificationBehaviourType = NotificationBehaviourTypes.EMAIL;
    private INotificationBehaviour behaviour;

    public DynamicNotificationBehaviour(NotificationBehaviourTypes notificationBehaviourType) {
    }

    public DynamicNotificationBehaviour(NotificationBehaviourTypes notificationBehaviourType, String identifier) {
        this.setNotificationBehaviourType(this.notificationBehaviourType);
        this.behaviour.setIdentifier(identifier);
    }

    @Override
    public void sendNotification(String text) {
        this.behaviour.sendNotification(text);
    }

    @Override
    public void setIdentifier(String text) {
        this.setIdentifier(text);
    }

    @Override
    public String getIdentifier() {
        return this.getIdentifier();
    }

    public NotificationBehaviourTypes getNotificationBehaviourType() {
        return notificationBehaviourType;
    }

    public void setNotificationBehaviourType(NotificationBehaviourTypes notificationBehaviourType) {
        this.notificationBehaviourType = notificationBehaviourType;

        if(notificationBehaviourType == NotificationBehaviourTypes.EMAIL){
            this.behaviour = new EmailNotificaionBehaviour();
        }
        else if(notificationBehaviourType == NotificationBehaviourTypes.SLACK){
            this.behaviour = new SlackNotificaionBehaviour();
        } else if (notificationBehaviourType == NotificationBehaviourTypes.STDOUT) {
            this.behaviour = new StdOutNotificationBehaviour();
        }
        else{
            throw new IllegalArgumentException("Notification behaviour type not supported");
        }
    }
}

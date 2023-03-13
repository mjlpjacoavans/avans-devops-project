package notification;



// TODO: Replace all DynamicNotificationBehaviour with this factory
public class NotificationBehaviourFactory {
    public static INotificationBehaviour create(){
        NotificationBehaviourTypes notificationBehaviourType = NotificationBehaviourTypes.EMAIL;
        return this.create(notificationBehaviourType);
    }
    public static INotificationBehaviour create(NotificationBehaviourTypes notificationBehaviourType){
        INotificationBehaviour retNotificationBehaviourType =
                  ( notificationBehaviourType == NotificationBehaviourTypes.EMAIL)  ?  new EmailNotificaionBehaviour()
                : ( notificationBehaviourType == NotificationBehaviourTypes.SLACK)  ?  new SlackNotificaionBehaviour()
                : ( notificationBehaviourType == NotificationBehaviourTypes.STDOUT) ?  new StdOutNotificationBehaviour()
                : null;
        if(retNotificationBehaviourType == null) throw new IllegalArgumentException("Notification behaviour type not supported");
        return retNotificationBehaviourType;
    }
}

package notification;


import main.java.notification.behaviours.*;

// TODO: Replace all DynamicNotificationBehaviour with this factory
public class NotificationBehaviourFactory {
    INotificationBehaviour create(){
        NotificationBehaviourTypes notificationBehaviourType = NotificationBehaviourTypes.EMAIL;
        return this.create(notificationBehaviourType);
    }
    INotificationBehaviour create(NotificationBehaviourTypes notificationBehaviourType){
        INotificationBehaviour retNotificationBehaviourType =
                  ( notificationBehaviourType == NotificationBehaviourTypes.EMAIL)  ?  new EmailNotificaionBehaviour()
                : ( notificationBehaviourType == NotificationBehaviourTypes.SLACK)  ?  new SlackNotificaionBehaviour()
                : ( notificationBehaviourType == NotificationBehaviourTypes.STDOUT) ?  new StdOutNotificationBehaviour()
                : null;
        if(retNotificationBehaviourType == null) throw new IllegalArgumentException("Notification behaviour type not supported")
        return retNotificationBehaviourType;
    }
}

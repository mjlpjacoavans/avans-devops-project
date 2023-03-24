
package main.java.notification;


import main.java.notification.behaviours.*;

// TODO: Replace all DynamicNotificationBehaviour with this factory

//TODO: Static weggehaald van eerste method. this kan niet in static method dus hier nog even naar kijken of dit goed gaat.
public class NotificationBehaviourFactory {
    public INotificationBehaviour create(){
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

package main.java.user;

import main.java.notification.behaviours.INotificationBehaviour;
import main.java.notification.behaviours.NotificationBehaviourTypes;

public abstract class IUser {
    String name;
    String email;
    String phoneNumber;
    String slackId;

    public IUser(String name, String email, String phoneNumber, String slackId) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.slackId = slackId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSlackId() {return slackId;}

    public String getIdentifierForNotificationBehaviourType(NotificationBehaviourTypes notificationBehaviourType){
        return ( notificationBehaviourType == NotificationBehaviourTypes.EMAIL)  ?  this.getEmail()
             : ( notificationBehaviourType == NotificationBehaviourTypes.SLACK)  ?  this.getSlackId()
             : ( notificationBehaviourType == NotificationBehaviourTypes.STDOUT) ?  "/dev/fd/1"
             : "";
    }
}

package notification;

import notification.behaviours.INotificationBehaviour;
import notification.behaviours.NotificationBehaviourTypes;
import notification.observer.IPublisher;
import notification.observer.ISubscriber;
import notification.observer.NotificationSubscriber;
import notification.observer.Publisher;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import user.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;

public class NotificaionTests {

    /// Arrange

    // Just a class to test out the notification functionality
    private class TestPublisher extends Publisher {
        final String message = "SENDING TEST MESSAGE";
        public void testNotify(){
            this.notifySubscribers(this.message);
        }

        public void testNotify(String email){
            this.notifySubscribers(this.message,
                    Collections.singletonList(email).toArray(new String[0]));
        }
    }



//    @Test
//    public void NOTIFICATION_TEST_1_notification_sent_to_all_emails() {
//
//        // Arange
//        TestPublisher tp = new TestPublisher();
//
//
//        IUser dev = new DeveloperUser("User 1", "user1@company.tld", "123456","01");
//        IUser leadDev = new LeadDeveloperUser("User 2", "user2@company.tld", "223456","02");
//        IUser scrumMaster = new ScrumMasterUser("User 3", "user3@company.tld", "323456","03");
//        IUser tester = new TesterUser("User 4", "user4@company.tld", "423456","04");
//        ProductOwnerUser productOwner = new ProductOwnerUser("User 5", "user5@company.tld", "523456");
//
//
//        NotificationBehaviourTypes type = NotificationBehaviourTypes.EMAIL;
//
//        // Behaviours
//        // create a behaviour for the subscriber
//        INotificationBehaviour behaviour1 = NotificationBehaviourFactory.create(type);
//        // set the identifier for the subscriber
//        behaviour1.setIdentifier(dev.getIdentifierForNotificationBehaviourType(type));
//        // subscribe the subsciber to the publisher
//        ISubscriber subscriber1 = new NotificationSubscriber(behaviour1);
//        // subscribe
//        tp.subscribe(subscriber1);
//
//
//
//        // act
//
//        // send the notification
//        tp.testNotify();
//
//
//        // assert
//
//
//    }


    @Test
    public void NOTIFICATION_TEST_1_notification_sent_to_all_emails() {
        // Arrange
        TestPublisher tp = new TestPublisher();
        IUser dev = new DeveloperUser("User 1", "user1@company.tld", "123456", "01");
        NotificationBehaviourTypes type = NotificationBehaviourTypes.EMAIL;
        INotificationBehaviour behaviour = NotificationBehaviourFactory.create(type);
        behaviour.setIdentifier(dev.getIdentifierForNotificationBehaviourType(type));
        ISubscriber subscriber = new NotificationSubscriber(behaviour);
        tp.subscribe(subscriber);

        // Act
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        tp.testNotify();

        // Assert
        String expectedOutput = " null to user1@company.tld\n";

        Assertions.assertTrue(
                outputStream.toString().contains("Sending email with") &&
                        outputStream.toString().contains("to " + dev.getEmail())
        );
    }




}

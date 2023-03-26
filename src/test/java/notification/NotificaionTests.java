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


    @Test
    public void NOTIFICATION_TEST_2_notification_not_sent_to_unsubscribed_emails() {
        // Arrange
        TestPublisher tp = new TestPublisher();
        IUser dev = new DeveloperUser("User 1", "user1@company.tld", "123456", "01");
        NotificationBehaviourTypes type = NotificationBehaviourTypes.EMAIL;
        INotificationBehaviour behaviour = NotificationBehaviourFactory.create(type);
        behaviour.setIdentifier(dev.getIdentifierForNotificationBehaviourType(type));
        ISubscriber subscriber = new NotificationSubscriber(behaviour);
        tp.subscribe(subscriber);

        IUser leadDev = new LeadDeveloperUser("User 2", "user2@company.tld", "223456", "02");
        IUser scrumMaster = new ScrumMasterUser("User 3", "user3@company.tld", "323456", "03");

        // Act
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        tp.testNotify();

        // Assert
        Assertions.assertTrue(
                outputStream.toString().contains("Sending email with") &&
                        outputStream.toString().contains("to " + dev.getEmail()) &&
                        !outputStream.toString().contains("to " + leadDev.getEmail()) &&
                        !outputStream.toString().contains("to " + scrumMaster.getEmail())
        );
    }


    @Test
    public void NOTIFICATION_TEST_3_notification_not_sent_to_unsubscribed_user() {
        // Arrange
        TestPublisher tp = new TestPublisher();
        IUser dev = new DeveloperUser("User 1", "user1@company.tld", "123456", "01");
        NotificationBehaviourTypes type = NotificationBehaviourTypes.EMAIL;
        INotificationBehaviour behaviour = NotificationBehaviourFactory.create(type);
        behaviour.setIdentifier(dev.getIdentifierForNotificationBehaviourType(type));
        ISubscriber subscriber = new NotificationSubscriber(behaviour);
        tp.subscribe(subscriber);

        IUser leadDev = new LeadDeveloperUser("User 2", "user2@company.tld", "223456", "02");
        IUser scrumMaster = new ScrumMasterUser("User 3", "user3@company.tld", "323456", "03");
        IUser tester = new TesterUser("User 4", "user4@company.tld", "423456", "04");
        ProductOwnerUser productOwner = new ProductOwnerUser("User 5", "user5@company.tld", "523456");

        INotificationBehaviour behaviour2 = NotificationBehaviourFactory.create(type);
        behaviour2.setIdentifier(leadDev.getIdentifierForNotificationBehaviourType(type));
        ISubscriber subscriber2 = new NotificationSubscriber(behaviour2);

        tp.subscribe(subscriber2);
        tp.unsubscribe(subscriber);

        // Act
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        tp.testNotify();

        // Assert
        Assertions.assertTrue(
                outputStream.toString().contains("Sending email with") &&
                        outputStream.toString().contains("to " + leadDev.getEmail()) &&
                        !outputStream.toString().contains("to " + dev.getEmail())
        );
    }


    @Test
    public void NOTIFICATION_TEST_5_notification_sent_to_all_subscribed_users_with_different_behaviours() {
        // Arrange
        TestPublisher tp = new TestPublisher();

        IUser dev = new DeveloperUser("User 1", "user1@company.tld", "123456", "01");
        INotificationBehaviour devEmailBehaviour = NotificationBehaviourFactory.create(NotificationBehaviourTypes.EMAIL);
        devEmailBehaviour.setIdentifier(dev.getIdentifierForNotificationBehaviourType(NotificationBehaviourTypes.EMAIL));
        ISubscriber devSubscriber = new NotificationSubscriber(devEmailBehaviour);
        tp.subscribe(devSubscriber);

        IUser leadDev = new LeadDeveloperUser("User 2", "user2@company.tld", "223456", "02");
        INotificationBehaviour leadDevSlackBehaviour = NotificationBehaviourFactory.create(NotificationBehaviourTypes.SLACK);
        leadDevSlackBehaviour.setIdentifier(leadDev.getIdentifierForNotificationBehaviourType(NotificationBehaviourTypes.SLACK));
        ISubscriber leadDevSubscriber = new NotificationSubscriber(leadDevSlackBehaviour);
        tp.subscribe(leadDevSubscriber);

        IUser scrumMaster = new ScrumMasterUser("User 3", "user3@company.tld", "323456", "03");
        INotificationBehaviour scrumMasterStdoutBehaviour = NotificationBehaviourFactory.create(NotificationBehaviourTypes.STDOUT);
        scrumMasterStdoutBehaviour.setIdentifier(scrumMaster.getIdentifierForNotificationBehaviourType(NotificationBehaviourTypes.STDOUT));
        ISubscriber scrumMasterSubscriber = new NotificationSubscriber(scrumMasterStdoutBehaviour);
        tp.subscribe(scrumMasterSubscriber);


        // Act
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        tp.testNotify();


        Assertions.assertTrue(
                (outputStream.toString().contains("Sending email with") && outputStream.toString().contains("to " + dev.getEmail()))

                        &&  outputStream.toString().contains("Sending Slack Message with client") && outputStream.toString().contains("to endpoint https://slack.tld/<ENDPOINT>/" + leadDev.getSlackId())

                        &&  outputStream.toString().contains("Sending notification to stdout:")

                        );
    }



    // SUGGESTION: Send to specific emails only
    @Test
    public void NOTIFICATION_TEST_6_notification_send_to_only_one_subscriber_filter() {
        // Arrange
        TestPublisher tp = new TestPublisher();
        IUser dev = new DeveloperUser("User 1", "user1@company.tld", "123456", "01");
        NotificationBehaviourTypes type = NotificationBehaviourTypes.EMAIL;
        INotificationBehaviour behaviour = NotificationBehaviourFactory.create(type);
        behaviour.setIdentifier(dev.getIdentifierForNotificationBehaviourType(type));
        ISubscriber subscriber = new NotificationSubscriber(behaviour);
        tp.subscribe(subscriber);

        IUser leadDev = new LeadDeveloperUser("User 2", "user2@company.tld", "223456", "02");
        IUser scrumMaster = new ScrumMasterUser("User 3", "user3@company.tld", "323456", "03");
        IUser tester = new TesterUser("User 4", "user4@company.tld", "423456", "04");
        ProductOwnerUser productOwner = new ProductOwnerUser("User 5", "user5@company.tld", "523456");

        INotificationBehaviour behaviour2 = NotificationBehaviourFactory.create(type);
        behaviour2.setIdentifier(leadDev.getIdentifierForNotificationBehaviourType(type));
        ISubscriber subscriber2 = new NotificationSubscriber(behaviour2);

        tp.subscribe(subscriber2);

        // Act
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        tp.testNotify(dev.getEmail());

        // Assert
        Assertions.assertTrue(
                outputStream.toString().contains("Sending email with") &&
                        outputStream.toString().contains("to " + dev.getEmail()) &&
                        !outputStream.toString().contains("to " + leadDev.getEmail())
        );
    }


}

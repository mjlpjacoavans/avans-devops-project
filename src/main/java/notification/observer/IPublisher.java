package main.java.notification.observer;

public interface IPublisher {
    void subscribe(ISubscriber subscriber);
    void unsubscribe(ISubscriber subscriber);
    void notifySubscribers(String text);
    void notifySubscribers(String text, String[] identifiers);

}

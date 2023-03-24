package main.java.notification.observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// nTODO: As of right now these are all being inherited,
//  but perhaps composition would be a better choice.
//  go look into that.
public class Publisher implements IPublisher{
   private final List<ISubscriber> subscribers = new ArrayList<>();
    @Override
    public void subscribe(ISubscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(ISubscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String message) {
        for(ISubscriber subscriber : this.subscribers){
            subscriber.update(message);
        }
    }

    @Override
    public void notifySubscribers(String message, String[] identifiers) {
        for(ISubscriber subscriber : this.subscribers){
            String subscriberIdentifier = subscriber.getNotificationBehaviour().getIdentifier();
            // Check if the notifier matches any of the identifiers
            if(Arrays.stream(identifiers).anyMatch(subscriberIdentifier::contains)) {
                subscriber.update(message);
            }
        }
    }

    // nTODO: Add an overload that takes a single string as an identifier
}

package main.java.notification.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPublisher implements IPublisher{
   private List<ISubscriber> subscribers = new ArrayList<>();
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
}

package notification.observer;

import project.states.BacklogItemState;

public interface ISetSubscribersAbleBacklogItemState extends BacklogItemState {
    public void setSubscribers();
}

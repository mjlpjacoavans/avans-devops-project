package notification.observer;

import project.states.BacklogItemState;
import sprint.states.SprintState;

public interface ISetSubscribersAbleSprintState extends SprintState {
    public void setSubscribers();
}

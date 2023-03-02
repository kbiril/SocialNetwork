package be.vdab.post;

import be.vdab.person.User;
import be.vdab.util.PostException;

public class EventPost extends Post{
    private EventType eventType;

    public EventPost(User user, EventType eventType) {
        super(user);
        setEventType(eventType);
    }

    public EventType getEventType() {
        return eventType;
    }

    public final void setEventType(EventType eventType) {
        if (eventType != null) {
            this.eventType = eventType;
        } else {
            throw new PostException("Event may not be empty!");
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("EVENT: " + eventType);
    }

    @Override
    public String toString() {
        return super.toString() + ';' + eventType;
    }
}

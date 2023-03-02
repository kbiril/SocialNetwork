package be.vdab.post;

import be.vdab.person.User;
import be.vdab.util.PostException;

public class MessagePost extends Post{
    private String message;


    public MessagePost(User user, String message) {
        super(user);
        setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public final void setMessage (String message) {
        if (message != null && !message.isBlank()) {
            this.message = message;
        } else {
            throw new PostException("Message may not be empty!");
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("MESSAGE: " + message);
    }

    @Override
    public String toString() {
        return super.toString() + ';' + message;
    }
}

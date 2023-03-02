package be.vdab.post;

import be.vdab.person.User;
import be.vdab.util.PostException;

import java.io.Serializable;
import java.util.Objects;

public abstract class Post implements Comparable<Post>, Serializable {
    private static final long serialVersionUID = 1L;
    private User user;
    private final long timestamp = System.currentTimeMillis();

    public Post(User user) {
        setUser(user);
    }

    public long getTimestamp() {
        return timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        if (user != null) {
            this.user = user;
        } else {
            throw new PostException("User may not be empty!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;

        return timestamp == post.timestamp && user.equals(post.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, timestamp);
    }

    @Override
    public int compareTo(Post p) { // van recent naar minder recent
        if (p.timestamp < timestamp) return - 1;
        else if (p.timestamp > timestamp) return 1;
        else return 0;
    }

    public void display() {
        user.display();
        int time = (int) ((System.currentTimeMillis() - timestamp) / 1000);
        if (time <= 59) {
            System.out.println(time + " seconds ago");
        } else {
            System.out.println(time / 60 + " minutes ago");
        }
    }

    @Override
    public String toString() {
        return user.toString() + ';'
                + timestamp;
    }
}

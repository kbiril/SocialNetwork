package be.vdab.post;

import be.vdab.person.User;
import be.vdab.util.PostException;

import java.util.ArrayList;

public class CommentedPost extends MessagePost{
    private int likes = 0;
    private final ArrayList<MessagePost> comments = new ArrayList<>();

    public CommentedPost(User user, String message) {
        super(user, message);
    }


    public int getLikes() {
        return likes;
    }

    public void like() {
        likes++;
    }

    public void unlike() {
        if (likes >= 1) {
            likes--;
        } else {
            throw new PostException("There is no likes, you may not unlike it");
        }
    }

    public void addComment(MessagePost messagePost) {
        comments.add(messagePost);
    }

    @Override
    public void display() {
        super.display();
        StringBuilder commentsToDisplay = new StringBuilder();
        commentsToDisplay.append("COMMENTS:\n").append("\t- " + getLikes() + " people like(s) this\n");
        if (comments.size() != 0) {
            commentsToDisplay.append("\t- " + comments.size() + " comment(s)\n");
            for (MessagePost comment : comments) {
                commentsToDisplay.append("\t\t\t");
                commentsToDisplay.append(comment.getUser().getUsername());
                commentsToDisplay.append(" ----> ");
                commentsToDisplay.append(comment.getMessage());
                commentsToDisplay.append("\n");
            }
        } else {
            commentsToDisplay.append("\t- no comments\n");
        }

        System.out.println(commentsToDisplay);
    }

    @Override
    public String toString() {
        return super.toString() + ";" + likes + ";" + comments;
    }
}

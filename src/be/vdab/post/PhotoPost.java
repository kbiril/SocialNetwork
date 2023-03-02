package be.vdab.post;

import be.vdab.person.User;
import be.vdab.util.PostException;

import java.io.File;

public class PhotoPost extends Post{
    private File filename;
    private String caption;

    public PhotoPost(User user, File filename, String caption) {
        super(user);
        setFilename(filename);
        setCaption(caption);
    }

    public File getFilename() {
        return filename;
    }

    public final void setFilename(File filename) {
        if (filename != null) {
            this.filename = filename;
        } else {
            throw new PostException("Filename may not be empty!");
        }
    }

    public String getCaption() {
        return caption;
    }

    public final void setCaption(String caption) {
        if (caption != null && !caption.isBlank()) {
            this.caption = caption;
        } else {
            throw new PostException("Caption may not be empty!");
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("PHOTO: " + filename + " " + caption);
    }

    @Override
    public String toString() {
        return super.toString() + ';' + filename + ';' + caption;
    }
}

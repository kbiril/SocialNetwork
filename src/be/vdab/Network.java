package be.vdab;

import be.vdab.newsfeed.NewsFeed;
import be.vdab.person.User;
import be.vdab.post.*;
import be.vdab.util.PostException;
import be.vdab.util.UserException;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Network {
    private static final Path PATH = Path.of("/data/newsfeed.dat");
    public static void main(String[] args) {
        // Users
            User katia = new User("kbiril", "Java developer", new File("fotoKatia.jpg"));
            User kenneth = new User("Kenneth", "Java docent", new File("fotoKenneth.jpg"));
            User ilse = new User("Ilse", "Scrum & SQL docent", new File("fotoIlse.jpg"));
            User tony = new User("Tony", "PHP docent", new File("fotoTony"));
            User ignace = new User("Ignace", "c# developer", new File("fotoIgnace.jpg"));
            User raf = new User("Raf", "c# developer", new File("fotoRaf.jpg"));

        try {
            User fout1 = new User("", "Java developer", new File("fotoKatia.jpg"));
        } catch (UserException ue) {
            System.out.println(ue.getMessage());
        }

        try {
            User fout2 = new User("kbiril", "", new File("fotoKatia.jpg"));
        } catch (UserException ue) {
            System.out.println(ue.getMessage());
        }
        try {
            User fout3 = new User("kbiril", "Java developer", null);
        } catch (UserException ue) {
            System.out.println(ue.getMessage());
        }

//        TreeSet<User> users = new TreeSet<>();
//        users.addAll(List.of(katia, kenneth, ilse, tony, ignace, raf));

//        System.out.println("\n");
//        for (User user : users) {
//            user.display();
//        }
//        System.out.println("\n");

        // MessagePosts

        MessagePost messagePost1 = new MessagePost(katia, "Schuurmachine moet ik niet huren! \n " +
                "Van een lieve collega heb ik het gekregen!!!!");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        MessagePost messagePost2 = new MessagePost(new User("Raf", "c# developer",
                new File("fotoRaf.jpg")), "Centra Parks, prachtige vakantie!");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            MessagePost messageFout1 = new MessagePost(kenneth, "");
        } catch (PostException pe) {
            System.out.println(pe.getMessage());
        }

        try {
            MessagePost messageFout2 = new MessagePost(null, "Hello, World");
        } catch (PostException pe) {
            System.out.println(pe.getMessage());
        }

        // PhotoPosts

        PhotoPost photoPost1 = new PhotoPost(kenneth, new File ("mijnZoontjes.jpg"),
                "Met zoons in een speeltuin! :D");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        PhotoPost photoPost2 = new PhotoPost(tony, new File("frankrijk2023.jpg"),
                "Op vakantie met familie :)");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            PhotoPost photoFout1 = new PhotoPost(ilse, null, "geweldig!!");
        } catch (PostException pe) {
            System.out.println(pe.getMessage());
        }

        try {
            PhotoPost photoFout2 = new PhotoPost(ilse, new File("frankrijk2023.jpg"), "");
        } catch (PostException pe) {
            System.out.println(pe.getMessage());
        }

        // Event Posts

        EventPost eventPost1 = new EventPost(ilse, EventType.OPTREDEN);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        EventPost eventPost2 = new EventPost(ignace, EventType.FUIF);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        EventPost eventPost3 = new EventPost(raf, EventType.OPERA);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
        EventPost eventFout1 = new EventPost(tony, null);
        } catch (PostException pe) {
            System.out.println(pe.getMessage());
        }

        // TreeSet van de posts
//        TreeSet<Post> posts = new TreeSet<>();
//
//        posts.addAll(List.of(messagePost1, messagePost2, eventPost2, eventPost3, photoPost1, photoPost2, eventPost1));
//        System.out.println("\n *** Posts ***");
//        for (Post post : posts) {
//            post.display();
//        }
//        System.out.println("\n");

        // CommentedPosts

        CommentedPost commentedPost1 = new CommentedPost(tony, "Zee, Zon, Zomer!!!");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        CommentedPost commentedPost2 = new CommentedPost(kenneth, "op vakantie naar de Disney Parijs!!!");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        CommentedPost commentedPost3 = new CommentedPost(katia, "ik moet nog op experts wachten totdat" +
                "\n ik met mijn deuren begin :( :'( ");
        commentedPost1.like();
        commentedPost1.like();
        commentedPost1.like();
        commentedPost1.unlike();

        try {
            commentedPost2.unlike();
        } catch (PostException pe) {
            System.out.println(pe.getMessage());
        }
        commentedPost2.like();
        commentedPost2.like();
        commentedPost2.like();
        commentedPost2.like();


        commentedPost1.addComment(new MessagePost(katia, "cool!"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        commentedPost1.addComment(new MessagePost(ilse, "veel plezier!"));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        commentedPost1.addComment(new MessagePost(raf, "have fun!"));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        commentedPost2.addComment(new MessagePost(ilse, "geniet ervan"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        commentedPost2.addComment(new MessagePost(katia, "Daar ben ik nog nooit geweest!"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        commentedPost2.addComment(new MessagePost(tony, "het is mooie plek voor kindjes!"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        commentedPost2.addComment(new MessagePost(raf, "daar zijn wij al geweest :)"));

        // TreeSet van Commented Posts
//        System.out.println("\n*** Commented Posts ***\n");
//        TreeSet<CommentedPost> commentedPosts = new TreeSet<>();
//        commentedPosts.addAll(List.of(commentedPost1, commentedPost2, commentedPost3));
//        for (CommentedPost post : commentedPosts) {
//            post.display();
//        }
//
        // News Feed

        NewsFeed newsFeed = new NewsFeed();
        newsFeed.addPost(messagePost1);
        newsFeed.addPost(messagePost2);
        newsFeed.addPost(messagePost1); // double
        newsFeed.addPost(photoPost1);
        newsFeed.addPost(photoPost2);
        newsFeed.addPost(eventPost1);
        newsFeed.addPost(eventPost2);
        newsFeed.addPost(eventPost3);
        newsFeed.addPost(eventPost2); // double
        newsFeed.addPost(commentedPost1);
        newsFeed.addPost(commentedPost2);
        newsFeed.addPost(commentedPost3);
        newsFeed.addPost(commentedPost1); // double
        System.out.println(" ******* New Feed show *******");

        newsFeed.show();
        System.out.println();
        System.out.println(" ******* New Feed gesorteerd *******");
        newsFeed.gesorteerdeLijst().stream().forEach(post -> post.display());
        System.out.println();
        System.out.println(" ******* Enkel PhotoPost (Filter) *******");
        newsFeed.lijstVanPhotoPosts().stream().forEach(photoPost -> photoPost.display());
        System.out.println();


        writeToFile(newsFeed);

        System.out.println(" ******* New Feed from file *******");
        readFromFile().show();


    }

    public static void writeToFile (NewsFeed newsFeed) {
        try (ObjectOutputStream stream = new ObjectOutputStream(Files.newOutputStream(PATH)))
        {
            stream.writeObject(newsFeed);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static NewsFeed readFromFile () {
        try (ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(PATH)))
        {
            return (NewsFeed) stream.readObject();
        }
        catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}

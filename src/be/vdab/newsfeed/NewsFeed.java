package be.vdab.newsfeed;

import be.vdab.post.PhotoPost;
import be.vdab.post.Post;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

public class NewsFeed implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Post> posts = new ArrayList<>();

    public List<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        if (!posts.contains(post)) {
            posts.add(post);
        }
    }

    public void show() {
        if (!posts.isEmpty()) {
            posts.stream().forEach(post -> post.display());

        } else {
            System.out.println("There are no posts added in News Feed");
        }
    }

    public void printLijst(List<Post> posts) {
        posts.stream().forEach(post -> System.out.println(post.toString()));

    }

    public ArrayList<Post> gesorteerdeLijst() {

        return (ArrayList<Post>) posts.stream().sorted((p1, p2) -> -p2.compareTo(p1)).collect(Collectors.toList());
    }

    public List<Post> lijstVanPhotoPosts() {
        return posts.stream().filter(post -> post instanceof PhotoPost).collect(Collectors.toList());
    }

}

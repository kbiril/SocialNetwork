package be.vdab.person;

import be.vdab.util.UserException;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class User implements Comparable<User>, Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String job;
    private File profilephoto;
    private final LocalDateTime registrationdate = LocalDateTime.now();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public User(String username, String job, File profilephoto) {
        setUsername(username);
        setJob(job);
        setProfilephoto(profilephoto);
    }

    public String getUsername() {
        return username;
    }
    public final void setUsername(String username) {
        if (username != null && !username.isBlank()) {
            this.username = username;
        } else {
            throw new UserException("Username may not be empty!");
        }
    }

    public String getJob() {
        return job;
    }

    public final void setJob(String job) {
        if (job != null && !job.isBlank()) {
            this.job = job;
        } else {
            throw new UserException("Job may not be empty!");
        }
    }

    public File getProfilephoto() {
        return profilephoto;
    }

    public final void setProfilephoto(File profilephoto) {
        if (profilephoto != null) {
            this.profilephoto = profilephoto;
        } else {
            throw new UserException("Profilephoto may not be empty!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user )) return false;

        return username.equals(user.username) && registrationdate.equals(user.registrationdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, registrationdate);
    }

    @Override
    public int compareTo(User user) {
        return username.compareToIgnoreCase(user.username); // omdat moet alfabetisch in stijgende volgorde, daarom niet compareTo method
    }

    public void display() {
        StringBuilder userToDisplay = new StringBuilder();
        userToDisplay.append("\nVan ").append(username).append(" - geregistreerd op ")
                .append(registrationdate.format(FORMATTER) + "\n")
                .append("\t" + profilephoto + "\n").append("\tjob: " + job);
        System.out.println(userToDisplay);
    }

    @Override
    public String toString() {
        return username + ';'
                + job + ';'
                + profilephoto + ';'
                + registrationdate;
    }
}

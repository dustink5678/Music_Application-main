package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
//import java.util.UUID;

public class User {
    private String username;
    private String email;
    private String password;
    private LocalDateTime joinDate;
    private ArrayList<Song> favorites;
    private String UUID;

    public User(String username, String email, String password, LocalDateTime joinDate, ArrayList<Song> favorites,
            String UUID) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
        this.favorites = favorites;
        this.UUID = UUID;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public ArrayList<Song> getFavorites() {
        return favorites;
    }

    public String getUUID() {
        return UUID;
    }

    // Add these getter methods needed by DataWriter
    public String getId() {
        return UUID;
    }

    public String getUserName() {
        return username;
    }

    public String getType() {
        return "User"; // Override in Student and Teacher subclasses
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public void setFavorites(ArrayList<Song> favorites) {
        this.favorites = favorites;
    }

    public void setUUID(String uUID) {
        UUID = uUID;
    }

    public boolean login() {
        return true;
    }

    public void updateProfile() {
        // Implementation
    }

    public void addFavorite(Song song) {
        // Implementation
    }

    public boolean isMatch(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
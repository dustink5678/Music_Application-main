package model;

import java.util.ArrayList;
import java.util.HashSet;

public class Library {
    private ArrayList<Song> songs;
    private static Library library;
    private HashSet<User> users;
    private ArrayList<Lesson> lessons; // Fixed: Changed Arraylist to ArrayList

    private Library() {
        songs = new ArrayList<>();
        users = new HashSet<>();
        lessons = new ArrayList<>();
    }
    
    public static Library getInstance() {
        if (library == null) {
            library = new Library();
        }
        return library;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public ArrayList<Song> sortByGenre(String genre) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getGenre().equals(genre)) {
                result.add(song);
            }
        }
        return result;
    }

    public ArrayList<Song> sortByArtist(String artist) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getArtistName().equals(artist)) {
                result.add(song);
            }
        }
        return result;
    }

    public ArrayList<Song> findByName(String title) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getTitle().contains(title)) {
                result.add(song);
            }
        }
        return result;
    }
    
    public void save() {
        // Implementation for saving library data
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public HashSet<User> getUsers() {
        return users;
    }

    public void setUsers(HashSet<User> users) {
        this.users = users;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }
}
package model;

import java.util.ArrayList;

public class MusicLearningApplication {
    @SuppressWarnings("unused")
    private User user;
    @SuppressWarnings("unused")
    private Library library;
    private User currentUser;
    @SuppressWarnings("unused")
    private Song currentSong;

    public MusicLearningApplication() {

    }

    public User sighnup(String username, String email, String password) {
        return null;
    }

    public User login(String username, String password) {
        return currentUser;
    }

    public void logout() {

    }

    public ArrayList<Song> sortByGenre(String genre) {
        return null;
    }

    public ArrayList<Song> sortByName(String name) {
        return null;
    }

    public ArrayList<Song> sortByArtist(String artist) {
        return null;
    }

    public ArrayList<Lesson> manageLessons(User user) {
        return null;
    }

    public boolean updateUserProfile(User user) {
        return true;
    }

    public boolean validateCredentials(String username, String passowrd) {
        return true;
    }

    public boolean comment(Song song, String comment) {
        return true;
    }

    public boolean sceduleLesson(Song currentSong) {
        return true;
    }
}

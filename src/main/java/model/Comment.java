package model;

import java.time.LocalDateTime;

public class Comment {
    @SuppressWarnings("unused")
    private Song song;
    @SuppressWarnings("unused")
    private String text;
    private User author;
    @SuppressWarnings("unused")
    private LocalDateTime timestamp;

    public Comment(Song song, String text, User author, LocalDateTime timestamp) {

    }

    public String getText() {
        return "";
    }

    public User getAuthor() {
        return author;
    }

    public void edit(String text) {

    }
}

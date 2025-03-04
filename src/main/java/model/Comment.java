import java.time.LocalDateTime;

public class Comment {
    private Song song;
    private String text;
    private User author;
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

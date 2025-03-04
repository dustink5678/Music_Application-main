import java.time.LocalDateTime;
import java.util.ArrayList;

public class User {
    private String username;
    private String email;
    private String password;
    private LocalDateTime joinDate;
    private ArrayList<Song> favorites;
    private String UUID;

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

    public User(String username, String email, String password, LocalDateTime joinDate, ArrayList<Song> favorites,
            String UUID) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
        this.favorites = favorites;
        this.UUID = UUID;
    }

    public boolean login() {
        return true;
    }

    public void updateProfile() {

    }

    public void addFavorite(Song song) {

    }

    public boolean isMatch(String username, String password) {
        return true;
    }
}

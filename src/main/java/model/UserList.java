package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;
    private static UserList userList;

    private UserList() {
        users = new ArrayList<>();
    }

    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }
        return userList;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public boolean createUser(String username, String email, String password, LocalDateTime joinDate) {
        // Implementation to create and add a new user
        return true;
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void save() {
        DataWriter.saveUsers();
    }
}
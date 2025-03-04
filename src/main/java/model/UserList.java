package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;
    private static UserList userList;

    private UserList() {

    }

    public UserList getInstance() {
        return userList;
    }

    public boolean createUser(String username, String email, String password, LocalDateTime joinDate) {
        return true;
    }

    public User getUser(Username username) {
        return getUser(username);
    }

    public void save() {

    }
}

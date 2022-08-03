package com.shop.database;

import com.shop.models.Post;
import com.shop.models.User;

import java.util.ArrayList;
import java.util.List;

import static com.shop.util.DataBaseUtil.initRandomDB;

public class DB {
    public static final List<Post> posts = new ArrayList<>();
    public static final List<User> users = new ArrayList<>();

    static {
        initRandomDB(users, posts);
    }

    public static boolean containsUserWithUsername(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsUserWithEmail(String email) {
        for (User u : users) {
            if (u.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static User getByUsernameAndPassword(String username, String password) {
        User user = new User(username, password);
        for (User u: users) {
            if (u.equalsByUsernameAndPassword(user)) {
                return u;
            }
        }
        return null;
    }
}

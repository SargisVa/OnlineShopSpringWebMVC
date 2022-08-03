package com.shop.util;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.shop.models.Post;
import com.shop.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataBaseUtil {
    private static final Faker FAKER = new Faker();
    private static final Random RANDOM = new Random();

    public static void initRandomDB(List<User> users, List<Post> posts) {
        int size = RANDOM.nextInt(100);
        for (int i = 0; i < size; i++) {
            Name name = FAKER.name();
            User user = new User(
                    name.firstName(),
                    name.lastName(),
                    name.username(),
                    name.username() + "@gmail.com",
                    FAKER.internet().password(8, 20, true, true, true)
            );
            posts.addAll(setUserPosts(user));
            users.add(user);
        }
    }

    private static List<Post> setUserPosts(User user) {
        List<Post> posts = new ArrayList<>();
        int size = RANDOM.nextInt(15);
        for (int i = 0; i < size; i++) {
            posts.add(new Post(
                    FAKER.lordOfTheRings().location(),
                    "https://picsum.photos/" + (200 + RANDOM.nextInt() % 100) + "/" + 300));
        }
        user.setPosts(posts);
        return posts;
    }
}

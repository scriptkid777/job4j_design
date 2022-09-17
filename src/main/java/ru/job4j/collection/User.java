package ru.job4j.collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;

public class User {
    private String name;
    private int children;
    private Calendar birthday;


    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>();
        Calendar birthday = Calendar.getInstance();
        User user1 = new User("John", 11, birthday);
        int hashCode1 = user1.hashCode();
        int hash1 = hashCode1 ^ (hashCode1 >>> 16);
        int bucket1  = hash1 & 15;
        User user2 = new User("John", 11, birthday);
        int hashCode2 = user2.hashCode();
        int hash2 = hashCode2 ^ (hashCode2 >>> 16);
        int bucket2  = hash2 & 15;
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.printf("user1 - хэш-код: %s , хэш: %s, бакет: %s ",
                hashCode1, hash1, bucket1);
        System.out.printf("user2 - хэш-код: %s , хэш: %s, бакет: %s",
                hashCode2, hash2, bucket2);
        System.out.println(user1.equals(user2));
    }
}
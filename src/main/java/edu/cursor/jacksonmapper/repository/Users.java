package edu.cursor.jacksonmapper.repository;

import edu.cursor.jacksonmapper.model.User;

import java.time.LocalDate;
import java.util.*;

public class Users {

    private Random random = new Random();

    private List<User> users = new ArrayList<>(Arrays.asList(
            new User("james", "bond", LocalDate.of(2019, 8, 5), "jamse@gmail.com", Map.of("HW1", true), random.nextLong()),
            new User("allan", "shearer", LocalDate.of(2019, 8, 9), "allsh@gmail.com", Map.of("HW1", false), random.nextLong()),
            new User("jack", "toms", LocalDate.of(2019, 8, 10), "tom@gmail.com", Map.of("HW1", true), random.nextLong()),
            new User("elli", "goldwin", LocalDate.of(2019, 8, 8), "winr@gmail.com", Map.of("HW1", true), random.nextLong())
    ));

    public List<User> getUsers() {
        return users;
    }


}

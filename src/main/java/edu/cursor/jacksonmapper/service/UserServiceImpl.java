package edu.cursor.jacksonmapper.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.cursor.jacksonmapper.model.User;
import edu.cursor.jacksonmapper.repository.Users;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    private final String FILE_PATH = "C:\\Users\\User\\Desktop\\user.json";

    @Override
    public User getUser(String email)  {
        Users usersList = new Users();
        return usersList.getUsers().stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void serializationToJson(User user) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Random random = new Random();
        user.setAccessId(random.nextLong());
        objectMapper.writeValue(new FileOutputStream(FILE_PATH), user);
    }


}

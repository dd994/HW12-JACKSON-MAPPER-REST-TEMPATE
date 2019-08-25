package edu.cursor.jacksonmapper.service;

import edu.cursor.jacksonmapper.model.User;

import java.io.IOException;

public interface UserService {
    User getUser(String email);
    void serializationToJson(User user) throws IOException;
}

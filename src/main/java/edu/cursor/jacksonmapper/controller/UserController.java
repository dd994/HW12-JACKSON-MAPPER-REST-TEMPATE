package edu.cursor.jacksonmapper.controller;

import edu.cursor.jacksonmapper.model.User;
import edu.cursor.jacksonmapper.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("users")
public class UserController {

    private UserServiceImpl userServiceImpl = new UserServiceImpl();

    @GetMapping("/getUser/{email}")
    public User getUserByEmail(@PathVariable("email") String email) {
        return userServiceImpl.getUser(email);
    }

    @PostMapping("addUser")
    public void addUserToFile(@RequestBody User user) throws IOException {
        userServiceImpl.serializToJson(user);
    }

}

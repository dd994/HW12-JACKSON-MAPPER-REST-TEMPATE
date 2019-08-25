package edu.cursor.jacksonmapper;


import edu.cursor.jacksonmapper.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class RestTemplateApplication {

    private final RestTemplate restTemplate = new RestTemplate();

    Random random = new Random();

    String urlForGet = "http://localhost:8080/users/getUser/jamse@gmail.com";
    String urlForPost = "http://localhost:8080/users/addUser";

    User user = new User("james", "bond", LocalDate.of(2019, 8, 5), "jamse@gmail.com", Map.of("HW1", false), random.nextLong());

    @Test
    public void getUserByRestTemplateTest() {
        ResponseEntity<User> responseEntity = restTemplate.getForEntity(urlForGet, User.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user, responseEntity.getBody());
    }

    @Test
    public void serializationToJsonByRestTemplateTest() {
        HttpEntity<User> UserRequest = new HttpEntity<>(user);
        ResponseEntity<HttpStatus> responseEntity = restTemplate.postForEntity(urlForPost, UserRequest, HttpStatus.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user, responseEntity.getBody());
    }
}

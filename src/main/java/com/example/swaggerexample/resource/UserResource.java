package com.example.swaggerexample.resource;

import com.example.swaggerexample.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/user")
@Api(value = "User Resource REST EndPoint", description = "Shows the user info")
public class UserResource {

    @GetMapping
    public List<User> list() {
        return Arrays.asList(
                new User("Sam", 2000L),
                new User("Peter", 1000L)
        );
    }

    @GetMapping("/{userName}")
    public User get(@PathVariable("userName") final String userName) {
        return new User(userName, 1500L);
    }

    @ApiOperation(value = "Returns Hello world Post")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insert(@RequestBody Map<String, String> body) {
        return new ResponseEntity<>("Body param map: " + body, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns Hello world Put")
    @PutMapping()
    public String update(@RequestBody final String hello) {
        return "UPDATE " + hello;
    }

    @ApiOperation(value = "Returns Hello world Delete")
    @DeleteMapping()
    public String delete(@RequestBody final String hello) {
        return "DELETE " + hello;
    }
}

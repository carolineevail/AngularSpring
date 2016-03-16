package com.theironyard.controllers;

import com.theironyard.entities.User;
import com.theironyard.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Caroline on 3/16/16.
 */
@RestController
public class AngularSpringController {
    @Autowired
    UserRepository users;

    @RequestMapping(path = "/user", method = RequestMethod.GET) // read
    public List<User> getUsers() {
        return (List<User>) users.findAll();
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST) // add
    public void addUser(@RequestBody User user) {
        users.save(user);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.PUT) // edit
    public void updateUser(@RequestBody User user, @PathVariable("id") int id) {  // use @PathVariable to access the {id}
        users.save(user);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE) // delete
    public void deleteUser(@PathVariable("id") int id) {
        users.delete(id);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET) // find one user
    public User getUser(@PathVariable("id") int id) {
        return users.findOne(id);
    }

}

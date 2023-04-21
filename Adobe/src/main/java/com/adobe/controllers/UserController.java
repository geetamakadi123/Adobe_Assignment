package com.adobe.controllers;

import com.adobe.exceptions.UserException;
import com.adobe.models.User;
import com.adobe.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService us;

    @PostMapping("/Users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws UserException {

        return new ResponseEntity<User>(us.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/Users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) throws UserException {

        return new ResponseEntity<User>(us.getUser(id), HttpStatus.OK);
    }

    @PutMapping("/Users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @Valid @RequestBody User updatedUser) throws UserException {

        return new ResponseEntity<User>(us.updateUser(id,updatedUser), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/Users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id) throws UserException{

        return new ResponseEntity<User>(us.deleteUser(id), HttpStatus.OK);// due to swagger exception Failed to convert value of type 'java.lang.String' to required type 'int'. so i do change int to string;

    }

    @GetMapping("/analytics/users")
    public ResponseEntity<Long> getTotalUsers() {

        return new ResponseEntity<Long>(us.getTotalUsers(), HttpStatus.OK);
    }

    @GetMapping("/analytics/users/top-active")
    public ResponseEntity<List<User>> getTopActiveUsers() {

        return new ResponseEntity<List<User>>(us.getTop5ActiveUsers(), HttpStatus.OK);
    }

}

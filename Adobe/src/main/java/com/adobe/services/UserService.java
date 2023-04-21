package com.adobe.services;

import com.adobe.exceptions.UserException;
import com.adobe.models.User;

import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public User createUser(User user) throws UserException;
    public User getUser(int id) throws UserException;
    public User updateUser(int id,User updatedUser) throws UserException;
    public User deleteUser(int id) throws UserException;
    public long getTotalUsers();
    public List<User> getTop5ActiveUsers();
}
//POST /users: Create a new user;
//GET /users/{id}: Retrieve a user by id.
//PUT /users/{id}: Update a user's name or bio by id.
//DELETE /users/{id}: Delete a user by id.
//GET /analytics/users: Retrieve the total number of users.
//GET /analytics/users/top-active: Retrieve the top 5 most active users, based on the number of posts.


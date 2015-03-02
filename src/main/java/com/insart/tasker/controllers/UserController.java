package com.insart.tasker.controllers;

import com.insart.tasker.dao.FriendshipDAO;
import com.insart.tasker.model.Friendship;
import com.insart.tasker.model.User;
import com.insart.tasker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * User: Evgeniy James
 * Date: 22.02.2015
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FriendshipDAO friendshipDAO;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User addUser(
            @RequestParam(value = "login", required = false) String login,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "name", required = false) String name
    ) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        return userService.save(user);
    }

    @RequestMapping("/deleteUser")
    public void deleteUser(
            @RequestParam(value = "id", required = false)String id
    ) {
        long l;
        try {
            l = Long.valueOf(id);
        } catch (NumberFormatException e) {
            System.err.println("Number Format Exception. " + e);
            throw new NumberFormatException();
        }
        User user = userService.findUserById(l);
        userService.delete(user);
    }

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @RequestMapping("/getFriendships")
    public List<Friendship> getFriendships() {
        return friendshipDAO.findAll();
    }

    @RequestMapping("/getFriends")
    public Set getFriends(
            @RequestParam(value = "id", required = false) String id
    ) {
        long l;
        try {
            l = Long.valueOf(id);
        } catch (NumberFormatException e) {
            System.err.println("Number Format Exception. " + e);
            throw new NumberFormatException();
        }
        return userService.findUserFriends(l);
    }

    @RequestMapping("/getInviters")
    public Set<User> getInviters(
            @RequestParam(value = "id", required = false) String id
    ) {
        long l;
        try {
            l = Long.valueOf(id);
        } catch (NumberFormatException e) {
            System.err.println("Number Format Exception. " + e);
            throw new NumberFormatException();
        }
        return userService.findUserInviters(l);
    }

    @RequestMapping("/addFriendRequest")
    public Friendship addFriendRequset(
            @RequestParam(value = "idOne", required = false) String idOne,
            @RequestParam(value = "idTwo", required = false) String idTwo
    ) {
        long l1, l2;
        try {
            l1 = Long.valueOf(idOne);
            l2 = Long.valueOf(idTwo);
        } catch (NumberFormatException e) {
            System.err.println("Number Format Exception. " + e);
            throw new NumberFormatException();
        }
        return userService.sendFriendshipRequest(l1, l2);
    }

    @RequestMapping("/deleteFriend")
    public void deleteFriend(
            @RequestParam(value = "idOne", required = false) String idOne,
            @RequestParam(value = "idTwo", required = false) String idTwo
    ) {
        long l1, l2;
        try {
            l1 = Long.valueOf(idOne);
            l2 = Long.valueOf(idTwo);
        } catch (NumberFormatException e) {
            System.err.println("Number Format Exception. " + e);
            throw new NumberFormatException();
        }
        userService.deleteFriend(l1, l2);
    }
}

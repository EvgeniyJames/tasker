package com.insart.tasker.controllers;

import com.insart.tasker.dao.FriendshipDAO;
import com.insart.tasker.enums.FriendshipStatus;
import com.insart.tasker.model.Friendship;
import com.insart.tasker.model.Tasklist;
import com.insart.tasker.model.User;
import com.insart.tasker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    /*@RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User addUser(
            @RequestParam(value = "login") String login,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "name") String name
    ) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        return userService.save(user);
    }

    @RequestMapping("/deleteUser")
    public void deleteUser(
            @RequestParam(value = "id")String id
    ) {
        long l;
        try {
            l = Long.valueOf(id);
        } catch (NumberFormatException e) {
            System.err.println("Number Format Exception. " + e);
            throw new NumberFormatException();
        }
        userService.delete(l);
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
            @RequestParam(value = "id") String id
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
            @RequestParam(value = "id") String id
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
    }*/

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        User new_user = new User();
        new_user.setLogin(user.getLogin());
        new_user.setPassword(user.getPassword());
        user.setName(user.getName());
        return userService.save(new_user);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserInfoById(@PathVariable("id") Long id) {
        return  userService.findUserById(id);
    }

    /////// TODO Change to /friends
    @RequestMapping(value = "/{id}/friends", method = RequestMethod.GET)
    public Set<User> getFriends(@PathVariable("id") Long id) {
        return userService.findUserFriends(id);
    }

    /////// TODO Change to /request
    @RequestMapping(value = "/{id}/request", method = RequestMethod.GET)
    public List<Friendship> getFriendRequests(@PathVariable("id") Long id) {
        return friendshipDAO.findByIdOneAndRelationship(id, FriendshipStatus.INVITE);
    }

    // TODO
    @RequestMapping(value = "/{id_friend}/request", method = RequestMethod.POST)
    public Friendship sendFriendRequest(@PathVariable("id_friend") Long id_friend) {
        ///return userService.sendFriendshipRequest(Long.valueOf(idOne), Long.valueOf(idTwo));
        return new Friendship();
    }

    // TODO
    @RequestMapping(value = "/{id_friend}/request/", method = RequestMethod.PUT)
    public Friendship acceptFriendRequest(@PathVariable("id_friend") Long idFriend) {
        return new Friendship();
    }

    // TODO
    @RequestMapping(value = "/{id_friend}/request", method = RequestMethod.DELETE)
    public String declineFriendRequest(@PathVariable("id_friend") Long idFriend) {
        //userService.deleteFriend(Long.valueOf(idOne),Long.valueOf(idTwo));
        return "ok";
    }

    @RequestMapping(value = "/{id}/tasklist", method = RequestMethod.GET)
    public List<Tasklist> getTaskListsCreatedByUser(@PathVariable("id") Long id) {
        return userService.getTaskListsCreatedByUser(id);
    }

    @RequestMapping(value = "/search/{login}", method = RequestMethod.GET)
    public User findUserByLogin(@PathVariable("login") String login) {
        return userService.findByLogin(login);
    }
}

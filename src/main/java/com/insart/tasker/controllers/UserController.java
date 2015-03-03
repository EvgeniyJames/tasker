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

    /**
     * Добавление {@link com.insart.tasker.model.User} в БД
     * @param login Login
     * @param password Password
     * @param name Name
     * @return {@link com.insart.tasker.model.User} в БД
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
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

    /**
     * Удаление {@link com.insart.tasker.model.User}
     * @param id id of deleting {@link com.insart.tasker.model.User}
     */
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

    /**
     * Список всех {@link com.insart.tasker.model.User} из БД
     * @return {@link java.util.List} {@link com.insart.tasker.model.User} из БД
     */
    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        return userService.findAll();
    }

    /**
     * Список всех {@link com.insart.tasker.model.Friendship} из БД
     * @return{@link java.util.List} {@link com.insart.tasker.model.Friendship} из БД
     */
    @RequestMapping("/getFriendships")
    public List<Friendship> getFriendships() {
        return friendshipDAO.findAll();
    }

    /**
     * Получить набор {@link com.insart.tasker.model.User} - друзей
     * @param id id {@link com.insart.tasker.model.User}, чей набор нужно получить
     * @return {@link java.util.Set} {@link com.insart.tasker.model.User} - Друзей
     */
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

    /**
     * Получить набор {@link com.insart.tasker.model.User} подписчиков
     * @param id id {@link com.insart.tasker.model.User}, чей набор нужно получить
     * @return {@link java.util.Set} {@link com.insart.tasker.model.User} - подписчиков
     */
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

    /**
     * Добавить запрос на дружбу
     * @param idOne id запрашивающего
     * @param idTwo id запрашиваемого
     * @return Запись Friendship в БД
     */
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

    /**
     * Разорвать дружбу пользователей
     * @param idOne id разываемого дружбу
     * @param idTwo id с кем разрывается дружба
     */
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

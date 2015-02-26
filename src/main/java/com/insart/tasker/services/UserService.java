package com.insart.tasker.services;

import com.insart.tasker.dao.UserDAO;
import com.insart.tasker.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> findAll() {
        return userDAO.findAll();
    }

    //добавить User
    public User addUser(User user) {
        User savedUser = userDAO.saveAndFlush(user);
        return savedUser;
    }

    //удалить User по id
    public void deleteUser(long id)
    {
       userDAO.delete(id);
    }

}

package com.insart.tasker.services;

import com.insart.tasker.dao.TasklistDAO;
import com.insart.tasker.dao.UserDAO;
import com.insart.tasker.model.Tasklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * User: Evgeniy James
 * Date: 22.02.2015
 */
@Service
public class TasklistService {

    @Autowired
    private TasklistDAO tasklistDAO;

    @Autowired
    private UserDAO userDAO;

    public List<Tasklist> findAll(){
        return tasklistDAO.findAll();
    }

    public Tasklist save(Tasklist tasklist) {
        if (userDAO.exists(tasklist.getIdAuthor())) {
            return tasklistDAO.save(tasklist);
        } else {
            return new Tasklist();
        }
    }

    public Tasklist get(Long id) {
        return tasklistDAO.findOne(id);
    }

    public void delete(Long id) {
        tasklistDAO.delete(tasklistDAO.findOne(id));
    }

    public List<Tasklist> findByIdAuthor(Long valueOf) {
        if (userDAO.exists(valueOf)) {
            return tasklistDAO.findByIdAuthor(valueOf);
        }
        else {
            return Collections.emptyList();
        }
    }
}

package com.insart.tasker.services;

import com.insart.tasker.dao.TaskDAO;
import com.insart.tasker.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: thur
 * Date: 18.02.2015
 * Time: 1:26
 */
@Service
public class TaskService {

    @Autowired
    private TaskDAO taskDAO;

    public List<Task> findAll() {
        return taskDAO.findAll();
    }

    //добавить Task
    public Task addTask(Task task)
    {
        Task savedTask=taskDAO.saveAndFlush(task);
        return savedTask;
    }

    //удалить Task по id
    public void deleteTask(long id)
    {
        taskDAO.delete(id);
    }

    public List<Task> findByDescription(String description) {
        return taskDAO.findByDescription(description);
    }

    public List<Task> findByTitle(String title) {
        return taskDAO.findByTitleCustom(title);
    }
}

package com.insart.tasker.services;

import com.insart.tasker.dao.TaskListDAO;
import com.insart.tasker.entities.TaskList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: thur
 * Date: 18.02.2015
 * Time: 1:26
 */
@Service
public class TaskListService {

    @Autowired
    private TaskListDAO taskListDAO;

    public List<TaskList> findAll() {
        return taskListDAO.findAll();
    }

    //добавить TaskList
    public TaskList addTaskList(TaskList taskList) {
        TaskList savedTaskList = taskListDAO.saveAndFlush(taskList);
        return savedTaskList;
    }

    //удалить TaskList по id
    public void deleteTaskList(long id)
    {
        taskListDAO.delete(id);
    }

}

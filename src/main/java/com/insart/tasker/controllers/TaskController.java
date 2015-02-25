package com.insart.tasker.controllers;

import com.insart.tasker.entities.Task;
import com.insart.tasker.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User: thur
 * Date: 18.02.2015
 * Time: 1:27
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Task> findAllTasks() {
        return taskService.findAll();
    }
}

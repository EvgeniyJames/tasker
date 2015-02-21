package com.insart.tasker.controllers;

import com.insart.tasker.entities.Task;
import com.insart.tasker.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
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
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public List<Task> findTasks(
            @RequestParam(value = "description", required = false)String description,
            @RequestParam(value = "title", required = false)String title
            ) {

        if (description != null) {
            System.out.println(">>>> " + description);
            return taskService.findByDescription(description);
        } else if (title != null) {
            return taskService.findByTitle(title);
        } else {
            return Collections.emptyList();
        }
    }
}

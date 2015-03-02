package com.insart.tasker.controllers;

import com.insart.tasker.model.Tasklist;
import com.insart.tasker.services.TaskService;
import com.insart.tasker.services.TasklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User: Evgeniy James
 * Date: 01.03.2015
 */
@RestController
@RequestMapping("/tasklist")
public class TasklistController {

    @Autowired
    private TasklistService tasklistService;

    @Autowired
    private TaskService taskService;

    @RequestMapping("/getAll")
    public List<Tasklist> getAll() {
        return tasklistService.findAll();
    }

    @RequestMapping("/get")
    public Tasklist get(
            @RequestParam(value = "id") String id
    ) {
        try {
            Long l = Long.valueOf(id);
            return tasklistService.get(l);
        } catch (NumberFormatException e) {
            System.out.println("Get TL ID Exception. " + e);
            throw new NumberFormatException();
        }
    }

    @RequestMapping("/add")
    public Tasklist add(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "idAuthor") String idAuthor
    ) {
        Tasklist tasklist = new Tasklist();
        tasklist.setIdAuthor(Long.valueOf(idAuthor));
        tasklist.setTitle(title);
        return tasklistService.save(tasklist);
    }

    @RequestMapping("/delete")
    public void delete(
            @RequestParam(value = "id") String id
    ) {
        try {
            Long valueOf = Long.valueOf(id);
            taskService.findByIdTaskList(valueOf);
            tasklistService.delete(valueOf);
        } catch (NumberFormatException e) {
            System.out.println("Delete TL ID Exception. " + e);
            throw new NumberFormatException();
        }
    }

    @RequestMapping("/getUserTasklists")
    public List<Tasklist> getUserTasklists(
            @RequestParam(value = "id") String id
    ) {
        try {
            Long valueOf = Long.valueOf(id);
            return tasklistService.findByIdAuthor(valueOf);
        } catch (NumberFormatException e) {
            System.out.println("Delete TL ID Exception. " + e);
            throw new NumberFormatException();
        }
    }

}

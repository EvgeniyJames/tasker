package com.insart.tasker.controllers;

import com.insart.tasker.enums.TaskStatus;
import com.insart.tasker.model.Task;
import com.insart.tasker.model.Tasklist;
import com.insart.tasker.services.TaskService;
import com.insart.tasker.services.TasklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    /*@RequestMapping("/getAll")
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
            taskService.deleteByIdTasklist(valueOf);
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
    }*/

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Tasklist> getTaskListsForCurrentUser() {
        return new ArrayList<>();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Tasklist getTaskListById(@PathVariable("id") Long taskListId) {
        return new Tasklist();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteTaskList(@PathVariable("id") Long taskListId) {
        return "ok";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Tasklist createTaskList(@RequestBody Tasklist taskList) {
        return new Tasklist();
    }

    @RequestMapping(value = "/{id}/task", method = RequestMethod.POST)
    public Task createTaskInTaskList(@RequestBody Task task) {
        return new Task();
    }

    @RequestMapping(value = "/task/{id_task}", method = RequestMethod.DELETE)
    public String deleteTaskFromTaskList(@PathVariable("id_task") Long taskId) {
        return "ok";
    }

    @RequestMapping(value = "/{id}/task", method = RequestMethod.GET)
    public List<Task> getAllTasksFromTaskList(@PathVariable("id") Long taskListId) {
        return new ArrayList<>();
    }

    @RequestMapping(value = "/task/{id_task}", method = RequestMethod.GET)
    public Task getTaskFromTaskList(@PathVariable("id_task") Long taskId) {
        return new Task();
    }

    @RequestMapping(value = "/task/{id_task}/status", method = RequestMethod.PUT)
    public TaskStatus setTaskStatus(@PathVariable("id_task") Long taskId, @RequestBody TaskStatus status) {
        return TaskStatus.INACTIVE;
    }

    @RequestMapping(value = "/task/{id_task}/status", method = RequestMethod.GET)
    public TaskStatus getTaskStatus(@PathVariable("id_task") Long taskId) {
        return TaskStatus.INACTIVE;
    }
}

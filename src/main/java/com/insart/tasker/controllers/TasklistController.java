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
        return tasklistService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Tasklist getTaskListById(@PathVariable("id") Long taskListId) {
        return tasklistService.get(taskListId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTaskList(@PathVariable("id") Long taskListId) {
        tasklistService.delete(taskListId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Tasklist createTaskList(@RequestBody Tasklist taskList) {
        Tasklist new_tasklist = new Tasklist();
        new_tasklist.setIdAuthor(taskList.getIdAuthor());
        new_tasklist.setTitle(taskList.getTitle());
        new_tasklist.setIdExecutor(taskList.getIdExecutor());
        return tasklistService.save(new_tasklist);
}

    @RequestMapping(value = "/{id}/task", method = RequestMethod.POST)
    public Task createTaskInTaskList(@RequestBody Task task) {
        //может быть неправильно
        return tasklistService.addTaskInTasklist(task.getTitle(),task.getDescripton(),task.getStatus(),task.getIdTasklist());
    }

    @RequestMapping(value = "/task/{id_task}", method = RequestMethod.DELETE)
    public void  deleteTaskFromTaskList(@PathVariable("id_task") Long taskId) {
        taskService.delete(taskId);
    }

    @RequestMapping(value = "/{id}/task", method = RequestMethod.GET)
    public Set<Task> getAllTasksFromTaskList(@PathVariable("id") Long taskListId) {
        return taskService.findByIdTasklist(taskListId);
    }

    @RequestMapping(value = "/task/{id_task}", method = RequestMethod.GET)
    public Task getTaskFromTaskList(@PathVariable("id_task") Long taskId) {
        return taskService.get(taskId);
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

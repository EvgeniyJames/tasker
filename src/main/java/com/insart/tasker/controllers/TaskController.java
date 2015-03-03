package com.insart.tasker.controllers;

import com.insart.tasker.enums.TaskStatus;
import com.insart.tasker.model.Task;
import com.insart.tasker.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * User: Evgeniy James
 * Date: 01.03.2015
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/getAll")
    public List<Task> getAll() {
        return taskService.findAll();
    }

    @RequestMapping("/get")
    public Task get(
            @RequestParam(value = "id") String id
    ) {
        try {
            Long l = Long.valueOf(id);
            return taskService.get(l);
        } catch (NumberFormatException e) {
            System.out.println("Get Task ID Exception. " + e);
            throw new NumberFormatException();
        }

    }

    @RequestMapping("/add")
    public Task add(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "idExecutor") String idExecutor,
            @RequestParam(value = "idTasklist") String idTasklist
    ) {
        try {
            Long executor = Long.valueOf(idExecutor);
            Long tasklist = Long.valueOf(idTasklist);

            Task task = new Task();
            task.setTitle(title);
            task.setDescripton(description);
            task.setStatus(TaskStatus.INACTIVE);
            task.setIdTasklist(tasklist);
            task.setIdExecutor(executor);

            return taskService.save(task);
        } catch (NumberFormatException e) {
            System.out.println("Save Task ID Exception. " + e);
            throw new NumberFormatException();
        }

    }

    @RequestMapping("/delete")
    public void detele(
            @RequestParam(value = "id") String id
    ) {
        try {
            Long l = Long.valueOf(id);
            taskService.delete(l);
        } catch (NumberFormatException e) {
            System.out.println("Delete Task ID Exception. " + e);
            throw new NumberFormatException();
        }
    }

    @RequestMapping("/getByStatus")
    public Set<Task> getByStatus(
            @RequestParam(value = "status") String status
    ) {
        return taskService.findByStatus(status);
    }

    @RequestMapping("/getByExecutor")
    public Set<Task> getByExecutor(
            @RequestParam(value = "idExecutor") String idExecutor
    ) {
        try {
            Long l = Long.valueOf(idExecutor);
            return taskService.getByIdExecutor(l);
        } catch (NumberFormatException e) {
            System.out.println("getByExecutor Task ID Exception. " + e);
            throw new NumberFormatException();
        }
    }
}

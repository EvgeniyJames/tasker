package com.insart.tasker.services;

import com.insart.tasker.dao.TaskDAO;
import com.insart.tasker.dao.TasklistDAO;
import com.insart.tasker.dao.UserDAO;
import com.insart.tasker.enums.TaskStatus;
import com.insart.tasker.model.Task;
import com.insart.tasker.model.Tasklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * User: thur
 * Date: 18.02.2015
 * Time: 1:26
 */
@Service
public class TaskService {

    @Autowired
    private TaskDAO taskDAO;

    @Autowired
    private TasklistDAO tasklistDAO;

    @Autowired
    private UserDAO userDAO;

    public List<Task> findAll() {
        return taskDAO.findAll();
    }

    public Task save(Task task){
        if(tasklistDAO.exists(task.getIdTasklist())) {
            if(userDAO.exists(task.getIdExecutor())) {
                return taskDAO.save(task);
            }
        }
        return new Task();
    }

    public Task get(Long id) {
        return taskDAO.findOne(id);
    }

    public void delete(Long l) {
        taskDAO.delete(l);
    }

    public Set<Task> findByStatus(String status) {
        TaskStatus taskStatus = Enum.valueOf(TaskStatus.class, status);
        return taskDAO.findByStatus(taskStatus);
    }

    public Set<Task> getByIdExecutor(Long idExecutor) {
        return taskDAO.findByIdExecutor(idExecutor);
    }

    public Set<Task> findByIdTaskList(Long idTasklist) {
        return taskDAO.findByIdTasklist(idTasklist);
    }
}

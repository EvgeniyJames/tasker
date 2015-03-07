package com.insart.tasker.services;

import com.insart.tasker.dao.TaskDAO;
import com.insart.tasker.dao.TasklistDAO;
import com.insart.tasker.dao.UserDAO;
import com.insart.tasker.enums.TaskStatus;
import com.insart.tasker.model.Task;
import com.insart.tasker.model.Tasklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insart.tasker.services.TaskService;
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

    @Autowired
    private TaskDAO taskDAO;


    @Autowired
    private TaskService taskService;

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

    /*
    При удалении TL нужно удалить все Таски, привязанные к нему
     */
    public void delete(Long id) {
        taskDAO.deleteByIdTasklist(id);
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

    /*
    Когда удаляем Юзера - автора Тасклистов
     */
    public void deleteByIdAuthor(long idAuthor) {
        List<Tasklist> byIdAuthor = tasklistDAO.findByIdAuthor(idAuthor);
        for (Tasklist tasklist : byIdAuthor) {
            taskDAO.deleteByIdTasklist(tasklist.getId());
        }
        tasklistDAO.deleteByIdAuthor(idAuthor);
    }

    /*добавть таск в тасклист*/
    public Task addTaskInTasklist(String title,String description,TaskStatus status, Long idTasklist )
    {
        Task task = new Task();
        task.setTitle(title);
        task.setDescripton(description);
        task.setStatus(TaskStatus.INACTIVE);
        task.setIdTasklist(Long.valueOf(idTasklist));
        return taskService.save(task);
    }

}

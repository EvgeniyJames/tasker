package util;

import com.insart.tasker.entities.Task;
import com.insart.tasker.enums.TaskStatus;

import java.util.Date;

public class TaskUtil {
    public static Task createTask(String title,String description) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(TaskStatus.NEW);
        task.setCreated(new Date());
        task.setUpdated(new Date());
        return task;
    }
}

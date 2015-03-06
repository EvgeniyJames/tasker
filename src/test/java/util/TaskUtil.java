package util;

import com.insart.tasker.enums.TaskStatus;
import com.insart.tasker.model.Task;

public class TaskUtil {
    /**
     * Добавление {@link com.insart.tasker.model.Task} в БД
     * @param title title
     * @param description description
     //* @param status status
     * @return {@link com.insart.tasker.model.Task} в БД
     */
    public static Task createTask(String title,String description, Long idTasklist) {
        Task task=new Task();
        task.setTitle(title);
        task.setStatus(TaskStatus.DO);
        task.setDescripton(description);
        task.setIdTasklist(idTasklist);
        return task;
    }
}

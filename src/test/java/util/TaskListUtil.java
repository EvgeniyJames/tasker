package util;

import com.insart.tasker.entities.Task;
import com.insart.tasker.entities.TaskList;
import com.insart.tasker.entities.User;
import com.insart.tasker.enums.TaskStatus;

import java.util.ArrayList;

public class TaskListUtil {
    public static TaskList createTaskList(String title, Task new_task) {

        TaskList taskList=new TaskList();
        taskList.setTitle(title);
        ArrayList<Task> list=new ArrayList<>();  //список тасков
        list.add(new_task);
        //taskList.setTasks(list);  //записали в тасклист список тасков
        return taskList;
    }
}

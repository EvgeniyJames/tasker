package service;

import com.insart.tasker.entities.Task;
import com.insart.tasker.entities.User;
import com.insart.tasker.services.TaskListService;
import com.insart.tasker.services.TaskService;
import util.TaskListUtil;
import util.TaskUtil;
import config.TestDataBaseConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class TaskListServiceTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private TaskListService taskListService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void testSaveTaskList() throws Exception {
        Task task=new Task();
        task.setTitle("task_title");
        task.setDescription("task_descr");
        TaskServiceTest taskServiceTest=new TaskServiceTest();
        taskServiceTest.setTaskInfo(task);
        //taskServiceTest.testSaveTask();
         for(int i=0;i<10;i++)
        { taskListService.addTaskList(TaskListUtil.createTaskList("title" + i,task));
        }
    }
}

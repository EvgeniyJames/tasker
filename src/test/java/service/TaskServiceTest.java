package service;
import com.insart.tasker.model.Task;
import com.insart.tasker.model.User;
import com.insart.tasker.services.TaskService;
import com.insart.tasker.services.UserService;
import config.TestDataBaseConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import util.TaskUtil;
import util.UserUtil;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class TaskServiceTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private TaskService taskService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    /*после выполнения этого теста занесется
    * информация в таблицу task
    * в данном случае - для 10-ти записей
    * */
    @Test
    public void testSaveTask() throws Exception {
        for(int i=0;i<10;i++) {
            taskService.save(TaskUtil.createTask("title" + i, "desciption" + i,Long.valueOf(i)));
        }
    }

    /*после выполнения этого теста получаем
   * список всех тасков в БД
   */
    @Test
    public void testFindAll()
    {   List <Task> allTasks = taskService.findAll();
        for(Task task:allTasks)
        {System.out.println(task);
        }
    }
}

package service;
import com.insart.tasker.model.Task;
import com.insart.tasker.model.Tasklist;
import com.insart.tasker.services.TasklistService;
import config.TestDataBaseConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import util.TasklistUtil;
import util.UserUtil;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class TasklistServiceTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private TasklistService tasklistService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    /*после выполнения этого теста занесется
    * информация в таблицу tasklist
    * в данном случае - для 10-ти записей
    * */
    @Test
    public void testSaveTasklist() throws Exception {
        for(int i=1;i<10;i++) {
           tasklistService.save(TasklistUtil.createTasklist("title" + i,Long.valueOf(i),Long.valueOf(i-1)));
        }
    }

    /*после выполнения этого теста получаем
  * список всех тасклистов в БД
  */
    @Test
    public void testFindAll()
    {   List <Tasklist> allTasklists = tasklistService.findAll();
        for(Tasklist tasklists:allTasklists)
        {System.out.println(tasklists);
        }
    }

}

package service;
import com.insart.tasker.model.User;
import com.insart.tasker.services.UserService;
import config.TestDataBaseConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import util.UserUtil;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class UserServiceTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    /*после выполнения этого теста занесется
    * информация в таблицу user
    * в данном случае - для 10-ти пользователей
    * */
    @Test
    public void testSaveUser() throws Exception {
        for(int i=0;i<10;i++) {
            userService.save(UserUtil.createUser("login"+i, "password"+i, "name"+i));
        }
    }

    /*после выполнения этого теста получаем
    * список всех юзеров
    */
    @Test
    public void testFindAll()
    {   List <User> allUsers = userService.findAll();
        for(User user : allUsers)
        { System.out.println(user);
        }
    }

    /*после выполнения этого теста получаем
   * информацию о юзере по id
   */
    @Test
    public void testFindUserById()
    {  Long id=Long.valueOf(3);
       User user=userService.findUserById(id);
       System.out.println("info about user with id " + id + user);
    }
}

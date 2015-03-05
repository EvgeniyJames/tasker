package util;
import com.insart.tasker.model.User;

public class UserUtil {
    /**
     * Добавление {@link com.insart.tasker.model.User} в БД
     * @param login login
     * @param password password
     * @param  name name
     * @return {@link com.insart.tasker.model.User} в БД
     */
    public static User createUser(String login,String password,String name) {
        User user=new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        return user;
    }
}

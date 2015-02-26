package util;

import com.insart.tasker.entities.User;


public class UserUtil {
    public static User createUser(String login,String password, String email) {

        User user=new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        return user;
    }
}
package com.insart.tasker.dao;

import com.insart.tasker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Evgeniy James on 22.02.2015.
 */
@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    User findByLogin(String login);
}

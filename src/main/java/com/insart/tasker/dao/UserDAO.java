package com.insart.tasker.dao;

import com.insart.tasker.model.Tasklist;
import com.insart.tasker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Evgeniy James on 22.02.2015.
 */
@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    @Query("select u from User u where u.login = :login")
    User findByLogin(@Param("login")String login);


    @Query("select t from Tasklist t where t.idAuthor = :id")
    List<Tasklist> getTaskListsByUser(@Param("id")Long id);
}

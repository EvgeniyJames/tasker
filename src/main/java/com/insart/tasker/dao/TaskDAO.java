package com.insart.tasker.dao;

import com.insart.tasker.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: thur
 * Date: 18.02.2015
 * Time: 1:25
 */
@Repository
public interface TaskDAO extends JpaRepository<Task, Long> {

    List<Task> findByDescription(String description);

    @Query("select object (o) from Task as o where o.title = ?1")
    List<Task> findByTitleCustom(String title);

}

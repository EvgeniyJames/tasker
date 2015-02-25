package com.insart.tasker.dao;

import com.insart.tasker.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User: thur
 * Date: 18.02.2015
 * Time: 1:25
 */
@Repository
public interface TaskDAO extends JpaRepository<Task, Long> {


}

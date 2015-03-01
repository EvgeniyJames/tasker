package com.insart.tasker.dao;

import com.insart.tasker.entities.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskListDAO extends JpaRepository<TaskList, Long> {

}

package com.insart.tasker.dao;

import com.insart.tasker.enums.TaskStatus;
import com.insart.tasker.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * User: thur
 * Date: 18.02.2015
 * Time: 1:25
 */
@Repository
public interface TaskDAO extends JpaRepository<Task, Long> {
    Set<Task> findByStatus(TaskStatus taskStatus);

    Set<Task> findByIdExecutor(Long idExecutor);

    Set<Task> findByIdTasklist(Long idTasklist);

    @Modifying
    @Query("delete task t where t.getIdTasklist = ?1")
    void deleteByIdTasklist(long id);

    /*@Query("select object (o) from Task as o where o.title = ?1")
    List<Task> findByTitleCustom(String title);*/

}

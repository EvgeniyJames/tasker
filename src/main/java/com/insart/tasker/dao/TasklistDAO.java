package com.insart.tasker.dao;

import com.insart.tasker.model.Tasklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Evgeniy James on 22.02.2015.
 */
@Repository
public interface TasklistDAO extends JpaRepository<Tasklist, Long> {

    List<Tasklist> findByIdAuthor(Long valueOf);

    @Transactional
    @Modifying
    @Query("delete from Tasklist t where t.idAuthor = ?1")
    void deleteByIdAuthor(long id);
}

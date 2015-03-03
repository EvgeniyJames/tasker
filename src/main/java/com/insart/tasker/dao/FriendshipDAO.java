package com.insart.tasker.dao;

import com.insart.tasker.enums.FriendshipStatus;
import com.insart.tasker.model.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by Evgeniy James on 22.02.2015.
 */
@Repository
public interface FriendshipDAO extends JpaRepository<Friendship, Long> {

    List<Friendship> findByIdOneAndRelationship(Long idOne, FriendshipStatus relationship);

    List<Friendship> findByIdOneAndIdTwoAndRelationship(Long idOne, Long idTwo, FriendshipStatus friendshipStatus);

    List<Friendship> findByIdOneAndIdTwo(Long idOne, Long idTwo);

    Set<Friendship> findByIdTwoAndRelationship(Long idTwo, FriendshipStatus relationship);

    @Modifying
    @Query("delete friendship f where f.getIdOne = ?1 or f.getIdTwo = ?1")
    void deleteByIdUser(long id);
}

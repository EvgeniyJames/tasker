package com.insart.tasker.dao;

import com.insart.tasker.entities.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendshipDAO extends JpaRepository<Friendship, Long> {

}

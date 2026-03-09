package com.Project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Project.Entity.MessageEntity;
import com.Project.Entity.UserEntity;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
	
	@Query("""
			SELECT m FROM MessageEntity m
			JOIN FETCH m.sender
			JOIN FETCH m.receiver
			WHERE (m.sender = :user1 AND m.receiver = :user2)
			   OR (m.sender = :user2 AND m.receiver = :user1)
			ORDER BY m.timestamp
			""")
			List<MessageEntity> findConversation(UserEntity user1, UserEntity user2);
}

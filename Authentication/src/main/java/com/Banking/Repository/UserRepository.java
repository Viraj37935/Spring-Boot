package com.Banking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Banking.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
		
	@Query(value = "select * from user_entity where name=:nm;",nativeQuery = true)
	public UserEntity getUser(@Param(value = "nm") String nm);
}

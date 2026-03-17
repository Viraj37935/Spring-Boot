package com.YouTube.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.YouTube.Entity.Creator;

@Repository
public interface CreatorRepository extends JpaRepository<Creator, Integer> {

}

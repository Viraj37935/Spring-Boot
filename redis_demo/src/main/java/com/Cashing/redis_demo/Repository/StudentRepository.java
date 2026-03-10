package com.Cashing.redis_demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Cashing.redis_demo.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}

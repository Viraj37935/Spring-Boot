package com.IT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IT.Entity.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer> {

}

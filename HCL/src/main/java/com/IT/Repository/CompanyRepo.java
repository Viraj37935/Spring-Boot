package com.IT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IT.Entity.Company;

public interface CompanyRepo extends JpaRepository<Company,Integer> {

}

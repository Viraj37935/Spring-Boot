package com.Banking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Banking.Entity.BankEntity;

@Repository
public interface BankRepository extends JpaRepository<BankEntity, Integer> {

}

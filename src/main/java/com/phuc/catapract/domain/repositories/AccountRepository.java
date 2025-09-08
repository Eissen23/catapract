package com.phuc.catapract.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phuc.catapract.domain.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {}

package com.bankaccount.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankaccount.entity.BankEntity;

public interface BankRepository extends JpaRepository<BankEntity, Long> {

    Optional<BankEntity> findByAccountHolderName(String accountHolderName);
}
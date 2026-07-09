package com.bankaccount.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaccount.entity.BankEntity;
import com.bankaccount.repository.BankRepository;

@Service
public class BankService {

    @Autowired
    BankRepository bankRepository;

    public List<BankEntity> getAllAccounts() {
        return (List<BankEntity>) bankRepository.findAll();
    }

    public void save(BankEntity bankEntity) {
        bankRepository.save(bankEntity);
    }

    public void delete(Long id) {
        bankRepository.deleteById(id);
    }

    public BankEntity getAccountById(Long id) {
        BankEntity bankEntity = null;
        Optional<BankEntity> optional = bankRepository.findById(id);
        if (optional.isPresent()) {
            bankEntity = optional.get();
        } else {
            System.out.println("Account not found with ID: " + id);
        }
        return bankEntity;
    }

    public BankEntity getAccountByAccountHolderName(String accountHolderName) {
        BankEntity bankEntity = null;
        Optional<BankEntity> findByAccountHolderName = bankRepository.findByAccountHolderName(accountHolderName);
        if (findByAccountHolderName.isPresent()) {
            bankEntity = findByAccountHolderName.get();
        } else {
            System.out.println("Account not found with Name: " + accountHolderName);
        }
        return bankEntity;
    }

    public BankEntity updateAccount(BankEntity bankEntity, Long id) {
        BankEntity existingAccount = bankRepository.findById(id).get();
        existingAccount.setAccountHolderName(bankEntity.getAccountHolderName());
        existingAccount.setAccountType(bankEntity.getAccountType());
        existingAccount.setBalance(bankEntity.getBalance());
        return bankRepository.save(existingAccount);
    }
}
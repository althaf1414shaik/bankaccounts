package com.bankaccount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankaccount.entity.BankEntity;
import com.bankaccount.service.BankService;

@RestController
public class BankController {

    @Autowired
    BankService bankService;

    @GetMapping("/accounts")
    public List<BankEntity> getAllAccounts() {
        return bankService.getAllAccounts();
    }

    @PostMapping("/save")
    public void saveAccount(@RequestBody BankEntity bankEntity) {
        bankService.save(bankEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAccount(@PathVariable("id") Long id) {
        bankService.delete(id);
    }

    @GetMapping("/getbyid/{id}")
    public BankEntity getAccountById(@PathVariable("id") Long id) {
        return bankService.getAccountById(id);
    }

    @GetMapping("/getbyaccountholder/{accountHolderName}")
    public BankEntity getAccountByAccountHolderName(@PathVariable("accountHolderName") String accountHolderName) {
        return bankService.getAccountByAccountHolderName(accountHolderName);
    }

    @PutMapping("/update/{id}")
    public BankEntity updateAccount(@PathVariable("id") Long id, @RequestBody BankEntity bankEntity) {
        return bankService.updateAccount(bankEntity, id);
    }
}
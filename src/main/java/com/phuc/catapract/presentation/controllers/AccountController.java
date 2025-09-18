package com.phuc.catapract.presentation.controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phuc.catapract.application.dto.AccountDTO;
import com.phuc.catapract.application.mapper.AccountMapper;
import com.phuc.catapract.application.services.AccountServices;
import com.phuc.catapract.domain.entities.Account;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;





@RestController
@AllArgsConstructor
public class AccountController {
    
    public final AccountServices accountServices;
    public final AccountMapper accountMapper;

    
    @PostMapping("/public/register")
    public AccountDTO registerAccount(@RequestBody Account account) {

        return accountMapper.toDto(accountServices.register(account));
    }
    

    @GetMapping("/accounts")
    public List<AccountDTO> getAccounts() {
        List<Account> accounts =  accountServices.getAllAcc();
        return accounts.stream()
                       .map(accountMapper::toDto)
                       .toList();
    }
    
}

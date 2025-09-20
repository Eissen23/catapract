package com.phuc.catapract.presentation.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phuc.catapract.application.dto.AccountDTO;
import com.phuc.catapract.application.dto.authenticate.LoginDTO;
import com.phuc.catapract.application.mapper.AccountMapper;
import com.phuc.catapract.application.services.AccountServices;
import com.phuc.catapract.domain.entities.Account;

@RestController
public class AccountController {

    public final AccountServices accountServices;
    public final AccountMapper accountMapper;

    AccountController (AccountServices accountServices,AccountMapper accountMapper) {
        this.accountServices = accountServices;
        this.accountMapper = accountMapper;
    } 

    @PostMapping("/public/register")
    public AccountDTO registerAccount(@RequestBody Account account) {

        return accountMapper.toDto(accountServices.register(account));
    }

    @PostMapping("/public/login")
    public String login(@RequestBody LoginDTO cred) {
        if(!accountServices.verify(cred)) {
            return "Bad credentials";
        }
        return "Success";
    }

    @GetMapping("/accounts")
    public List<AccountDTO> getAccounts() {
        List<Account> accounts = accountServices.getAllAcc();
        return accounts.stream()
                .map(accountMapper::toDto)
                .toList();
    }

}

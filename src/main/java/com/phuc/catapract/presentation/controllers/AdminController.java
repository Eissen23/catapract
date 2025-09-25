package com.phuc.catapract.presentation.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.phuc.catapract.application.dto.AccountDTO;
import com.phuc.catapract.application.mapper.AccountMapper;
import com.phuc.catapract.application.services.AccountServices;
import com.phuc.catapract.domain.entities.Account;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
    private final AccountServices accountServices;
    private final AccountMapper accountMapper;

    @GetMapping("/get-accounts")
    public List<AccountDTO> getAccount () {
        List<Account> accounts = accountServices.getAllAcc();
        
        return accounts.stream()
                       .map(accountMapper::toDto)
                       .toList();
    }
    
}

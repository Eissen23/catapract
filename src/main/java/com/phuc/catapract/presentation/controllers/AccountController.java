package com.phuc.catapract.presentation.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phuc.catapract.application.dto.AccountDTO;
import com.phuc.catapract.application.mapper.AccountMapper;
import com.phuc.catapract.domain.entities.Account;
import com.phuc.catapract.domain.repositories.AccountRepository;



@RestController
public class AccountController {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountController(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountDTO> getAccInfo(@PathVariable Integer id) {
        Account account =  accountRepository.findById(id).orElse(new Account());
        return ResponseEntity.ok(accountMapper.toDto(account));
    }
    
    @GetMapping("/accounts")
    public List<AccountDTO> getAllAcc() {
        List<Account> listAccount = accountRepository.findAll();
        return listAccount.stream()
                          .map(accountMapper::toDto)
                          .collect(Collectors.toList());
    }
    
    @PostMapping("/register")
    public Account postMethodName(@RequestBody Account entity) {
        return accountRepository.save(entity);
    }
    
}

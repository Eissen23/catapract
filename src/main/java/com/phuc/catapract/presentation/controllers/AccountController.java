package com.phuc.catapract.presentation.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phuc.catapract.application.dto.AccountDTO;
import com.phuc.catapract.application.dto.authenticate.LoginDTO;
import com.phuc.catapract.application.mapper.AccountMapper;
import com.phuc.catapract.application.services.AccountServices;
import com.phuc.catapract.domain.entities.Account;
import com.phuc.catapract.domain.utilities.JwtUtil;
import com.phuc.catapract.shared.dto.JwtResponse;

@RestController
public class AccountController {

    public final AccountServices accountServices;
    public final AccountMapper accountMapper;

    AccountController (AccountServices accountServices,AccountMapper accountMapper,JwtUtil  jwtUtil) {
        this.accountServices = accountServices;
        this.accountMapper = accountMapper;
    } 

    @PostMapping("/public/register")
    public AccountDTO registerAccount(@RequestBody Account account) {

        return accountMapper.toDto(accountServices.register(account));
    }

    @PostMapping("/public/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO cred) {
        String token = accountServices.verify(cred);
        if(token == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Bad credentials");
        }
        
        return ResponseEntity.ok(new JwtResponse(token));
    }


}

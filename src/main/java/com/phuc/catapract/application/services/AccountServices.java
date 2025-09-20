package com.phuc.catapract.application.services;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.phuc.catapract.application.dto.authenticate.LoginDTO;
import com.phuc.catapract.domain.entities.Account;
import com.phuc.catapract.domain.repositories.AccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServices {

    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;
    private final AuthenticationManager authenticationManager;

    

    public Account registerAccount(Account account) {
        return null;
    }

    public Account getAccInfo(@PathVariable Integer id) {
        return accountRepository.findById(id).orElse(new Account());
    }

    public List<Account> getAllAcc() {
        return accountRepository.findAll();
    }

    public Account register(Account entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));

        return accountRepository.save(entity);
    }

    public boolean verify(LoginDTO loginCred) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                            loginCred.email(), 
                            loginCred.password()));
        if (!authentication.isAuthenticated()) {
            return false;
        }

        return true;
    }

}

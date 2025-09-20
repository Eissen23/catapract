package com.phuc.catapract.application.services;

import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.phuc.catapract.application.dto.authenticate.LoginDTO;
import com.phuc.catapract.domain.entities.Account;
import com.phuc.catapract.domain.repositories.AccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServices implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return User.builder()
                .username(account.getEmail())
                .password(account.getPassword())
                .roles("USER") // or map roles from your entity if you have them
                .build();
    }

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
        Account unVerified = accountRepository.findByEmail(loginCred.email())
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + loginCred.email()));

        if (!passwordEncoder.matches(loginCred.password(), unVerified.getPassword())) {
            return false;
        }

        return true;
    }

}

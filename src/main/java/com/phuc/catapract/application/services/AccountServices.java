package com.phuc.catapract.application.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.phuc.catapract.domain.entities.Account;
import com.phuc.catapract.domain.repositories.AccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServices implements UserDetailsService{

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

    

}

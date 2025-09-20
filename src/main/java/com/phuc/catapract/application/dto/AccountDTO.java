package com.phuc.catapract.application.dto;

import java.sql.Date;

public record AccountDTO(Integer id,
        String fullName,
        String email,
        Date dateOfBirth) {

}

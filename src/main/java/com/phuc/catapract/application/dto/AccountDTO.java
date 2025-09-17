package com.phuc.catapract.application.dto;

import java.sql.Date;
    
import lombok.Data;

@Data
public class AccountDTO {
    private Integer id;
    private String fullName;
    private String email;
    private Date dateOfBirth;

}

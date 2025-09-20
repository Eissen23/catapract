package com.phuc.catapract.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.phuc.catapract.application.dto.AccountDTO;
import com.phuc.catapract.domain.entities.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDTO toDto(Account account);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    Account toEntity(AccountDTO accountDto);
}
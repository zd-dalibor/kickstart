package com.cmc.kickstart.api.account.dto.mapper;

import com.cmc.kickstart.api.account.dto.model.AccountDto;
import com.cmc.kickstart.model.domain.account.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountMapper {
    public static AccountDto toAccountDto(Account account) {
        if (account == null) return null;

        AccountDto dto = new AccountDto();
        dto.setAccountNum(account.getAccountNum());
        dto.setActive(account.getActive());
        return dto;
    }

    public static List<AccountDto> toAccountDto(List<Account> accounts) {
        if (accounts == null) return null;

        List<AccountDto> dtos = new ArrayList<>();
        for(Account account : accounts) {
            dtos.add(toAccountDto(account));
        }

        return dtos;
    }
}

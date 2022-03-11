package com.cmc.kickstart.api.account.service;

import com.cmc.kickstart.api.account.repository.AccountRepository;
import com.cmc.kickstart.api.account.dto.mapper.AccountMapper;
import com.cmc.kickstart.api.account.dto.model.AccountDto;
import com.cmc.kickstart.model.domain.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto findById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        return AccountMapper.toAccountDto(account.orElse(null));
    }

    @Override
    public List<AccountDto> search(Boolean active, Integer page, Integer count, Map<String, String> sort) {
        List<Account> accounts = accountRepository.search(active, page, count, sort);
        return AccountMapper.toAccountDto(accounts);
    }

    @Override
    public Long searchCount(Boolean active) {
        return accountRepository.searchCount(active);
    }
}

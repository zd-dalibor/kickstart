package com.cmc.kickstart.api.account.service;

import com.cmc.kickstart.api.account.dto.model.AccountDto;

import java.util.List;
import java.util.Map;

public interface AccountService {

    AccountDto findById(Long id);

    List<AccountDto> search(Boolean active, Integer page, Integer count, Map<String, String> sort);
    Long searchCount(Boolean active);

}

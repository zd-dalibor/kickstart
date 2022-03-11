package com.cmc.kickstart.api.account.repository;

import com.cmc.kickstart.model.domain.account.Account;

import java.util.List;
import java.util.Map;

public interface AccountRepositoryCustom {

    List<Account> search(Boolean active, Integer page, Integer count, Map<String, String> sort);

    Long searchCount(Boolean active);
}

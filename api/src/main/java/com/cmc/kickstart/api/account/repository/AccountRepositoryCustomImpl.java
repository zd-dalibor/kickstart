package com.cmc.kickstart.api.account.repository;

import com.cmc.kickstart.model.domain.account.Account;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class AccountRepositoryCustomImpl implements AccountRepositoryCustom {
    private final EntityManager em;

    public AccountRepositoryCustomImpl(JpaContext context) {
        em = context.getEntityManagerByManagedType(Account.class);
    }

    @Override
    public List<Account> search(Boolean active, Integer page, Integer count, Map<String, String> sort) {
        String query = "SELECT a FROM Account a WHERE (:active IS NULL OR a.active = :active)";

        StringBuilder sorting = new StringBuilder();
        for (String key : sort.keySet()) {
            if ("accountNum".equalsIgnoreCase(key)) {
                if("asc".equalsIgnoreCase(sort.get(key))) {
                    sorting.append(" a.accountNum ASC");
                } else if ("desc".equalsIgnoreCase(sort.get(key))) {
                    sorting.append(" a.accountNum DESC");
                }
            } else if ("active".equalsIgnoreCase(key)) {
                if("asc".equalsIgnoreCase(sort.get(key))) {
                    sorting.append(" a.active ASC");
                } else if ("desc".equalsIgnoreCase(sort.get(key))) {
                    sorting.append(" a.active DESC");
                }
            }
        }
        if (sorting.isEmpty()) {
            sorting.append(" a.accountNum DESC");
        }
        query += " ORDER BY" + sorting;

        TypedQuery<Account> queryObj = em.createQuery(query, Account.class)
            .setParameter("active", active)
            .setFirstResult((page - 1) * count).setMaxResults(count);

        return queryObj.getResultList();
    }

    @Override
    public Long searchCount(Boolean active) {
        String query = "SELECT COUNT(a) FROM Account a WHERE (:active IS NULL OR a.active = :active)";

        TypedQuery<Long> queryObj = em.createQuery(query, Long.class)
            .setParameter("active", active);

        return queryObj.getSingleResult();
    }
}

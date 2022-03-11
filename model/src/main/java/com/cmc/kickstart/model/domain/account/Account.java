package com.cmc.kickstart.model.domain.account;

import com.cmc.kickstart.model.jpa.converter.StringBooleanConverter;

import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Account {

    @Column(
        name     = "accountNum",
        nullable = false
    )
    @GeneratedValue(strategy = IDENTITY)
    @Id
    protected Long accountNum;

    @Column(
        name             = "active",
        length           = 1,
        columnDefinition = "char"
    )
    @Convert(converter = StringBooleanConverter.class)
    protected Boolean active = Boolean.TRUE;

    public Long getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(Long accountNum) {
        this.accountNum = accountNum;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Account{" +
            "accountNum=" + accountNum +
            ", active=" + active +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNum, account.accountNum) && Objects.equals(active, account.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNum, active);
    }
}

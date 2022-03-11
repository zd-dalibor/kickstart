package com.cmc.kickstart.api.account.dto.model;

public class AccountDto {
    private Long accountNum;
    private Boolean active;

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
}

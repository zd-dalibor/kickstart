package com.cmc.kickstart.api.account.controller.v1.request;

import com.cmc.kickstart.core.tdo.request.PagingRequest;

public class AccountFindRequest extends PagingRequest {
    private Boolean active;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

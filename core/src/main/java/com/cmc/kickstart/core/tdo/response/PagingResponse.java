package com.cmc.kickstart.core.tdo.response;

import java.util.List;

public class PagingResponse<T> extends ResponseBase {
    private List<T> items;
    private Integer count;
    private Integer page ;
    private Long total;

    public List<T> getItems() {
        return items;
    }

    public PagingResponse<T> setItems(List<T> items) {
        this.items = items;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public PagingResponse<T> setCount(Integer count) {
        this.count = count;
        return this;
    }

    public Integer getPage() {
        return page;
    }

    public PagingResponse<T> setPage(Integer page) {
        this.page = page;
        return this;
    }

    public Long getTotal() {
        return total;
    }

    public PagingResponse<T> setTotal(Long total) {
        this.total = total;
        return this;
    }

    @Override
    public PagingResponse<T> setSuccess(Boolean success) {
        super.setSuccess(success);
        return this;
    }

    @Override
    public PagingResponse<T> setMessage(String message) {
        super.setMessage(message);
        return this;
    }

    @Override
    public PagingResponse<T> setErrors(Errors errors) {
        super.setErrors(errors);
        return this;
    }

    public static <T> PagingResponse<T> ok(List<T> items) {
        return getInstance(items, null, true);
    }

    public static <T> PagingResponse<T> ok(List<T> items, String message) {
        return getInstance(items, message, true);
    }

    public static <T> PagingResponse<T> error(String message) {
        return getInstance(null, message, false);
    }

    private static <T> PagingResponse<T> getInstance(List<T> items, String message, Boolean success) {
        return new PagingResponse<T>().setItems(items).setMessage(message).setSuccess(success);
    }
}

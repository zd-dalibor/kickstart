package com.cmc.kickstart.core.tdo.request;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class PagingRequest {
    public static final int START_PAGE = 1;
    public static final int DEFAULT_COUNT = 10;

    private Integer page = START_PAGE;
    private Integer count = DEFAULT_COUNT;
    private Map<String, String> sorting = new LinkedHashMap<>();

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page < 1 ? START_PAGE : page;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count == null ? DEFAULT_COUNT : count;
    }

    public Map<String, String> getSorting() {
        return sorting;
    }

    public void setSorting(Map<String, String> sorting) {
        this.sorting = sorting;
    }
}

package com.cmc.kickstart.core.tdo.response;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Errors {
    private Map<String, List<String>> fields = new LinkedHashMap<>();
    private List<String> global = new ArrayList<>();

    public Map<String, List<String>> getFields() {
        return fields;
    }

    public Errors setFields(Map<String, List<String>> fields) {
        this.fields = fields;
        return this;
    }

    public List<String> getGlobal() {
        return global;
    }

    public Errors setGlobal(List<String> global) {
        this.global = global;
        return this;
    }
}

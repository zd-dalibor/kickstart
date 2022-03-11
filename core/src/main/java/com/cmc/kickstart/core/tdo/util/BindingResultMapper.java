package com.cmc.kickstart.core.tdo.util;

import com.cmc.kickstart.core.tdo.response.Errors;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;

public class BindingResultMapper {

    public static Errors toErrors(BindingResult result) {
        Errors errors = new Errors();
        result.getFieldErrors().forEach(err -> {
            if (!errors.getFields().containsKey(err.getField())) {
                errors.getFields().put(err.getField(), new ArrayList<>());
            }
            errors.getFields().get(err.getField()).add(err.getDefaultMessage());
        });
        result.getGlobalErrors().forEach(err -> errors.getGlobal().add(err.getDefaultMessage()));
        return errors;
    }
}

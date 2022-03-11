package com.cmc.kickstart.model.jpa.converter;

import javax.persistence.AttributeConverter;

public class StringBooleanConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean b) {
        if (b == null) {
            return null;
        } else if (b.toString().trim().length() == 0) {
            return null;
        }

        if (b) {
            return "Y";
        }

        return "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        } else if (s.trim().length() == 0) {
            return null;
        }

        if (s.equals("Y") || s.equals("y")) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}

package com.cmc.kickstart.core.tdo.response;

public abstract class ResponseBase {
    private Boolean success;
    private String message;
    private Errors errors;

    public Boolean getSuccess() {
        return success;
    }

    public ResponseBase setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseBase setMessage(String message) {
        this.message = message;
        return this;
    }

    public Errors getErrors() {
        return errors;
    }

    public ResponseBase setErrors(Errors errors) {
        this.errors = errors;
        return this;
    }
}

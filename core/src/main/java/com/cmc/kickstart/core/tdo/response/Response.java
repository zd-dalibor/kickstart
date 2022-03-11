package com.cmc.kickstart.core.tdo.response;

public class Response<T> extends ResponseBase {
    private T item;

    public T getItem() {
        return item;
    }

    public Response<T> setItem(T item) {
        this.item = item;
        return this;
    }

    @Override
    public Response<T> setSuccess(Boolean success) {
        super.setSuccess(success);
        return this;
    }

    @Override
    public Response<T> setMessage(String message) {
        super.setMessage(message);
        return this;
    }

    @Override
    public ResponseBase setErrors(Errors errors) {
        super.setErrors(errors);
        return this;
    }

    public static <T> Response<T> ok(T item) {
        return getInstance(item, null, true);
    }

    public static <T> Response<T> ok(T item, String message) {
        return getInstance(item, message, true);
    }

    public static <T> Response<T> error(String message) {
        return getInstance(null, message, false);
    }

    private static <T> Response<T> getInstance(T item, String message, Boolean success) {
        return new Response<T>().setItem(item).setMessage(message).setSuccess(success);
    }
}

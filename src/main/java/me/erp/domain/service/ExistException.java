package me.erp.domain.service;

/**
 * Created by Hao on 2015/1/30.
 */
public class ExistException extends RuntimeException {
    public ExistException() {
        super();
    }

    public ExistException(String message) {
        super(message);
    }

    public ExistException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ExistException(Throwable throwable) {
        super(throwable);
    }
}

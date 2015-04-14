package me.erp.domain.service;

/**
 * 找不到对应entity运行时异常
 * Author: EthanTu <ethan.l.tu@gmail.com>
 * Date: 2015/1/21
 * Time: 3:52
 */
public class NoFoundException extends RuntimeException {
    public NoFoundException() {
        super();
    }

    public NoFoundException(String message) {
        super(message);
    }

    public NoFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public NoFoundException(Throwable throwable) {
        super(throwable);
    }
}


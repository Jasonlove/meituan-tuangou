package com.meituan.tuangou.exception;

/**
 * 没有token
 * @author jiajia.xiao
 * @date 2021/10/1414:07
 */
public class AccessTokenException extends RuntimeException {
    public AccessTokenException(String message) {
        super(message);
    }

    public AccessTokenException() {
        super();
    }
}

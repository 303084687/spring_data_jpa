package com.zhidian.mam.commons;

/**
 * Created by zhangjiming on 2017/6/22.
 */
public class ServiceException extends Exception {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

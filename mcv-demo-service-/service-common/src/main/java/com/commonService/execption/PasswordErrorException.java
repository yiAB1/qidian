package com.commonService.execption;

public class PasswordErrorException extends BaseException {
    public PasswordErrorException(){}
    public PasswordErrorException(String msg) {
        super(msg);
    }
}

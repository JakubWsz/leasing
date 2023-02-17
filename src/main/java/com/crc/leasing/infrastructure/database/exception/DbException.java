package com.crc.leasing.infrastructure.database.exception;

import java.util.Arrays;

public class DbException extends RuntimeException{
    private final DbExceptionCode code;

    public DbException(DbExceptionCode code, Object... arguments) {
        super(String.format(code.getMessage(),code.getStatus(), Arrays.toString(arguments)));
        this.code = code;
    }

    public DbExceptionCode getCode() {
        return code;
    }
}

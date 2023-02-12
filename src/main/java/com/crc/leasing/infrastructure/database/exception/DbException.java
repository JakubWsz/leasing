package com.crc.leasing.infrastructure.database.exception;

public class DbException extends RuntimeException{
    private final DbExceptionCode code;

    public DbException(DbExceptionCode code, Object... arguments) {
        super(String.format(code.getMessage(), arguments));
        this.code = code;
    }

    public DbExceptionCode getCode() {
        return code;
    }
}

package com.crc.leasing.domain.exception;

public class DateConflictException extends RuntimeException {
    private final DomainExceptionCode code;

    public DateConflictException(DomainExceptionCode code, Object... arguments) {
        super(String.format(code.getMessage(), arguments));
        this.code = code;
    }

    public DomainExceptionCode getCode() {
        return code;
    }
}
package com.crc.leasing.domain.exception;

public enum OfficeExceptionCode implements ExceptionCode {
    OFFICE_ALREADY_DELETED("Biuro zostało już usunięte.", 409),
    OFFICE_DOESNT_EXISTS("Biuro nie istnieje.", 404);

    private final String message;
    private final int status;

    OfficeExceptionCode(String message, int status) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getStatus() {
        return status;
    }
}

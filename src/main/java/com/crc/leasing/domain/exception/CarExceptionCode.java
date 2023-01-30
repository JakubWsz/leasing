package com.crc.leasing.domain.exception;

public enum CarExceptionCode implements ExceptionCode {
    CAR_DOESNT_EXISTS( "Samochód nie istnieje.", 404);

    private final String message;
    private final int status;

    CarExceptionCode(String message, int status) {
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

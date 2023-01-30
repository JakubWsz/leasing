package com.crc.leasing.domain.exception;

public enum EmployeeExceptionCode implements ExceptionCode {
    EMPLOYEE_DOESNT_EXISTS("Pracownik nie istnieje.", 404),
    EMPLOYEE_ALREADY_DELETED("Wybrana osoba nie jest już pranownikiem firmy.", 409);
    private final String message;
    private final int status;

    EmployeeExceptionCode(String message, int status) {
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

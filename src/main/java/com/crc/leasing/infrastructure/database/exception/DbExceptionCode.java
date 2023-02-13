package com.crc.leasing.infrastructure.database.exception;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;


@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum DbExceptionCode {
    CAR_NOT_EXISTS("There is no such car with passed uuid.", 400),
    CLIENT_NOT_EXISTS("There is no such client with passed uuid.", 400),
    EMPLOYEE_NOT_EXISTS("There is no such employee with passed uuid.", 400),
    OFFICE_NOT_EXISTS("There is no such office with passed uuid.", 400),
    ADDRESS_NOT_EXIST("There is no such address with passed uuid.", 400),
    RESERVATION_NOT_EXIST("There is no such reservation with passed uuid.", 400);

    String message;
    int status;

    public String getMessage() {
        return message;
    }


    public int getStatus() {
        return status;
    }

    public DbException createException() {
        return new DbException(this);
    }
}

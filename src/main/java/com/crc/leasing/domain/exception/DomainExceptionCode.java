package com.crc.leasing.domain.exception;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;


@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum DomainExceptionCode {

    DATE_CONFLICT("Data conflict occurred.", 400);

    String message;
    int status;

    public String getMessage() {
        return message;
    }


    public int getStatus() {
        return status;
    }

    public DateConflictException createDateConflictException() {return new DateConflictException(this);
    }
}

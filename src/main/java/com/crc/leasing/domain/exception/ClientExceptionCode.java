package com.crc.leasing.domain.exception;

public enum ClientExceptionCode implements ExceptionCode {
    CLIENT_IS_UNDERAGE("Klienet jest niepełnoletni.", 409),
    EMAIL_IS_INVALID("Podany email jest nieprawidłowy.", 400),

    PASSWORD_DONT_INCLUDE_CAPITALS("Podane hasło nie zawierda minimum jednej dużej litery.",
            400),
    PASSWORD_DONT_INCLUDE_SMALL_LETTERS("Podane hasło nie zawierda minimum jednej małej litery.",
            400),
    PASSWORD_DONT_INCLUDE_NUMBERS("Podane hasło nie zawierda minimum jednej cyfry.", 400),
    PASSWORD_DONT_INCLUDE_SPECIALS("Podane hasło nie zawierda minimum jednego znaku specjlanego.",
            400),
    EMAIL_ALREADY_EXISTS("Konto o podanym e-mailu '%s' już istnieje.", 400),
    OFFICE_DOESNT_EXISTS("Biuro nie istnieje.", 400),
    OFFICE_ALREADY_DELETED("Biuro zostało już usunięte.", 400),
    NAME_OR_SURNAME_IS_INVALID("Imię lub nazwisko jest niepoprawne", 400),
    NO_SUCH_CLIENT("Klient nie istnieje.", 400);

    private final String message;
    private final int status;

    ClientExceptionCode(String message, int status) {
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


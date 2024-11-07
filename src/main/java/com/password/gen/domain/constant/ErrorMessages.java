package com.password.gen.domain.constant;

import lombok.Getter;

@Getter
public enum ErrorMessages {
    NULL_OBJECT("Field cannot be null"),
    EMPTY_FIELD("Field cannot be empty,blank or null"),
    LENGTH_NOT_VALID("length cannot be less than 4 and greater than 40"),
    LENGTH_CHARACTER_NOT_VALID("Length must contain numbers from 0 - 9 or more");

    final String message;

    ErrorMessages(String message) {
        this.message = message;
    }



}

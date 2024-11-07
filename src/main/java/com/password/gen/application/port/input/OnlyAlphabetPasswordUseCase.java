package com.password.gen.application.port.input;

import com.password.gen.domain.exception.PasswordGeneratorException;
import com.password.gen.domain.model.PasswordGeneratorDomain;

public interface OnlyAlphabetPasswordUseCase {
    PasswordGeneratorDomain generateOnlyAlphabetPassword(String length) throws PasswordGeneratorException;
}

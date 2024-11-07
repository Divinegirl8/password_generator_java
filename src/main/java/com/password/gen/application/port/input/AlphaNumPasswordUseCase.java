package com.password.gen.application.port.input;

import com.password.gen.domain.exception.PasswordGeneratorException;
import com.password.gen.domain.model.PasswordGeneratorDomain;

public interface AlphaNumPasswordUseCase {
    PasswordGeneratorDomain generateAlphaNumPassword(String length) throws PasswordGeneratorException;
}

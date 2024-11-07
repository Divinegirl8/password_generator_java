package com.password.gen.application.port.input;

import com.password.gen.domain.exception.PasswordGeneratorException;
import com.password.gen.domain.model.PasswordGeneratorDomain;

public interface AlphaSymbolPasswordUseCase {
    PasswordGeneratorDomain generateAlphaSymbolPassword(String length) throws PasswordGeneratorException;
}

package com.password.gen.application.port.output;

import com.password.gen.domain.exception.PasswordGeneratorException;
import com.password.gen.domain.model.PasswordGeneratorDomain;

public interface PasswordGeneratorOutputPort {
    PasswordGeneratorDomain save(PasswordGeneratorDomain passwordGeneratorDomain) throws PasswordGeneratorException;
}

package com.password.gen.infrastructure.adapter.output.persistent;

import com.password.gen.application.port.output.PasswordGeneratorOutputPort;
import com.password.gen.domain.exception.PasswordGeneratorException;
import com.password.gen.domain.model.PasswordGeneratorDomain;
import com.password.gen.domain.validator.ObjectValidator;
import com.password.gen.infrastructure.adapter.output.mapper.PasswordGeneratorMapper;
import com.password.gen.infrastructure.adapter.output.persistent.entity.PasswordGeneratorEntity;
import com.password.gen.infrastructure.adapter.output.persistent.repository.PasswordGeneratorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PasswordGeneratorPersistenceAdapter implements PasswordGeneratorOutputPort {
    private final PasswordGeneratorMapper passwordGeneratorMapper;
    private final PasswordGeneratorRepository passwordGeneratorRepository;

    @Override
    public PasswordGeneratorDomain save(PasswordGeneratorDomain passwordGeneratorDomain) throws PasswordGeneratorException {
        ObjectValidator.validate(passwordGeneratorDomain);
        PasswordGeneratorEntity passwordGeneratorEntity = passwordGeneratorMapper.toPasswordGeneratorEntity(passwordGeneratorDomain);
        passwordGeneratorEntity = passwordGeneratorRepository.save(passwordGeneratorEntity);
        return passwordGeneratorMapper.toPasswordGeneratorDomain(passwordGeneratorEntity);
    }
}

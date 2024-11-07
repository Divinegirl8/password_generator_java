package com.password.gen.infrastructure.adapter.output.mapper;

import com.password.gen.domain.model.PasswordGeneratorDomain;
import com.password.gen.infrastructure.adapter.output.persistent.entity.PasswordGeneratorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PasswordGeneratorMapper {
    PasswordGeneratorEntity toPasswordGeneratorEntity(PasswordGeneratorDomain passwordGeneratorDomain);
    PasswordGeneratorDomain toPasswordGeneratorDomain(PasswordGeneratorEntity passwordGeneratorEntity);
}

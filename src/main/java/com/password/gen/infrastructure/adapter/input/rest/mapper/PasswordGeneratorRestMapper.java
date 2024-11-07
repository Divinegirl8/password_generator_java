package com.password.gen.infrastructure.adapter.input.rest.mapper;

import com.password.gen.domain.model.PasswordGeneratorDomain;
import com.password.gen.infrastructure.adapter.input.rest.data.request.PasswordGeneratorRequest;
import com.password.gen.infrastructure.adapter.input.rest.data.response.PasswordGeneratorResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PasswordGeneratorRestMapper {
    PasswordGeneratorDomain toPasswordGeneratorDomain(PasswordGeneratorRequest passwordGeneratorRequest);
    PasswordGeneratorResponse toPasswordGeneratorResponse(PasswordGeneratorDomain passwordGeneratorDomain);
}

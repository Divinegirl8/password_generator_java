package com.password.gen.infrastructure.adapter.output.persistent.repository;

import com.password.gen.infrastructure.adapter.output.persistent.entity.PasswordGeneratorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PasswordGeneratorRepository extends MongoRepository<PasswordGeneratorEntity, String> {
}

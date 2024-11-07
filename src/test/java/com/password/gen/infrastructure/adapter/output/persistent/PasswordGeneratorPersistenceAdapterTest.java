package com.password.gen.infrastructure.adapter.output.persistent;

import com.password.gen.application.port.output.PasswordGeneratorOutputPort;
import com.password.gen.domain.exception.PasswordGeneratorException;
import com.password.gen.domain.model.PasswordGeneratorDomain;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class PasswordGeneratorPersistenceAdapterTest {
    @Autowired
    private PasswordGeneratorOutputPort passwordGeneratorOutputPort;
    private PasswordGeneratorDomain passwordGeneratorDomain;

    @BeforeEach
    void setUp(){
        passwordGeneratorDomain = PasswordGeneratorDomain.builder()
                .password("454ou_+r")
                .localDateTime(LocalDateTime.now())
                .build();
    }

    @Test
    void save(){
        try{
          PasswordGeneratorDomain savedGeneratedPassword =  passwordGeneratorOutputPort.save(passwordGeneratorDomain);
          log.info("saved password is {}", savedGeneratedPassword);
          assertNotNull(savedGeneratedPassword);
          assertEquals(passwordGeneratorDomain.getPassword(),savedGeneratedPassword.getPassword());
        }catch (PasswordGeneratorException passwordGeneratorException){
           log.info("{} {}",passwordGeneratorException.getClass().getName(), passwordGeneratorException.getMessage());
        }
    }

}
package com.password.gen.domain.validator;

import com.password.gen.domain.exception.LengthException;
import com.password.gen.domain.exception.PasswordGeneratorException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ObjectValidatorTest {


    @Test
    void lengthMatchesTheCondition(){
        try{
            ObjectValidator.validateLength("4");

        }catch (PasswordGeneratorException passwordGeneratorException){
            log.info("{} {}",passwordGeneratorException.getClass().getName(), passwordGeneratorException.getMessage());
        }
    }

    @Test
    void lengthIsLessThanFour(){
        assertThrows(LengthException.class, ()->ObjectValidator.validateLength("2"));
    }

    @Test
    void lengthIsGreaterThanForty(){
        assertThrows(LengthException.class, ()->ObjectValidator.validateLength("41"));
    }

    @Test
    void lengthIsEmpty(){
        assertThrows(PasswordGeneratorException.class, ()->ObjectValidator.validateLength(StringUtils.EMPTY));
    }

    @Test
    void lengthIsNull(){
        assertThrows(PasswordGeneratorException.class, ()->ObjectValidator.validateLength(null));
    }

    @Test
    void lengthIsNotANumber(){
        assertThrows(PasswordGeneratorException.class, ()->ObjectValidator.validateLength("iog"));
    }
    @Test
    void lengthIsANumberAndLetter(){
        assertThrows(PasswordGeneratorException.class, ()->ObjectValidator.validateLength("io8g9"));
    }
    @Test
    void lengthIsANumberAndSymbol(){
        assertThrows(PasswordGeneratorException.class, ()->ObjectValidator.validateLength("98#$76"));
    }
    @Test
    void lengthIsALetterAndSymbol(){
        assertThrows(PasswordGeneratorException.class, ()->ObjectValidator.validateLength("*(()Ndjm"));
    }



}
package com.password.gen.domain.service;

import com.password.gen.application.port.input.*;
import com.password.gen.domain.exception.PasswordGeneratorException;
import com.password.gen.domain.model.PasswordGeneratorDomain;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class PasswordGeneratorServiceTest {
    @Autowired
    private AllCharactersPasswordUseCase allCharactersPasswordUseCase;
    @Autowired
    private OnlyAlphabetPasswordUseCase onlyAlphabetPasswordUseCase;
    @Autowired
    private OnlyNumbersPasswordUseCase onlyNumbersPasswordUseCase;
    @Autowired
    private OnlySpecialCharacterPasswordUseCase onlySpecialCharacterPasswordUseCase;
    @Autowired
    private AlphaNumPasswordUseCase alphaNumPasswordUseCase;
    @Autowired
    private AlphaSymbolPasswordUseCase alphaSymbolPasswordUseCase;
    @Autowired
    private NumSymbolPasswordUseCase numSymbolPasswordUseCase;

    @Test
    void generateAllCharactersPassword(){
        try{
            String length = "5";
            PasswordGeneratorDomain generatedPassword = allCharactersPasswordUseCase.generateAllCharactersPassword(length);
            log.info("password generated =====> {}", generatedPassword);
            assertNotNull(generatedPassword);
            assertEquals(Integer.parseInt(length), generatedPassword.getPassword().length());
        }catch (PasswordGeneratorException passwordGeneratorException){
            log.info("{} {}", passwordGeneratorException.getClass().getName(), passwordGeneratorException.getMessage());
        }
    }

    @Test
    void generateAllCharactersPasswordWithEmptyLength(){
        assertThrows(PasswordGeneratorException.class, () -> allCharactersPasswordUseCase.generateAllCharactersPassword(StringUtils.EMPTY));
    }

    @Test
    void generateAllCharactersPasswordWithNullLength(){
        assertThrows(PasswordGeneratorException.class, () -> allCharactersPasswordUseCase.generateAllCharactersPassword(null));
    }

    @Test
    void generateAllCharactersPasswordWithLessThanFourLength(){
        assertThrows(PasswordGeneratorException.class, () -> allCharactersPasswordUseCase.generateAllCharactersPassword("3"));
    }

    @Test
    void generateAllCharactersPasswordWithMoreThanFortyLength(){
        assertThrows(PasswordGeneratorException.class, () -> allCharactersPasswordUseCase.generateAllCharactersPassword("100"));
    }

    @Test
    void generateAllCharactersPasswordWithLengthNotANumber(){
        assertThrows(PasswordGeneratorException.class, ()-> allCharactersPasswordUseCase.generateAllCharactersPassword("iog"));
    }
    @Test
    void generateAllCharactersPasswordWithLengthIsANumberAndLetter(){
        assertThrows(PasswordGeneratorException.class, ()->allCharactersPasswordUseCase.generateAllCharactersPassword("io8g9"));
    }
    @Test
    void generateAllCharactersPasswordWithLengthIsANumberAndSymbol(){
        assertThrows(PasswordGeneratorException.class, ()->allCharactersPasswordUseCase.generateAllCharactersPassword("98#$76"));
    }
    @Test
    void generateAllCharactersPasswordWithLengthIsALetterAndSymbol(){
        assertThrows(PasswordGeneratorException.class, ()->allCharactersPasswordUseCase.generateAllCharactersPassword("*(()Ndjm"));
    }

    @Test
    void generateAlphaBethContainedPassword(){
        try{
            String length = "40";
            PasswordGeneratorDomain generatedPassword = onlyAlphabetPasswordUseCase.generateOnlyAlphabetPassword(length);
            log.info("password generated =====> {}", generatedPassword);
            assertNotNull(generatedPassword);
            assertEquals(Integer.parseInt(length), generatedPassword.getPassword().length());
        }catch (PasswordGeneratorException passwordGeneratorException){
            log.info("{} {}", passwordGeneratorException.getClass().getName(), passwordGeneratorException.getMessage());
        }
    }


    @Test
    void generateAlphaBethContainedPasswordWithEmptyLength(){
        assertThrows(PasswordGeneratorException.class, () -> onlyAlphabetPasswordUseCase.generateOnlyAlphabetPassword(StringUtils.EMPTY));
    }

    @Test
    void generateAlphaBethContainedPasswordWithNullLength(){
        assertThrows(PasswordGeneratorException.class, () -> onlyAlphabetPasswordUseCase.generateOnlyAlphabetPassword(null));
    }

    @Test
    void generateAlphaBethContainedPasswordWithLessThanFourLength(){
        assertThrows(PasswordGeneratorException.class, () -> onlyAlphabetPasswordUseCase.generateOnlyAlphabetPassword("0"));
    }

    @Test
    void generateAlphaBethContainedPasswordWithMoreThanFortyLength(){
        assertThrows(PasswordGeneratorException.class, () -> onlyAlphabetPasswordUseCase.generateOnlyAlphabetPassword("100985640"));
    }

    @Test
    void generateAlphaBethContainedPasswordWithLengthNotANumber(){
        assertThrows(PasswordGeneratorException.class, ()-> onlyAlphabetPasswordUseCase.generateOnlyAlphabetPassword("pokjGFHK"));
    }
    @Test
    void generateAlphaBethContainedPasswordWithLengthIsANumberAndLetter(){
        assertThrows(PasswordGeneratorException.class, ()->onlyAlphabetPasswordUseCase.generateOnlyAlphabetPassword("AYNF8hdhn"));
    }
    @Test
    void generateAlphaBethContainedPasswordWithLengthIsANumberAndSymbol(){
        assertThrows(PasswordGeneratorException.class, ()->onlyAlphabetPasswordUseCase.generateOnlyAlphabetPassword("89##$980"));
    }
    @Test
    void generateAlphaBethContainedPasswordWithLengthIsALetterAndSymbol(){
        assertThrows(PasswordGeneratorException.class, ()->allCharactersPasswordUseCase.generateAllCharactersPassword("INStn&^"));
    }

    @Test
    void generateNumberContainedPassword(){
        try{
            String length = "28";
            PasswordGeneratorDomain generatedPassword = onlyNumbersPasswordUseCase.generateOnlyNumbersPassword(length);
            log.info("password generated =====> {}", generatedPassword);
            assertNotNull(generatedPassword);
            assertEquals(Integer.parseInt(length), generatedPassword.getPassword().length());
        }catch (PasswordGeneratorException passwordGeneratorException){
            log.info("{} {}", passwordGeneratorException.getClass().getName(), passwordGeneratorException.getMessage());
        }
    }

    @Test
    void generateSpecialCharacterContainedPassword(){
        try{
            String length = "20";
            PasswordGeneratorDomain generatedPassword = onlySpecialCharacterPasswordUseCase.generateOnlySpecialCharacterPassword(length);
            log.info("password generated =====> {}", generatedPassword);
            assertNotNull(generatedPassword);
            assertEquals(Integer.parseInt(length), generatedPassword.getPassword().length());
        }catch (PasswordGeneratorException passwordGeneratorException){
            log.info("{} {}", passwordGeneratorException.getClass().getName(), passwordGeneratorException.getMessage());
        }
    }

    @Test
    void generateAlphaNumContainedPassword(){
        try{
            String length = "35";
            PasswordGeneratorDomain generatedPassword = alphaNumPasswordUseCase.generateAlphaNumPassword(length);
            log.info("password generated =====> {}", generatedPassword);
            assertNotNull(generatedPassword);
            assertEquals(Integer.parseInt(length), generatedPassword.getPassword().length());
        }catch (PasswordGeneratorException passwordGeneratorException){
            log.info("{} {}", passwordGeneratorException.getClass().getName(), passwordGeneratorException.getMessage());
        }
    }

    @Test
    void generateAlphaSymbolContainedPassword(){
        try{
            String length = "25";
            PasswordGeneratorDomain generatedPassword = alphaSymbolPasswordUseCase.generateAlphaSymbolPassword(length);
            log.info("password generated =====> {}", generatedPassword);
            assertNotNull(generatedPassword);
            assertEquals(Integer.parseInt(length), generatedPassword.getPassword().length());
        }catch (PasswordGeneratorException passwordGeneratorException){
            log.info("{} {}", passwordGeneratorException.getClass().getName(), passwordGeneratorException.getMessage());
        }
    }

    @Test
    void generateNumSymbolContainedPassword(){
        try{
            String length = "15";
            PasswordGeneratorDomain generatedPassword = numSymbolPasswordUseCase.generateNumSymbolPasswordUseCase(length);
            log.info("password generated =====> {}", generatedPassword);
            assertNotNull(generatedPassword);
            assertEquals(Integer.parseInt(length), generatedPassword.getPassword().length());
        }catch (PasswordGeneratorException passwordGeneratorException){
            log.info("{} {}", passwordGeneratorException.getClass().getName(), passwordGeneratorException.getMessage());
        }
    }


}
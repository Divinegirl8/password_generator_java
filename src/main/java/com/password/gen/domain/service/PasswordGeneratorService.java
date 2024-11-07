package com.password.gen.domain.service;

import com.password.gen.application.port.input.*;
import com.password.gen.domain.exception.PasswordGeneratorException;
import com.password.gen.domain.model.PasswordGeneratorDomain;
import lombok.RequiredArgsConstructor;

import static com.password.gen.domain.validator.ObjectValidator.validateLength;

@RequiredArgsConstructor
public class PasswordGeneratorService implements AllCharactersPasswordUseCase,
        OnlyAlphabetPasswordUseCase, OnlyNumbersPasswordUseCase,
        OnlySpecialCharacterPasswordUseCase, AlphaNumPasswordUseCase,
        AlphaSymbolPasswordUseCase, NumSymbolPasswordUseCase
{
    private final String ALPHABET ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final String NUMBER ="0123456789";
    private final String SPECIAL_CHARACTER = "~`!@#$%^&*()_-+=}{[]\\|/><.\"\',:;";


    @Override
    public PasswordGeneratorDomain generateAllCharactersPassword(String length) throws PasswordGeneratorException {
        validateLength(length);
        int convertedLength = Integer.parseInt(length);
        StringBuilder password = new StringBuilder();

        for (int index = 0; index < convertedLength; index++) {
            if (index % 2 == 0) {
                int alphabetIndex = (int) Math.floor(Math.random() * ALPHABET.length());
                password.append(ALPHABET.charAt(alphabetIndex));

            } else if (index % 3 == 0) {
                int numberIndex = (int) Math.floor(Math.random() * NUMBER.length());
                password.append(NUMBER.charAt(numberIndex));
            } else {
                int specialCharacterIndex = (int) Math.floor(Math.random() * SPECIAL_CHARACTER.length());
                password.append(SPECIAL_CHARACTER.charAt(specialCharacterIndex));
            }
        }
        return  PasswordGeneratorDomain.builder()
                .password(password.toString())
                .build();


        }


    @Override
    public PasswordGeneratorDomain generateOnlyAlphabetPassword(String length) throws PasswordGeneratorException{
        validateLength(length);
        int convertedLength = Integer.parseInt(length);
        StringBuilder password = new StringBuilder();

        for (int index = 0; index < convertedLength; index++){
            int alphabetIndex = (int) Math.floor(Math.random() * ALPHABET.length());
            password.append(ALPHABET.charAt(alphabetIndex));
        }
        return  PasswordGeneratorDomain.builder()
                .password(password.toString())
                .build();
    }

    @Override
    public PasswordGeneratorDomain generateOnlyNumbersPassword(String length)  throws PasswordGeneratorException {
        validateLength(length);
        int convertedLength = Integer.parseInt(length);
        StringBuilder password = new StringBuilder();

        for (int index = 0; index < convertedLength; index++){
            int numberIndex = (int) Math.floor(Math.random() * NUMBER.length());
            password.append(NUMBER.charAt(numberIndex));
        }
        return  PasswordGeneratorDomain.builder()
                .password(password.toString())
                .build();
    }

    @Override
    public PasswordGeneratorDomain generateOnlySpecialCharacterPassword(String length) throws PasswordGeneratorException {
        validateLength(length);
        int convertedLength = Integer.parseInt(length);
        StringBuilder password = new StringBuilder();

        for (int index = 0; index < convertedLength; index++){
            int numberIndex = (int) Math.floor(Math.random() * SPECIAL_CHARACTER.length());
            password.append(SPECIAL_CHARACTER.charAt(numberIndex));
        }
        return  PasswordGeneratorDomain.builder()
                .password(password.toString())
                .build();
    }

    @Override
    public PasswordGeneratorDomain generateAlphaNumPassword(String length) throws PasswordGeneratorException {
        validateLength(length);
        int convertedLength = Integer.parseInt(length);
        StringBuilder password = new StringBuilder();

        for (int index = 0; index < convertedLength; index++) {
            if (index % 2 == 0) {
                int alphabetIndex = (int) Math.floor(Math.random() * ALPHABET.length());
                password.append(ALPHABET.charAt(alphabetIndex));

            }else {
                int specialCharacterIndex = (int) Math.floor(Math.random() * NUMBER.length());
                password.append(NUMBER.charAt(specialCharacterIndex));
            }

        }

        return  PasswordGeneratorDomain.builder()
                .password(password.toString())
                .build();
    }

    @Override
    public PasswordGeneratorDomain generateAlphaSymbolPassword(String length) throws PasswordGeneratorException {
        validateLength(length);
        int convertedLength = Integer.parseInt(length);
        StringBuilder password = new StringBuilder();

        for (int index = 0; index < convertedLength; index++) {
            if (index % 2 == 0) {
                int alphabetIndex = (int) Math.floor(Math.random() * ALPHABET.length());
                password.append(ALPHABET.charAt(alphabetIndex));

            }else {
                int specialCharacterIndex = (int) Math.floor(Math.random() * SPECIAL_CHARACTER.length());
                password.append(SPECIAL_CHARACTER.charAt(specialCharacterIndex));
            }

        }

        return  PasswordGeneratorDomain.builder()
                .password(password.toString())
                .build();
    }

    @Override
    public PasswordGeneratorDomain generateNumSymbolPasswordUseCase(String length) throws PasswordGeneratorException {
        validateLength(length);
        int convertedLength = Integer.parseInt(length);
        StringBuilder password = new StringBuilder();

        for (int index = 0; index < convertedLength; index++) {
            if (index % 2 == 0) {
                int alphabetIndex = (int) Math.floor(Math.random() * NUMBER.length());
                password.append(NUMBER.charAt(alphabetIndex));

            }else {
                int specialCharacterIndex = (int) Math.floor(Math.random() * SPECIAL_CHARACTER.length());
                password.append(SPECIAL_CHARACTER.charAt(specialCharacterIndex));
            }

        }

        return  PasswordGeneratorDomain.builder()
                .password(password.toString())
                .build();
    }
}

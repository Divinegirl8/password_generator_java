package com.password.gen.infrastructure.adapter.input.rest;

import com.password.gen.application.port.input.*;
import com.password.gen.domain.exception.PasswordGeneratorException;
import com.password.gen.domain.model.PasswordGeneratorDomain;
import com.password.gen.infrastructure.adapter.constants.SuccessMessages;
import com.password.gen.infrastructure.adapter.constants.SwaggerUiConstants;
import com.password.gen.infrastructure.adapter.constants.UrlConstants;
import com.password.gen.infrastructure.adapter.input.rest.data.request.PasswordGeneratorRequest;
import com.password.gen.infrastructure.adapter.input.rest.data.response.ApiResponse;
import com.password.gen.infrastructure.adapter.input.rest.data.response.PasswordGeneratorResponse;
import com.password.gen.infrastructure.adapter.input.rest.mapper.PasswordGeneratorRestMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(UrlConstants.PASSWORD_GENERATOR_URL)
public class PasswordGeneratorRestAdapter {

    private final AllCharactersPasswordUseCase allCharactersPasswordUseCase;
    private final AlphaNumPasswordUseCase alphaNumPasswordUseCase;
    private final AlphaSymbolPasswordUseCase alphaSymbolPasswordUseCase;
    private final NumSymbolPasswordUseCase numSymbolPasswordUseCase;
    private final OnlyAlphabetPasswordUseCase onlyAlphabetPasswordUseCase;
    private final OnlyNumbersPasswordUseCase onlyNumbersPasswordUseCase;
    private final OnlySpecialCharacterPasswordUseCase onlySpecialCharacterPasswordUseCase;
    private final PasswordGeneratorRestMapper passwordGeneratorRestMapper;

    @PostMapping("/allCharacter")
    @Operation(summary = SwaggerUiConstants.ALL_CHARACTER_PASSWORD_TITLE, description =
            SwaggerUiConstants.ALL_CHARACTER_PASSWORD_DESCRIPTION)
    public ResponseEntity<ApiResponse<?>> generateAllCharacterPassword(@RequestBody PasswordGeneratorRequest
            passwordGeneratorRequest) {
        try {
            PasswordGeneratorDomain passwordGeneratorDomain = passwordGeneratorRestMapper.toPasswordGeneratorDomain(passwordGeneratorRequest);
            passwordGeneratorDomain = allCharactersPasswordUseCase.generateAllCharactersPassword(passwordGeneratorDomain.getLength());
            PasswordGeneratorResponse terminalResponse = passwordGeneratorRestMapper.toPasswordGeneratorResponse(passwordGeneratorDomain);
            ApiResponse<PasswordGeneratorResponse> response = ApiResponse.<PasswordGeneratorResponse>builder().build();
            return new ResponseEntity<>(response.created(terminalResponse, SuccessMessages.SUCCESSFUL), HttpStatus.CREATED);
        }catch (PasswordGeneratorException passwordGeneratorException){
            ApiResponse<?> response = ApiResponse.badRequest(passwordGeneratorException.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/alphaNum")
    @Operation(summary = SwaggerUiConstants.ALPHANUM_PASSWORD_TITLE, description =
            SwaggerUiConstants.ALPHANUM__PASSWORD_DESCRIPTION)
    public ResponseEntity<ApiResponse<?>> generateAlphaNumPassword(@RequestBody PasswordGeneratorRequest
            passwordGeneratorRequest) {
        try {
            PasswordGeneratorDomain passwordGeneratorDomain = passwordGeneratorRestMapper.toPasswordGeneratorDomain(passwordGeneratorRequest);
            passwordGeneratorDomain = alphaNumPasswordUseCase.generateAlphaNumPassword(passwordGeneratorDomain.getLength());
            PasswordGeneratorResponse terminalResponse = passwordGeneratorRestMapper.toPasswordGeneratorResponse(passwordGeneratorDomain);
            ApiResponse<PasswordGeneratorResponse> response = ApiResponse.<PasswordGeneratorResponse>builder().build();
            return new ResponseEntity<>(response.created(terminalResponse, SuccessMessages.SUCCESSFUL), HttpStatus.CREATED);
        }catch (PasswordGeneratorException passwordGeneratorException){
            ApiResponse<?> response = ApiResponse.badRequest(passwordGeneratorException.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/alphaSymbol")
    @Operation(summary = SwaggerUiConstants.ALPHASYMBOL_PASSWORD_TITLE, description =
            SwaggerUiConstants.ALPHASYMBOL__PASSWORD_DESCRIPTION)
    public ResponseEntity<ApiResponse<?>> generateAlphaSymbolPassword(@RequestBody PasswordGeneratorRequest
            passwordGeneratorRequest) {
        try {
            PasswordGeneratorDomain passwordGeneratorDomain = passwordGeneratorRestMapper.toPasswordGeneratorDomain(passwordGeneratorRequest);
            passwordGeneratorDomain = alphaSymbolPasswordUseCase.generateAlphaSymbolPassword(passwordGeneratorDomain.getLength());
            PasswordGeneratorResponse terminalResponse = passwordGeneratorRestMapper.toPasswordGeneratorResponse(passwordGeneratorDomain);
            ApiResponse<PasswordGeneratorResponse> response = ApiResponse.<PasswordGeneratorResponse>builder().build();
            return new ResponseEntity<>(response.created(terminalResponse, SuccessMessages.SUCCESSFUL), HttpStatus.CREATED);
        }catch (PasswordGeneratorException passwordGeneratorException){
            ApiResponse<?> response = ApiResponse.badRequest(passwordGeneratorException.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/numSymbol")
    @Operation(summary = SwaggerUiConstants.NUMSYMBOL_PASSWORD_TITLE, description =
            SwaggerUiConstants.NUMSYMBOL_PASSWORD_DESCRIPTION)
    public ResponseEntity<ApiResponse<?>> generateNumSymbolPassword(@RequestBody PasswordGeneratorRequest
            passwordGeneratorRequest) {
        try {
            PasswordGeneratorDomain passwordGeneratorDomain = passwordGeneratorRestMapper.toPasswordGeneratorDomain(passwordGeneratorRequest);
            passwordGeneratorDomain = numSymbolPasswordUseCase.generateNumSymbolPasswordUseCase(passwordGeneratorDomain.getLength());
            PasswordGeneratorResponse terminalResponse = passwordGeneratorRestMapper.toPasswordGeneratorResponse(passwordGeneratorDomain);
            ApiResponse<PasswordGeneratorResponse> response = ApiResponse.<PasswordGeneratorResponse>builder().build();
            return new ResponseEntity<>(response.created(terminalResponse, SuccessMessages.SUCCESSFUL), HttpStatus.CREATED);
        }catch (PasswordGeneratorException passwordGeneratorException){
            ApiResponse<?> response = ApiResponse.badRequest(passwordGeneratorException.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/alphabet")
    @Operation(summary = SwaggerUiConstants.ALPHABET_PASSWORD_TITLE, description =
            SwaggerUiConstants.ALPHABET_PASSWORD_DESCRIPTION)
    public ResponseEntity<ApiResponse<?>> generateAlphabetPassword(@RequestBody PasswordGeneratorRequest
            passwordGeneratorRequest) {
        try {
            PasswordGeneratorDomain passwordGeneratorDomain = passwordGeneratorRestMapper.toPasswordGeneratorDomain(passwordGeneratorRequest);
            passwordGeneratorDomain = onlyAlphabetPasswordUseCase.generateOnlyAlphabetPassword(passwordGeneratorDomain.getLength());
            PasswordGeneratorResponse terminalResponse = passwordGeneratorRestMapper.toPasswordGeneratorResponse(passwordGeneratorDomain);
            ApiResponse<PasswordGeneratorResponse> response = ApiResponse.<PasswordGeneratorResponse>builder().build();
            return new ResponseEntity<>(response.created(terminalResponse, SuccessMessages.SUCCESSFUL), HttpStatus.CREATED);
        }catch (PasswordGeneratorException passwordGeneratorException){
            ApiResponse<?> response = ApiResponse.badRequest(passwordGeneratorException.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/numbers")
    @Operation(summary = SwaggerUiConstants.NUMBER_PASSWORD_TITLE, description =
            SwaggerUiConstants.NUMBER_PASSWORD_DESCRIPTION)
    public ResponseEntity<ApiResponse<?>> generateNumberPassword(@RequestBody PasswordGeneratorRequest
            passwordGeneratorRequest) {
        try {
            PasswordGeneratorDomain passwordGeneratorDomain = passwordGeneratorRestMapper.toPasswordGeneratorDomain(passwordGeneratorRequest);
            passwordGeneratorDomain = onlyNumbersPasswordUseCase.generateOnlyNumbersPassword(passwordGeneratorDomain.getLength());
            PasswordGeneratorResponse terminalResponse = passwordGeneratorRestMapper.toPasswordGeneratorResponse(passwordGeneratorDomain);
            ApiResponse<PasswordGeneratorResponse> response = ApiResponse.<PasswordGeneratorResponse>builder().build();
            return new ResponseEntity<>(response.created(terminalResponse, SuccessMessages.SUCCESSFUL), HttpStatus.CREATED);
        }catch (PasswordGeneratorException passwordGeneratorException){
            ApiResponse<?> response = ApiResponse.badRequest(passwordGeneratorException.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/specialCharacters")
    @Operation(summary = SwaggerUiConstants.SPECIAL_CHARACTER_PASSWORD_TITLE, description =
            SwaggerUiConstants.SPECIAL_CHARACTER_PASSWORD_DESCRIPTION)
    public ResponseEntity<ApiResponse<?>> generateSpecialCharacterPassword(@RequestBody PasswordGeneratorRequest
            passwordGeneratorRequest) {
        try {
            PasswordGeneratorDomain passwordGeneratorDomain = passwordGeneratorRestMapper.toPasswordGeneratorDomain(passwordGeneratorRequest);
            passwordGeneratorDomain = onlySpecialCharacterPasswordUseCase.generateOnlySpecialCharacterPassword(passwordGeneratorDomain.getLength());
            PasswordGeneratorResponse terminalResponse = passwordGeneratorRestMapper.toPasswordGeneratorResponse(passwordGeneratorDomain);
            ApiResponse<PasswordGeneratorResponse> response = ApiResponse.<PasswordGeneratorResponse>builder().build();
            return new ResponseEntity<>(response.created(terminalResponse, SuccessMessages.SUCCESSFUL), HttpStatus.CREATED);
        }catch (PasswordGeneratorException passwordGeneratorException){
            ApiResponse<?> response = ApiResponse.badRequest(passwordGeneratorException.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}

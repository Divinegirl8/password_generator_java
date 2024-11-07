package com.password.gen.domain.validator;


import com.password.gen.domain.constant.ErrorMessages;
import com.password.gen.domain.exception.LengthException;
import com.password.gen.domain.exception.PasswordGeneratorException;
import com.password.gen.domain.model.PasswordGeneratorDomain;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

import static com.password.gen.domain.constant.ErrorMessages.LENGTH_CHARACTER_NOT_VALID;
import static com.password.gen.domain.constant.ErrorMessages.LENGTH_NOT_VALID;

public class ObjectValidator {

    public static void validate(PasswordGeneratorDomain passwordGeneratorDomain) throws PasswordGeneratorException {
        if (passwordGeneratorDomain == null){
            throw new PasswordGeneratorException(ErrorMessages.NULL_OBJECT.getMessage());
        }
        validateInputElement(passwordGeneratorDomain.getPassword());
    }

    public static void validateInputElement(String element) throws PasswordGeneratorException {
        if (StringUtils.isEmpty(element) || StringUtils.isBlank(element)){
            throw new PasswordGeneratorException(ErrorMessages.EMPTY_FIELD.getMessage());
        }
    }

    public static void validateLength(String length) throws PasswordGeneratorException {
        validateInputElement(length);
        Pattern pattern = Pattern.compile("[0-9]{1,}");

        if (!pattern.matcher(length).matches()) {
            throw new LengthException(LENGTH_CHARACTER_NOT_VALID.getMessage());
        }
        int convertedLength = Integer.parseInt(length);
        if (convertedLength < 4 || convertedLength > 40) {
                throw new LengthException(LENGTH_NOT_VALID.getMessage());
        }



        }
}

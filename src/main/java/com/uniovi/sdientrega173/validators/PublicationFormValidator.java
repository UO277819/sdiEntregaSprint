package com.uniovi.sdientrega173.validators;

import com.uniovi.sdientrega173.entities.Publication;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PublicationFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Publication.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Publication publication = (Publication) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "Error.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "Error.empty");
    }
}

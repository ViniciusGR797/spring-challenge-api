package com.challengepay.challengepay.infra.utils.validation.document;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class DocumentValidator implements ConstraintValidator<Document, String> {

    @Override
    public boolean isValid(String document, ConstraintValidatorContext context) {
        if (document == null || document.isBlank()) {
            return false;
        } else if (document.length() != 11 && document.length() != 14) {
            return false;
        } 
        
        int[] validationPattern = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        if (document.length() == 14) {
            validationPattern = new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        }

        return validateDocument(document, validationPattern);
    }

    private boolean validateDocument(String document, int[] validationPattern) {
        for (int i = 1; i < document.length(); i++) {
            if (document.charAt(i) != document.charAt(0)) {
                break;
            }
            if (i == document.length() - 1) {
                return false;
            }
        }

        int sum = 0;
        for (int i = 0; i < document.length() - 2; i++) {
            sum += (document.charAt(i) - '0') * validationPattern[i + 1];
        }
        int digit1 = 11 - (sum % 11);
        if (digit1 > 9) {
            digit1 = 0;
        }

        sum = 0;
        for (int i = 0; i < document.length() - 1; i++) {
            sum += (document.charAt(i) - '0') * validationPattern[i];
        }
        int digit2 = 11 - (sum % 11);
        if (digit2 > 9) {
            digit2 = 0;
        }

        return (digit1 == (document.charAt(document.length() - 2) - '0')) && (digit2 == (document.charAt(document.length() - 1) - '0'));
    }
}

package com.inventory.eris.utils.validations.passwordconfirmation;

import com.inventory.eris.domain.administratives.office.Office;
import com.inventory.eris.domain.administratives.office.OfficeDao;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class PasswordConfirmationValidator implements ConstraintValidator<PasswordConfirmation, Object> {
    private static final SpelExpressionParser PARSER = new SpelExpressionParser();

    private final OfficeDao officeDao;

    private String[] fields;
    @Override
    public void initialize(PasswordConfirmation constraintAnnotation) {
        fields = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
//        List<Object> notNull = Stream.of(fields)
//                .map(field -> PARSER.parseExpression(field).getValue(value)).toList();
////        System.out.println(notNull);
//
//        String password = Objects.requireNonNull(PARSER.parseExpression(fields[0]).getValue(value)).toString();
//        System.out.println(password);
        return false;
    }


}

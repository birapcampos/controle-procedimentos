package br.com.birapcampos.procedimento.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {TrimStringValidator.class})
@Target({ FIELD })
@Retention(RUNTIME)
public @interface TrimString {

    String message() default "Este campos não pode conter espaços no inicio e no fim";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
package com.app.annotation;

import com.app.validator.UniqueCodeValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueCodeValidator.class)
@Documented
public @interface UniqueCode {
    String message() default "Borrow code does not exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

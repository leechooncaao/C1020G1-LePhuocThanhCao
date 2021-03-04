package com.app.validator;

import com.app.annotation.UniqueCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCodeValidator implements ConstraintValidator<UniqueCode, String> {
   public void initialize(UniqueCode constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {

      return false;
   }
}

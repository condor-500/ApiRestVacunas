package com.jefferson.apijefferson1.common;

import java.lang.annotation.Documented;

import java.lang.annotation.Retention;

import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = CedulaValidator.class)
@Documented

public @interface ValidaCedula {
    
  String message() default "{Cedula.Invalid}";


  Class<?>[] groups() default { };
  
  Class<? extends Payload>[] payload() default {};


}

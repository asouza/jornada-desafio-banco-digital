package com.deveficiente.bancodigital.novaproposta;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.deveficiente.bancodigital.compartilhado.UniqueValueValidator;

@Documented
@Constraint(validatedBy = {AgeValidator.class})
@Target({ FIELD,ElementType.PARAMETER})
@Retention(RUNTIME)
public @interface Age {

	String message() default "{com.deveficiente.beanvalidation.age}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	int greaterThan();	
}

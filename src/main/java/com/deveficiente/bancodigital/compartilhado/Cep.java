package com.deveficiente.bancodigital.compartilhado;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


/**
 * Copiado de https://github.com/demoiselle/validation/blob/master/impl/src/main/java/br/gov/frameworkdemoiselle/validation/annotation/Cep.java
 * @author frameworkdemoiselle
 *
 */
@Documented
@Target({ FIELD, METHOD })
@Retention(RUNTIME)
@Constraint(validatedBy = CepValidator.class)
public @interface Cep {

	Class<?>[] groups() default {};

	String message() default "{br.gov.frameworkdemoiselle.cep}";
	Class<? extends Payload>[] payload() default {};
	
}
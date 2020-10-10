package com.deveficiente.bancodigital.compartilhado;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Copiado de https://github.com/demoiselle/validation/blob/master/impl/src/main/java/br/gov/frameworkdemoiselle/validation/internal/validator/CepValidator.java
 * @author frameworkdemoiselle
 *
 */
public class CepValidator implements ConstraintValidator<Cep, String> {

	@Override
	public void initialize(final Cep constraintAnnotation) {
	}

	@Override
	public boolean isValid(String cep,
			final ConstraintValidatorContext context) {
		if (cep == null || "".equals(cep)) {
			return true;
		}
		Pattern pattern = Pattern.compile(
				"^(([0-9]{2}\\.[0-9]{3}-[0-9]{3})|([0-9]{2}[0-9]{3}-[0-9]{3})|([0-9]{8}))$");
		Matcher matcher = pattern.matcher(cep);
		return matcher.find();
	}

}
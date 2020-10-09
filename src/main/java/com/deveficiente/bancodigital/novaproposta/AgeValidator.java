package com.deveficiente.bancodigital.novaproposta;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, LocalDate>{

	private int greaterThan;

	@Override
	public void initialize(Age age) {
		this.greaterThan = age.greaterThan();
	}
	
	@Override
	public boolean isValid(LocalDate birthDate, ConstraintValidatorContext context) {
		int currentAge = Period.between(birthDate, LocalDate.now()).getYears();
		return currentAge >= greaterThan;
	}

}

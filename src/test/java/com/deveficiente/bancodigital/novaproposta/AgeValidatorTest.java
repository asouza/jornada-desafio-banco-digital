package com.deveficiente.bancodigital.novaproposta;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AgeValidatorTest {
	

	@Test
	@DisplayName("deveria validar que a data de nascimento é igual a permitida")
	void test1() throws Exception {		
		Age age = Mockito.mock(Age.class);
		Mockito.when(age.greaterThan()).thenReturn(18);
		AgeValidator ageValidator = new AgeValidator();
		ageValidator.initialize(age);
		
		LocalDate dezoitoAnos = LocalDate.now().minusYears(18);
		boolean valido = ageValidator.isValid(dezoitoAnos, null);
		
		Assertions.assertTrue(valido);
	}
	
	@Test
	@DisplayName("deveria validar que a data de nascimento é logo acima da permitida")
	void test2() throws Exception {		
		Age age = Mockito.mock(Age.class);
		Mockito.when(age.greaterThan()).thenReturn(18);
		AgeValidator ageValidator = new AgeValidator();
		ageValidator.initialize(age);
		
		LocalDate dezoitoAnos = LocalDate.now().minusYears(19);
		boolean valido = ageValidator.isValid(dezoitoAnos, null);
		
		Assertions.assertTrue(valido);
	}
	
	@Test
	@DisplayName("deveria bloquear data de nascimento é logo abaixo da permitida")
	void test3() throws Exception {		
		Age age = Mockito.mock(Age.class);
		Mockito.when(age.greaterThan()).thenReturn(18);
		AgeValidator ageValidator = new AgeValidator();
		ageValidator.initialize(age);
		
		LocalDate dezoitoAnos = LocalDate.now().minusYears(17);
		boolean valido = ageValidator.isValid(dezoitoAnos, null);
		
		Assertions.assertFalse(valido);
	}
}

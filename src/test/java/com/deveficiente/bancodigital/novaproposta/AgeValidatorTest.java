package com.deveficiente.bancodigital.novaproposta;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

public class AgeValidatorTest {
	
	@DisplayName("deveria validar que a data de nascimento é igual a permitida")
	@ParameterizedTest
	@CsvSource({
		"18,true","19,true","17,false","30,true","10,false"
	})
	void test1(int idade,boolean resultadoEsperado) throws Exception {		
		Age age = Mockito.mock(Age.class);
		Mockito.when(age.greaterThan()).thenReturn(18);
		AgeValidator ageValidator = new AgeValidator();
		ageValidator.initialize(age);
		
		LocalDate dezoitoAnos = LocalDate.now().minusYears(idade);
		boolean valido = ageValidator.isValid(dezoitoAnos, null);
		Assertions.assertEquals(resultadoEsperado,valido);
	}
}

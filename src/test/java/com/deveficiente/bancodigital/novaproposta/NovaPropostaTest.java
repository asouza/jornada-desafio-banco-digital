package com.deveficiente.bancodigital.novaproposta;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NovaPropostaTest {

	@Test
	@DisplayName("sem residencia a proposta não está completa")
	void teste1() throws Exception {
		NovaProposta novaProposta = new NovaProposta("87543895",
				LocalDate.of(2000, 1, 15), "email@email.com", "nome",
				"sobrenome");

		Assertions.assertFalse(novaProposta.completa());
	}

	@Test
	@DisplayName("com residencia e sem link para arquivo cpf a proposta não está completa")
	void teste2() throws Exception {
		NovaProposta novaProposta = new NovaProposta("87543895",
				LocalDate.of(2000, 1, 15), "email@email.com", "nome",
				"sobrenome");
		novaProposta.atualizaPasso2(new NovaPropostaResidencia("rua", "bairro",
				"895749853", "complemento", "cidade", "estado"));

		Assertions.assertFalse(novaProposta.completa());
	}
	
	@Test
	@DisplayName("com residencia e link para arquivo cpf a proposta está completa")
	void teste3() throws Exception {
		NovaProposta novaProposta = new NovaProposta("87543895",
				LocalDate.of(2000, 1, 15), "email@email.com", "nome",
				"sobrenome");
		novaProposta.atualizaPasso2(new NovaPropostaResidencia("rua", "bairro",
				"895749853", "complemento", "cidade", "estado"));
		
		novaProposta.atualizaPasso3("http://endereco.com.br");
		
		Assertions.assertTrue(novaProposta.completa());
	}
}

package com.deveficiente.bancodigital.novaproposta;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;

public class CriacaoPropostaControllerParte3Test {

	@Test
	@DisplayName("caso a proposta esteja completa simplesmente retorna a resposta")
	void teste1() throws Exception {
		NovaPropostaRepository novaPropostaRepository = Mockito
				.mock(NovaPropostaRepository.class);
		CriacaoPropostaControllerParte3 controller = new CriacaoPropostaControllerParte3(
				novaPropostaRepository);

		NovaProposta novaProposta = new NovaProposta("87543895",
				LocalDate.of(2000, 1, 15), "email@email.com", "nome",
				"sobrenome");
		novaProposta.atualizaPasso2(new NovaPropostaResidencia("rua", "bairro",
				"895749853", "complemento", "cidade", "estado"));
		novaProposta.atualizaPasso3("http://endereco.com.br");

		Mockito.when(novaPropostaRepository.findByCodigo("123456"))
				.thenReturn(Optional.of(novaProposta));

		//aqui não precisa de assert... 
		controller.versaoFinal("123456");
		
		
	}
	
	@Test
	@DisplayName("sem proposta completa, sem retorno")
	void teste2() throws Exception {
		NovaPropostaRepository novaPropostaRepository = Mockito
				.mock(NovaPropostaRepository.class);
		CriacaoPropostaControllerParte3 controller = new CriacaoPropostaControllerParte3(
				novaPropostaRepository);
		
		NovaProposta novaProposta = new NovaProposta("87543895",
				LocalDate.of(2000, 1, 15), "email@email.com", "nome",
				"sobrenome");
		
		Mockito.when(novaPropostaRepository.findByCodigo("123456"))
		.thenReturn(Optional.of(novaProposta));

		Assertions.assertThrows(ResponseStatusException.class, () -> {
			controller.versaoFinal("123456");			
		});
		
		
	}
}

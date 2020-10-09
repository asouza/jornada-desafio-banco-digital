package com.deveficiente.bancodigital.novaproposta;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriacaoPropostaController {
	
	/**
	 * Plano:
	 * Acumula passos do formulário
	 * Só cria a proposta de fato quando chegar no último passo
	 * 
	 */

	@PostMapping(value = "/api/nova-proposta/passo-1")
	public String passo1(@RequestBody @Valid NovaPropostaPasso1Request request) {
		return request.toString();
	}

}

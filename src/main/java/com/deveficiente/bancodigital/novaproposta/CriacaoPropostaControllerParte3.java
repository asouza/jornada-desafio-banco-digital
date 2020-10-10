package com.deveficiente.bancodigital.novaproposta;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
//14 -> Dividir em 2 classes
//5 -> dividir em 3, pq a dependência se repete entre classes
public class CriacaoPropostaControllerParte3 {

	/**
	 * Plano: Acumula passos do formulário Só cria a proposta de fato quando
	 * chegar no último passo
	 * 
	 */

	// 1
	private NovaPropostaRepository novaPropostaRepository;

	public CriacaoPropostaControllerParte3(
			NovaPropostaRepository novaPropostaRepository) {
		super();
		this.novaPropostaRepository = novaPropostaRepository;
	}

	@GetMapping(value = "/api/nova-proposta/{codigo}")
	// 1
	public DetalhePropostaResponse detalhe(
			@PathVariable("codigo") String codigo) {
		Optional<NovaProposta> possivelProposta = novaPropostaRepository
				.findByCodigo(codigo);

		// 1
		return possivelProposta.map(DetalhePropostaResponse::new).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	}

	@GetMapping(value = "/api/nova-proposta/{codigo}/versao-final")
	public DetalhePropostaResponse versaoFinal(
			@PathVariable("codigo") String codigo) {
		Optional<NovaProposta> possivelProposta = novaPropostaRepository
				.findByCodigo(codigo);

		// 1
		NovaProposta proposta = possivelProposta.orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		// 1
		if (!proposta.completa()) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
		}

		return new DetalhePropostaResponse(proposta);

	}

}

package com.deveficiente.bancodigital.novaproposta;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CriacaoPropostaController {

	/**
	 * Plano: Acumula passos do formulário Só cria a proposta de fato quando
	 * chegar no último passo
	 * 
	 */

	@Autowired
	private NovaPropostaRepository novaPropostaRepository;

	@PostMapping(value = "/api/nova-proposta/passo-1")
	@Transactional
	public NovaPropostaResponse passo1(
			@RequestBody @Valid NovaPropostaPasso1Request request) {
		NovaProposta novaProposta = request.criaNovaProposta();
		novaPropostaRepository.save(novaProposta);

		return new NovaPropostaResponse(novaProposta,"/api/nova-proposta/{codigo}/passo-2");
	}

	@PostMapping(value = "/api/nova-proposta/{codigo}/passo-2")
	@Transactional
	public NovaPropostaResponse passo2(
			@PathVariable("codigo") String codigo,
			@RequestBody @Valid NovaPropostaPasso2Request request) {
		Optional<NovaProposta> possivelProposta = novaPropostaRepository
				.findByCodigo(codigo);
		NovaProposta propostaEmAndamento = possivelProposta.orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		propostaEmAndamento.atualizaPasso2(request.criaResidencia());

		return new NovaPropostaResponse(propostaEmAndamento,"/api/nova-proposta/{codigo}/passo-3");
	}
	
	@PostMapping(value = "/api/nova-proposta/{codigo}/passo-3")
	@Transactional
	public NovaPropostaResponse passo3(
			@PathVariable("codigo") String codigo,
			@RequestBody @Valid NovaPropostaPasso3Request request) {
		Optional<NovaProposta> possivelProposta = novaPropostaRepository
				.findByCodigo(codigo);
		
		NovaProposta propostaEmAndamento = possivelProposta.orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		if(!propostaEmAndamento.getResidencia().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		propostaEmAndamento.atualizaPasso3(request.getLinkFrenteCpf());
		
		return new NovaPropostaResponse(propostaEmAndamento,"/api/nova-proposta/{codigo}/passo-4");
	}
	
	@GetMapping(value = "/api/nova-proposta/{codigo}")
	public DetalhePropostaResponse detalhe(
			@PathVariable("codigo") String codigo) {
		Optional<NovaProposta> possivelProposta = novaPropostaRepository
				.findByCodigo(codigo);

		return possivelProposta.map(DetalhePropostaResponse::new).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	}

}

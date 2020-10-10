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
//14 -> Dividir em 2 classes
public class CriacaoPropostaController {

	/**
	 * Plano: Acumula passos do formulário Só cria a proposta de fato quando
	 * chegar no último passo
	 * 
	 */

	@Autowired
	//1
	private NovaPropostaRepository novaPropostaRepository;

	@PostMapping(value = "/api/nova-proposta/passo-1")
	@Transactional
	//1
	public NovaPropostaResponse passo1(
			//1
			@RequestBody @Valid NovaPropostaPasso1Request request) {
		//1
		NovaProposta novaProposta = request.criaNovaProposta();
		novaPropostaRepository.save(novaProposta);

		return new NovaPropostaResponse(novaProposta,
				"/api/nova-proposta/{codigo}/passo-2");
	}

	@PostMapping(value = "/api/nova-proposta/{codigo}/passo-2")
	@Transactional
	public NovaPropostaResponse passo2(@PathVariable("codigo") String codigo,
			//1
			@RequestBody @Valid NovaPropostaPasso2Request request) {
		Optional<NovaProposta> possivelProposta = novaPropostaRepository
				.findByCodigo(codigo);
		//1
		NovaProposta propostaEmAndamento = possivelProposta.orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		//1 NovaPropostaResidencia
		propostaEmAndamento.atualizaPasso2(request.criaResidencia());

		return new NovaPropostaResponse(propostaEmAndamento,
				"/api/nova-proposta/{codigo}/passo-3");
	}

	@PostMapping(value = "/api/nova-proposta/{codigo}/passo-3")
	@Transactional
	public NovaPropostaResponse passo3(
			@PathVariable("codigo") String codigo,
			//1
			@RequestBody @Valid NovaPropostaPasso3Request request) {
		Optional<NovaProposta> possivelProposta = novaPropostaRepository
				.findByCodigo(codigo);
		
		//1
		NovaProposta propostaEmAndamento = possivelProposta.orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		//1
		propostaEmAndamento.getResidencia().orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY));
		
		propostaEmAndamento.atualizaPasso3(request.getLinkFrenteCpf());
		
		return new NovaPropostaResponse(propostaEmAndamento,"/api/nova-proposta/{codigo}/versao-final");
	}

	@GetMapping(value = "/api/nova-proposta/{codigo}")
	//1
	public DetalhePropostaResponse detalhe(
			@PathVariable("codigo") String codigo) {
		Optional<NovaProposta> possivelProposta = novaPropostaRepository
				.findByCodigo(codigo);

		//1
		return possivelProposta.map(DetalhePropostaResponse::new).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	}
	
	@GetMapping(value = "/api/nova-proposta/{codigo}/versao-final")
	public DetalhePropostaResponse versaoFinal(
			@PathVariable("codigo") String codigo) {
		Optional<NovaProposta> possivelProposta = novaPropostaRepository
				.findByCodigo(codigo);

		//1
		NovaProposta proposta = possivelProposta.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		//1
		if(!proposta.completa()) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		return new DetalhePropostaResponse(proposta);
				
	}

}

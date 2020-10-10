package com.deveficiente.bancodigital.novaproposta;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

//7 pontos
@RestController
public class CriacaoPropostaControllerParte1 {
	
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
}

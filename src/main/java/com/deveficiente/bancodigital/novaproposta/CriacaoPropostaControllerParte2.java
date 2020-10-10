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

@RestController
public class CriacaoPropostaControllerParte2 {

	@Autowired
	//1
	private NovaPropostaRepository novaPropostaRepository;

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
}

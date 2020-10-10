package com.deveficiente.bancodigital.novaproposta;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@Autowired
	private NovaPropostaRepository novaPropostaRepository;

	@PostMapping(value = "/api/nova-proposta/passo-1")
	@Transactional
	public NovaPropostaPasso1Response passo1(@RequestBody @Valid NovaPropostaPasso1Request request) {
		NovaProposta novaProposta = request.criaNovaProposta();
		novaPropostaRepository.save(novaProposta);
		
		return new NovaPropostaPasso1Response(novaProposta);
	}
	
	@GetMapping(value = "/api/nova-proposta/{codigo}")
	public ResponseEntity<DetalhePropostaResponse> detalhe(@PathVariable("codigo") String codigo) {
		Optional<NovaProposta> possivelProposta = novaPropostaRepository.findByCodigo(codigo);
		if(possivelProposta.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(new DetalhePropostaResponse(possivelProposta.get()));
	}

	


}

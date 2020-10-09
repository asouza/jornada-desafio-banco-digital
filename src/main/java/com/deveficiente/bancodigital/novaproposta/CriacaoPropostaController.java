package com.deveficiente.bancodigital.novaproposta;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class CriacaoPropostaController {
	
	/**
	 * Plano:
	 * Acumula passos do formulário
	 * Só cria a proposta de fato quando chegar no último passo
	 * 
	 */
	
	@Autowired
	private EntityManager manager;

	@PostMapping(value = "/api/nova-proposta/passo-1")
	@Transactional
	public ResponseEntity<?> passo1(@RequestBody @Valid NovaPropostaPasso1Request request,UriComponentsBuilder builder) {
		NovaProposta novaProposta = request.criaNovaProposta();
		manager.persist(novaProposta);
		
		URI proximoPasso = builder.path("/api/nova-proposta/{codigo}/passo-2").buildAndExpand(novaProposta.getCodigo()).toUri();
		return ResponseEntity.created(proximoPasso).build();
	}

}

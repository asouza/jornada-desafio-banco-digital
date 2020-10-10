package com.deveficiente.bancodigital.novaproposta;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

public class NovaPropostaResponse extends RepresentationModel<NovaPropostaResponse>{

	private String codigo;

	/**
	 * 
	 * @param novaProposta
	 * @param linkProximoPasso template do link de próximo passo. Importante que tenha {codigo} como variável. Ex: "/api/nova-proposta/{codigo}/passo-2"
	 */
	public NovaPropostaResponse(NovaProposta novaProposta,String linkProximoPasso) {
		this.codigo = novaProposta.getCodigo();
		this.add(Link.of(linkProximoPasso, "next").expand(this.codigo));
		this.add(Link.of("/api/nova-proposta/{codigo}").expand(this.codigo));
		
	}
	
	public String getCodigo() {
		return codigo;
	}

	
}

package com.deveficiente.bancodigital.novaproposta;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

public class NovaPropostaPasso1Response extends RepresentationModel<NovaPropostaPasso1Response>{

	private String codigo;

	public NovaPropostaPasso1Response(NovaProposta novaProposta) {
		this.codigo = novaProposta.getCodigo();
		this.add(Link.of("/api/nova-proposta/{codigo}/passo-2", "next").expand(this.codigo));
	}
	
	public String getCodigo() {
		return codigo;
	}

	
}

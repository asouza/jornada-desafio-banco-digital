package com.deveficiente.bancodigital.novaproposta;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonCreator;

public class NovaPropostaPasso3Request {

	@NotBlank
	@URL
	private String linkFrenteCpf;

	@JsonCreator
	public NovaPropostaPasso3Request(@NotBlank @URL String linkFrenteCpf) {
		this.linkFrenteCpf = linkFrenteCpf;
	}
	
	public String getLinkFrenteCpf() {
		return linkFrenteCpf;
	}

}

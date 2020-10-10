package com.deveficiente.bancodigital.novaproposta;

import javax.validation.constraints.NotBlank;

import com.deveficiente.bancodigital.compartilhado.Cep;

public class NovaPropostaPasso2Request {

	@NotBlank
	@Cep
	private String cep;
	@NotBlank
	private String rua;
	@NotBlank
	private String bairro;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotBlank
	private String estado;

	public NovaPropostaPasso2Request(@NotBlank String cep, @NotBlank String rua,
			@NotBlank String bairro, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank String estado) {
		super();
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public String getRua() {
		return rua;
	}

	public String getBairro() {
		return bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

}

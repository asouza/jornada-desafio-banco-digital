package com.deveficiente.bancodigital.novaproposta;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class NovaPropostaResidencia {

	private @NotBlank String rua;
	private @NotBlank String bairro;
	private @NotBlank String cep;
	private @NotBlank String complemento;
	private @NotBlank String cidade;
	private @NotBlank String estado;

	public NovaPropostaResidencia(@NotBlank String rua, @NotBlank String bairro,
			@NotBlank String cep, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank String estado) {
				this.rua = rua;
				this.bairro = bairro;
				this.cep = cep;
				this.complemento = complemento;
				this.cidade = cidade;
				this.estado = estado;
	}

	public String getRua() {
		return rua;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCep() {
		return cep;
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

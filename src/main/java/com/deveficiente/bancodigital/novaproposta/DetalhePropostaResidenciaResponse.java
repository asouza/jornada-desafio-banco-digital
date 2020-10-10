package com.deveficiente.bancodigital.novaproposta;

public class DetalhePropostaResidenciaResponse {

	private String bairro = "";
	private String cep = "";
	private String cidade = "";
	private String complemento = "";
	private String estado = "";

	public DetalhePropostaResidenciaResponse(
			NovaPropostaResidencia residencia) {
		bairro = residencia.getBairro();
		cep = residencia.getCep();
		cidade = residencia.getCidade();
		complemento = residencia.getComplemento();
		estado = residencia.getEstado();
	}

	public DetalhePropostaResidenciaResponse() {
	}

	public String getBairro() {
		return bairro;
	}

	public String getCep() {
		return cep;
	}

	public String getCidade() {
		return cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getEstado() {
		return estado;
	}

}

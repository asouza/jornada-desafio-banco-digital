package com.deveficiente.bancodigital.novaproposta;

import java.time.format.DateTimeFormatter;

public class DetalhePropostaResponse {

	private String cpf;
	private String dataNascimento;
	private String email;
	private String nome;
	private String sobrenome;
	private String instanteCriacao;
	private DetalhePropostaResidenciaResponse residencia;
	private String linkFrenteCpf;

	public DetalhePropostaResponse(NovaProposta novaProposta) {
		cpf = novaProposta.getCpf();
		dataNascimento = novaProposta.getDataNascimento()
				.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		email = novaProposta.getEmail();
		nome = novaProposta.getNome();
		sobrenome = novaProposta.getSobrenome();
		instanteCriacao = novaProposta.getInstanteCriacao()
				.format(DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm"));
		this.residencia = novaProposta.getResidencia()
				.map(DetalhePropostaResidenciaResponse::new)
				.orElse(new DetalhePropostaResidenciaResponse());
		linkFrenteCpf = novaProposta.getLinkFrenteCpf().orElse("");

	}

	public String getLinkFrenteCpf() {
		return linkFrenteCpf;
	}
	
	public DetalhePropostaResidenciaResponse getResidencia() {
		return residencia;
	}

	public String getCpf() {
		return cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getInstanteCriacao() {
		return instanteCriacao;
	}

}

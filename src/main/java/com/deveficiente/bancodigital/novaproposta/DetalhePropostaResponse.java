package com.deveficiente.bancodigital.novaproposta;

import java.time.format.DateTimeFormatter;

public class DetalhePropostaResponse {

	private String cpf;
	private String dataNascimento;
	private String email;
	private String nome;
	private String sobrenome;
	private String instanteCriacao;

	public DetalhePropostaResponse(NovaProposta novaProposta) {
		cpf = novaProposta.getCpf();
		dataNascimento = novaProposta.getDataNascimento()
				.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		email = novaProposta.getEmail();
		nome = novaProposta.getNome();
		sobrenome = novaProposta.getSobrenome();
		instanteCriacao = novaProposta.getInstanteCriacao()
				.format(DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm"));
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

package com.deveficiente.bancodigital.novaproposta;

import java.time.format.DateTimeFormatter;

public class DetalhePropostaResponse {

	private String cpf;
	private String dataNascimento;
	private String email;
	private String nome;
	private String sobrenome;
	private String instanteCriacao;
	private String bairro;
	private String cep;
	private String cidade;
	private String complemento;
	private String estado;

	public DetalhePropostaResponse(NovaProposta novaProposta) {
		cpf = novaProposta.getCpf();
		dataNascimento = novaProposta.getDataNascimento()
				.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		email = novaProposta.getEmail();
		nome = novaProposta.getNome();
		sobrenome = novaProposta.getSobrenome();
		instanteCriacao = novaProposta.getInstanteCriacao()
				.format(DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm"));
		bairro = novaProposta.getBairro().orElse("");
		cep = novaProposta.getCep().orElse("");
		cidade = novaProposta.getCidade().orElse("");
		complemento = novaProposta.getComplemento().orElse("");
		estado = novaProposta.getEstado().orElse("");
		
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

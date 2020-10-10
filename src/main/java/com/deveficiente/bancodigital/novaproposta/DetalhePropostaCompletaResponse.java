package com.deveficiente.bancodigital.novaproposta;

import org.springframework.util.Assert;

public class DetalhePropostaCompletaResponse {

	private String cpf;
	private String dataNascimento;
	private String email;
	private String nome;
	private String sobrenome;
	private String instanteCriacao;
	private DetalhePropostaResidenciaResponse residencia;
	private String linkFrenteCpf;

	public DetalhePropostaCompletaResponse(NovaProposta novaProposta) {
		Assert.isTrue(novaProposta.completa(),
				"Não rola gerar resposta de proposta completa sem ela estar completa");
		
		DetalhePropostaResponse detalhe = new DetalhePropostaResponse(novaProposta);
		cpf = detalhe.getCpf();
		dataNascimento = detalhe.getDataNascimento();
		email = detalhe.getEmail();
		nome = detalhe.getNome();
		sobrenome = detalhe.getSobrenome();
		instanteCriacao = detalhe.getInstanteCriacao();
		this.residencia = detalhe.getResidencia();
		linkFrenteCpf = detalhe.getLinkFrenteCpf();

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

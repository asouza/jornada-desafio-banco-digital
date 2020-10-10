package com.deveficiente.bancodigital.novaproposta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class NovaProposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@CPF
	private String cpf;
	@NotNull
	@Past
	@Age(greaterThan = 18)
	private LocalDate dataNascimento;
	@Email
	@NotBlank
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	private String codigo;
	private LocalDateTime instanteCriacao = LocalDateTime.now();
	private String cep;
	private String rua;
	private String bairro;
	private String complemento;
	private String cidade;
	private String estado;
	
	@Deprecated
	public NovaProposta() {

	}

	public NovaProposta(@Valid @NotNull NovaPropostaPasso1Request passo1) {
		cpf = passo1.getCpf();
		dataNascimento = passo1.getDataNascimento();
		email = passo1.getEmail();
		nome = passo1.getNome();
		sobrenome = passo1.getSobrenome();
		codigo = UUID.randomUUID().toString();
	}
	
	public LocalDateTime getInstanteCriacao() {
		return instanteCriacao;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
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



	public String getCodigo() {
		return codigo;
	}
	

	public Optional<String> getCep() {
		return Optional.ofNullable(cep);
	}

	public Optional<String> getRua() {
		return Optional.ofNullable(rua);
	}

	public Optional<String> getBairro() {
		return Optional.ofNullable(bairro);
	}

	public Optional<String> getComplemento() {
		return Optional.ofNullable(complemento);
	}

	public Optional<String> getCidade() {
		return Optional.ofNullable(cidade);
	}

	public Optional<String> getEstado() {
		return Optional.ofNullable(estado);
	}

	public void atualizaPasso2(@Valid NovaPropostaPasso2Request request) {
		this.cep = request.getCep();
		this.rua = request.getRua();
		this.bairro = request.getBairro();
		this.complemento = request.getComplemento();
		this.cidade = request.getCidade();
		this.estado = request.getEstado();
	}

}

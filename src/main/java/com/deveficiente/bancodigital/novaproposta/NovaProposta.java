package com.deveficiente.bancodigital.novaproposta;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

}

package com.deveficiente.bancodigital.novaproposta;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class NovaPropostaPasso1Request {

	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@Email
	private String email;
	@NotNull
	@Past
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	@CPF
	@NotBlank
	private String cpf;

	@JsonCreator
	public NovaPropostaPasso1Request(@NotBlank String nome,
			@NotBlank String sobrenome, @NotBlank @Email String email,
			@NotNull @Past @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy") LocalDate dataNascimento,
			@CPF @NotBlank String cpf) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "NovaPropostaPasso1Request [nome=" + nome + ", sobrenome="
				+ sobrenome + ", email=" + email + ", dataNascimento="
				+ dataNascimento + ", cpf=" + cpf + "]";
	}

	public NovaProposta criaNovaProposta() {
		return new NovaProposta(this);
	}

}

package com.deveficiente.bancodigital.novaproposta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.util.Assert;

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
	private String linkFrenteCpf;
	@Embedded
	@Valid
	private NovaPropostaResidencia residencia;

	@Deprecated
	public NovaProposta() {

	}


	public NovaProposta(@CPF @NotBlank String cpf,
			@NotNull @Past LocalDate dataNascimento,
			@NotBlank @Email String email, @NotBlank String nome,
			@NotBlank String sobrenome) {
				this.cpf = cpf;
				this.dataNascimento = dataNascimento;
				this.email = email;
				this.nome = nome;
				this.sobrenome = sobrenome;
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
	
	public Optional<NovaPropostaResidencia> getResidencia() {
		return Optional.ofNullable(residencia);
	}

	public Optional<String> getLinkFrenteCpf() {
		return Optional.ofNullable(linkFrenteCpf);
	}

	public void atualizaPasso2(@Valid NovaPropostaResidencia residencia) {
		this.residencia = residencia;
	}

	/**
	 * 
	 * @param linkFrenteCpf
	 */
	public void atualizaPasso3(@NotBlank @URL String linkFrenteCpf) {
		Assert.state(this.getResidencia().isEmpty(),
				"A residência precisa estar preenchida");
		this.linkFrenteCpf = linkFrenteCpf;
	}

}

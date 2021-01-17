package org.generation.brazil.hotel.model;

import javax.persistence.Column; 
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

// anotation determina um comportamento da classe
@Entity
// criando uma tabela no banco
@Table(name = "tb_usuario")
public class Usuario {
	// atributos
	
	// criando uma coluna no banco de dados
	@Column(name = "cd_usuario")
	// especificando a chave primaria da entidade
	@Id
	// gerando o valor automaticamente
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	// criando uma coluna no banco de dados
	@Column(name = "nm_usuario", nullable = false, length = 80)
	// não recebe um valor nulo
	@NotNull
	// tamanho de caracteres 
	@Size(min = 2, max = 80)
	private String nome;

	// criando uma coluna no banco de dados
	@Column(name = "nm_email", nullable = false, length = 100)
	// não recebe um valor nulo
	@NotNull
	// informa que é um email
	@Email
	private String email;

	// criando uma coluna no banco de dados
	@Column(name = "nm_senha", nullable = false, length = 15)
	// não recebe um valor nulo
	@NotNull
	// tamanho de caracteres 
	@Size(min = 6, max = 15)
	private String senha;

	// getters - setters
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
		
}

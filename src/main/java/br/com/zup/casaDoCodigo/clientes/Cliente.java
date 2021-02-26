package br.com.zup.casaDoCodigo.clientes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casaDoCodigo.paiseestado.Estado;
import br.com.zup.casaDoCodigo.paiseestado.Pais;
import br.com.zup.casaDoCodigo.validacoes.CpfOuCnpj;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Email
	@NotBlank
	@Column(unique = true)
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@CpfOuCnpj
	@NotBlank
	@Column(unique = true)
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	@ManyToOne
	private Pais pais;
	@NotNull
	@ManyToOne
	private Estado estado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	
	@Deprecated
	public Cliente() {
	}

	public Cliente(@NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank Pais pais, Estado estado, @NotBlank String telefone,
			@NotBlank String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
		this.telefone = telefone;
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", documento="
				+ documento + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade
				+ ", pais=" + pais + ", estado=" + estado + ", telefone=" + telefone + ", cep=" + cep + "]";
	}
}
package br.com.zup.casaDoCodigo.autores;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.casaDoCodigo.compartilhado.UniqueValue;

public class AutorForm {
	@NotBlank
	private	String nome;
	@Email 
	@NotBlank 
    @UniqueValue(domainClass = Autor.class, fieldName = "email", message = "E-mail já cadastrado")
	private String email;
	@NotBlank 
	@Size(max=400)
	private	String descricao;
	 
	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getEmail() {
		return email;
	}
	
	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}
}
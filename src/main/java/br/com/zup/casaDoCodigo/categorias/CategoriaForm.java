package br.com.zup.casaDoCodigo.categorias;

import javax.validation.constraints.NotBlank;

import br.com.zup.casaDoCodigo.validacoes.UniqueValue;

public class CategoriaForm {

	@NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Categoria já cadastrada")
	private String nome;

	public String getNome() {
		return nome;
	}

	public Categoria toModel() {
		return new Categoria(nome);
	}
}
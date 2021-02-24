package br.com.zup.casaDoCodigo.categorias;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.zup.casaDoCodigo.compartilhado.UniqueValue;

public class CategoriaForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Categoria já cadastrada")
	private String nome;

	public String getNome() {
		return nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}
}
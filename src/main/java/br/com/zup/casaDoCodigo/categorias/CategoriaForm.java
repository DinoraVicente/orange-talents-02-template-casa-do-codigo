package br.com.zup.casaDoCodigo.categorias;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.zup.casaDoCodigo.validacoes.UniqueValue;

public class CategoriaForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Categoria já cadastrada")
	private String nome;

    @Deprecated
	public CategoriaForm() {
	}
    
	public CategoriaForm(Categoria categoria) {
		this.nome = categoria.getNome();
	}

	public String getNome() {
		return nome;
	}

	public Categoria toModel() {
		return new Categoria(nome);
	}
}
package br.com.zup.casaDoCodigo.detalhesite;

import br.com.zup.casaDoCodigo.autores.Autor;

public class DetalhesSiteAutores {
	private String nome;
	private String descricao;
	
	@Deprecated
	public DetalhesSiteAutores() {}
	
	public DetalhesSiteAutores(Autor autor) {
		nome = autor.getNome();
		descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
}
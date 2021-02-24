package br.com.zup.casaDoCodigo.detalhesite;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import br.com.zup.casaDoCodigo.livros.Livro;

public class DetalhesSiteLivros {

	private DetalhesSiteAutores autor;
	private String titulo;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	private Integer paginas;
	private String isbn;
	private String dataPublicacao;
	
	@Deprecated
	public DetalhesSiteLivros() {}
	
	public DetalhesSiteLivros(Livro livro) {
		autor = new DetalhesSiteAutores(livro.getAutor());
		titulo = livro.getTitulo();
		preco = livro.getPreco();
		resumo = livro.getResumo();
		sumario = livro.getSumario();
		paginas = livro.getPaginas();
		isbn = livro.getIsbn();
		dataPublicacao = livro.getDataPublicacao()
				.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public DetalhesSiteAutores getAutor() {
		return autor;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}
}
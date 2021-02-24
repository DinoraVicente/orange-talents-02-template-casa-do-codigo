package br.com.zup.casaDoCodigo.livros;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zup.casaDoCodigo.autores.Autor;
import br.com.zup.casaDoCodigo.categorias.Categoria;
import br.com.zup.casaDoCodigo.compartilhado.ExistsId;
import br.com.zup.casaDoCodigo.compartilhado.UniqueValue;

public class LivroForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "Título já cadastrado")
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumo;
	@NotBlank
	private String sumario;
	@NotNull 
	@Min(value = 20, message = "Preço mínimo: 20")
	private BigDecimal preco;
	@NotNull 
	@Min(value = 100, message = "Mínimo são 100 páginas")
	private Integer paginas;
	@NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "ISBN já cadastrado")
	private String isbn;
    @NotNull
    @Future(message = "Deve ser uma data futura")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataPublicacao;
    @Valid
    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id", message = "Categoria não existe")
	private Long idCategoria;
    @Valid
	@NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id", message = "Autor não existe")
	private Long idAutor;
	
    @Deprecated
	public LivroForm() {
	}

	public LivroForm(@NotBlank String titulo, @NotBlank String resumo, @NotBlank String sumario,
			@NotNull BigDecimal preco,
			@NotNull Integer paginas, String isbn,
			@Future LocalDate dataPublicacao, @NotNull @Valid Long idCategoria,
			@NotNull @Valid Long idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	/*
	 * setter criado pois o jackson não estava sendo capaz de desseralizar
	 * o json com a data no parâmetro pelo construtor.
	 */
	
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Livro toModel(EntityManager manager) {
        @NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);
        @NotNull Autor autor = manager.find(Autor.class, idAutor);
        
        Assert.state(autor!=null, "Autor não existe!");
        Assert.state(categoria!=null, "Categoria não existe!");

        return new Livro(titulo, resumo, sumario, preco, paginas, isbn, dataPublicacao, categoria, autor);
    }
}
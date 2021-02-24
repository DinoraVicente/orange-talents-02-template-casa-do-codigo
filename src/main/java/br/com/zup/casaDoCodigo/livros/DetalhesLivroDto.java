package br.com.zup.casaDoCodigo.livros;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import br.com.zup.casaDoCodigo.validacoes.UniqueValue;

public class DetalhesLivroDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "Título já cadastrado")
	private String titulo;
	
	@Deprecated
	public DetalhesLivroDto() {
	}
	
	public DetalhesLivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
}

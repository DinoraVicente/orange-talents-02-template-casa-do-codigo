package br.com.zup.casaDoCodigo.livros;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping(value = "/livros")
	@Transactional
	public String cadastrar(@RequestBody @Valid LivroForm form) {
		Livro livro = form.toModel(manager);
		manager.persist(livro);
		return livro.toString();
	}
	
	@GetMapping(value = "/livros/{id}")
	public DetalhesLivroDto listaLivros(@PathVariable Long id) {
		Livro livro = manager.find(Livro.class, id);
		return new DetalhesLivroDto(livro);
	}
}
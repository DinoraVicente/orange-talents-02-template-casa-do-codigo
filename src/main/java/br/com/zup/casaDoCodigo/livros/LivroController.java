package br.com.zup.casaDoCodigo.livros;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	public DetalhesLivroDto listaLivroBuscado(@PathVariable Long id) {
		Livro livro = Optional.ofNullable(manager.find(Livro.class, id))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return new DetalhesLivroDto(livro);
	}
	
	@GetMapping("/lista-livros")
	public List<?> listaLivros() {
		Query livro = manager.createQuery("Select l from Livro l");
		
		return livro.getResultList();
	}

}